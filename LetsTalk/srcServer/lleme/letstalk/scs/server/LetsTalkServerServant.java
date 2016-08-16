package lleme.letstalk.scs.server;

import lleme.letstalk.LetsTalkServer;
import lleme.letstalk.scs.IComponentPOAImpl;
import lleme.letstalk.scs.node.ContainerServant;

import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.letstalk.CommFacet;
import corbaObjects.letstalk.ServerCallBackFacet;
import corbaObjects.letstalk.ServerCallBackFacetHelper;
import corbaObjects.letstalk.UserFacet;
import corbaObjects.letstalk.usermanager.UserManagerFacet;
import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.FacetDescription;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.ReceptacleDescription;

public class LetsTalkServerServant extends IComponentPOAImpl implements
		Runnable {

	private Thread thread = null;

	private ContainerServant container = null;

	private int version = 0;

	@SuppressWarnings("unused")
	public LetsTalkServerServant(ORB orb, ContainerServant container,
			LetsTalkServer appWindow, int version) throws ServantNotActive,
			WrongPolicy, org.omg.CORBA.ORBPackage.InvalidName, IOException {

		this.container = container;
		this.version = version;

		POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		ReceptacleDescription receptacle = null;
		// Primeiro receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "serverCallBackFacetReceptacle";
		receptacle.interface_name = ServerCallBackFacet.class.getName();
		receptacle.is_multiplex = true;
		receptacle.connections = new ConnectionDescription[100];
		_putReceptacle(receptacle.name, receptacle);

		// Segundo receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "userManagerFacetReceptacle";
		receptacle.interface_name = UserManagerFacet.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[100];
		_putReceptacle(receptacle.name, receptacle);

		// Terceiro receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "componentCollection";
		receptacle.interface_name = ComponentCollection.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Primeira faceta
		FacetDescription facet = new FacetDescription();
		facet.name = "userFacet";
		facet.interface_name = UserFacet.class.getName();
		ServerUserFacetServant facet1Servant = new ServerUserFacetServant(this);
		facet.facet_ref = poa.servant_to_reference(facet1Servant);
		_putFacet(facet.name, facet);

		// Segunda faceta
		facet = new FacetDescription();
		facet.name = "commFacet";
		facet.interface_name = CommFacet.class.getName();
		ServerCommFacetServant facet2Servant = new ServerCommFacetServant(this,
				facet1Servant);
		facet.facet_ref = poa.servant_to_reference(facet2Servant);
		_putFacet(facet.name, facet);

		// Iniciar atualização de clientes
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void run() {
		Thread myThread = Thread.currentThread();
		while (thread == myThread) {
			try {
				wait();
				updateUsers();
			} catch (InterruptedException e) {

			} catch (Throwable e) {

			}
		}
	}

	private synchronized void updateUsers() {
		ReceptacleDescription directory = _getReceptacle("serverCallBackFacetReceptacle");
		for (int i = 0; i < directory.connections.length; i++) {
			if (directory.connections[i] != null)
				try {
					ServerCallBackFacetHelper.narrow(
							directory.connections[i].objref).updateDirectory();
				} catch (Throwable e) {
					directory.connections[i] = null;
				}
		}
	}

	public ConnectionDescription[] getReceptacleConnections(
			String receptacle_interface) throws InvalidName, InvalidConnection,
			AlreadyConnected, ExceededConnectionLimit, InternalError {
		ConnectionDescription[] connections = super
				.getReceptacleConnections(receptacle_interface);

		if (receptacle_interface.equals(UserManagerFacet.class.getName())) {
			if (connections[0] == null) {
				NamingContextExt nc = null;
				try {
					nc = NamingContextExtHelper.narrow(this._orb()
							.resolve_initial_references("TNameService"));
					connect("userManagerFacetReceptacle", nc.resolve(nc
							.to_name("userManager")));
				} catch (org.omg.CORBA.ORBPackage.InvalidName e) {
					throw new InternalError();
				} catch (InvalidName e) {
					throw new InternalError();
				} catch (InvalidConnection e) {
					throw new InternalError();
				} catch (AlreadyConnected e) {
					throw new InternalError();
				} catch (ExceededConnectionLimit e) {
					throw new InternalError();
				} catch (NotFound e) {
					throw new InternalError();
				} catch (CannotProceed e) {
					throw new InternalError();
				} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
					throw new InternalError();
				}
			} else if (connections[0].objref._non_existent()) {

			}
			return super.getReceptacleConnections(receptacle_interface);
		}
		return connections;
	}
}
