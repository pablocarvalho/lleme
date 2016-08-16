package lleme.letstalk.scs.client;

import lleme.letstalk.LetsTalk;
import lleme.letstalk.scs.IComponentPOAImpl;
import lleme.letstalk.scs.node.ContainerServant;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.letstalk.CommFacet;
import corbaObjects.letstalk.ServerCallBackFacet;
import corbaObjects.letstalk.UserFacet;
import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ComponentCollectionHelper;
import corbaObjects.scs.ComponentHandle;
import corbaObjects.scs.ComponentId;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.FacetDescription;
import corbaObjects.scs.IComponent;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.ReceptacleDescription;

public class LetsTalkServant extends IComponentPOAImpl {

	private ContainerServant container = null;

	private int version = 0;

	public LetsTalkServant(ORB orb, ContainerServant container,
			LetsTalk appWindow, int version) throws ServantNotActive,
			WrongPolicy, org.omg.CORBA.ORBPackage.InvalidName {

		this.container = container;
		this.version = version;

		POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		// Primeiro receptacle
		ReceptacleDescription receptacle = new ReceptacleDescription();
		receptacle.name = "userFacetReceptacle";
		receptacle.interface_name = UserFacet.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Segundo receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "commFacetReceptacle";
		receptacle.interface_name = CommFacet.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Terceiro receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "componentCollection";
		receptacle.interface_name = ComponentCollection.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		FacetDescription facet = null;
		// Primeira faceta
		facet = new FacetDescription();
		facet.name = "userFacet";
		facet.interface_name = UserFacet.class.getName();
		ClientUserFacetServant facet2Servant = new ClientUserFacetServant(this);
		facet.facet_ref = poa.servant_to_reference(facet2Servant);
		_putFacet(facet.name, facet);

		// Segunda faceta
		facet = new FacetDescription();
		facet.name = "serverCallBackFacet";
		facet.interface_name = ServerCallBackFacet.class.getName();
		ServerCallBackFacetServant facet1Servant = new ServerCallBackFacetServant(
				this, facet2Servant, appWindow);
		facet.facet_ref = poa.servant_to_reference(facet1Servant);
		_putFacet(facet.name, facet);

		// Terceira faceta
		facet = new FacetDescription();
		facet.name = "commFacet";
		facet.interface_name = CommFacet.class.getName();
		ClientCommFacetServant facet3Servant = new ClientCommFacetServant(this,
				facet2Servant);
		facet.facet_ref = poa.servant_to_reference(facet3Servant);
		_putFacet(facet.name, facet);
	}

	public ConnectionDescription[] getReceptacleConnections(
			String receptacle_interface) throws InvalidName, InvalidConnection,
			AlreadyConnected, ExceededConnectionLimit {
		ConnectionDescription[] connections = super
				.getReceptacleConnections(receptacle_interface);

		ConnectionDescription[] collectionDesc = null;
		ComponentCollection collection = null;
		ComponentId id = new ComponentId();
		id.name = "LetsTalkServer";
		id.version = this.version;
		ComponentHandle[] handle = null;
		IComponent letstalkServer = null;
		org.omg.CORBA.Object userFacet = null;
		org.omg.CORBA.Object commFacet = null;

		if (!receptacle_interface.equals(ComponentCollection.class.getName())) {
			if (connections[0] == null) {
				collectionDesc = super
						.getReceptacleConnections(ComponentCollection.class
								.getName());
				collection = ComponentCollectionHelper
						.narrow(collectionDesc[0].objref);
				handle = collection.getComponent(id);
				letstalkServer = handle[0].cmp;
				userFacet = letstalkServer.getFacet(UserFacet.class.getName());
				commFacet = letstalkServer.getFacet(CommFacet.class.getName());
				connect("userFacetReceptacle", userFacet);
				connect("commFacetReceptacle", commFacet);

			} else if (connections[0].objref._non_existent()) {

			}
			return super.getReceptacleConnections(receptacle_interface);
		}
		return connections;
	}
}
