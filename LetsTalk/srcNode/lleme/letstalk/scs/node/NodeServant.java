package lleme.letstalk.scs.node;

import lleme.letstalk.scs.IComponentPOAImpl;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ComponentHelp;
import corbaObjects.scs.ComponentNotFound;
import corbaObjects.scs.ComponentRepository;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.ExecutionNode;
import corbaObjects.scs.FacetDescription;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.NoConnection;
import corbaObjects.scs.NodeRegister;
import corbaObjects.scs.NodeRegisterHelper;
import corbaObjects.scs.Property;
import corbaObjects.scs.ReceptacleDescription;

public class NodeServant extends IComponentPOAImpl {

	public NodeServant(ORB orb) throws ServantNotActive, WrongPolicy,
			org.omg.CORBA.ORBPackage.InvalidName {
		POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		// Primeiro receptacle
		ReceptacleDescription receptacle = new ReceptacleDescription();
		receptacle.name = "componentRepositoryReceptacle";
		receptacle.interface_name = ComponentRepository.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Segundo receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "nodeRegisterReceptacle";
		receptacle.interface_name = NodeRegister.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Terceiro receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "namingContextExtReceptacle";
		receptacle.interface_name = NamingContextExt.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Quarto receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "componentCollectionReceptacle";
		receptacle.interface_name = ComponentCollection.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Quinto receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "componentHelpReceptacle";
		receptacle.interface_name = ComponentHelp.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Primeira faceta
		FacetDescription facet = new FacetDescription();
		facet.name = "executionNode";
		facet.interface_name = ExecutionNode.class.getName();
		ExecutionNodeServant facet1Servant = new ExecutionNodeServant(this);
		facet.facet_ref = poa.servant_to_reference(facet1Servant);
		_putFacet(facet.name, facet);

		// Segunda faceta
		facet = new FacetDescription();
		facet.name = "componentRepository";
		facet.interface_name = ComponentRepository.class.getName();
		facet.facet_ref = null;
		_putFacet(facet.name, facet);

		// Terceira faceta
		facet = new FacetDescription();
		facet.name = "componentCollection";
		facet.interface_name = ComponentCollection.class.getName();
		facet.facet_ref = null;
		_putFacet(facet.name, facet);

		// Quarta faceta
		facet = new FacetDescription();
		facet.name = "componentHelp";
		facet.interface_name = ComponentHelp.class.getName();
		facet.facet_ref = null;
		_putFacet(facet.name, facet);
	}

	public synchronized int connect(String receptacle, Object obj)
			throws InvalidName, InvalidConnection, AlreadyConnected,
			ExceededConnectionLimit {
		int result = super.connect(receptacle, obj);
		FacetDescription facet = null;
		if (receptacle.equals("componentRepositoryReceptacle")) {
			facet = new FacetDescription();
			facet.name = "componentRepository";
			facet.interface_name = ComponentRepository.class.getName();
			facet.facet_ref = obj;
			_putFacet(facet.name, facet);
		} else if (receptacle.equals("componentCollectionReceptacle")) {
			facet = new FacetDescription();
			facet.name = "componentCollection";
			facet.interface_name = ComponentCollection.class.getName();
			facet.facet_ref = obj;
			_putFacet(facet.name, facet);
		} else if (receptacle.equals("componentHelpReceptacle")) {
			facet = new FacetDescription();
			facet.name = "componentHelp";
			facet.interface_name = ComponentHelp.class.getName();
			facet.facet_ref = obj;
			_putFacet(facet.name, facet);
		} else if (receptacle.equals("nodeRegisterReceptacle")) {
			Property[] props = new Property[6];
			int i = 0;
			props[i] = new Property();
			props[i].name = "os.arch";
			props[i].value = System.getProperty("os.arch");
			props[++i] = new Property();
			props[i].name = "os.name";
			props[i].value = System.getProperty("os.name");
			props[++i] = new Property();
			props[i].name = "os.version";
			props[i].value = System.getProperty("os.version");
			props[++i] = new Property();
			props[i].name = "java.vendor";
			props[i].value = System.getProperty("java.vendor");
			props[++i] = new Property();
			props[i].name = "java.vendor.url";
			props[i].value = System.getProperty("java.vendor.url");
			props[++i] = new Property();
			props[i].name = "java.version";
			props[i].value = System.getProperty("java.version");
			NodeRegister register = NodeRegisterHelper.narrow(obj);
			register.register(this._this(), props);
		}
		return result;
	}

	public synchronized void disconnect(int connectionId) {
		try {
			NodeRegisterHelper
					.narrow(
							_getReceptacle("nodeRegisterReceptacle").connections[0].objref)
					.unregister(_this());
			super.disconnect(connectionId);
		} catch (ComponentNotFound e) {
			e.printStackTrace();
		} catch (InvalidConnection e) {
			e.printStackTrace();
		} catch (NoConnection e) {
			e.printStackTrace();
		} finally {

		}
	}
}
