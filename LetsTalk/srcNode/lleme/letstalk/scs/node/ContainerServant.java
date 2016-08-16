package lleme.letstalk.scs.node;

import lleme.letstalk.scs.ComponentHelpServant;
import lleme.letstalk.scs.IComponentPOAImpl;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ComponentHelp;
import corbaObjects.scs.ComponentLoader;
import corbaObjects.scs.ComponentRepository;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.FacetDescription;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.ReceptacleDescription;

public class ContainerServant extends IComponentPOAImpl {
	public ContainerServant(ORB orb) throws ServantNotActive, WrongPolicy,
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
		receptacle.name = "componentCollectionReceptacle";
		receptacle.interface_name = ComponentCollection.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Terceiro receptacle
		receptacle = new ReceptacleDescription();
		receptacle.name = "componentHelpReceptacle";
		receptacle.interface_name = ComponentHelp.class.getName();
		receptacle.is_multiplex = false;
		receptacle.connections = new ConnectionDescription[1];
		_putReceptacle(receptacle.name, receptacle);

		// Primeira faceta
		FacetDescription facet = new FacetDescription();
		facet.name = "componentLoader";
		facet.interface_name = ComponentLoader.class.getName();
		ComponentLoaderServant facet1Servant = new ComponentLoaderServant(this);
		facet.facet_ref = poa.servant_to_reference(facet1Servant);
		_putFacet(facet.name, facet);

		// Segunda faceta
		facet = new FacetDescription();
		facet.name = "componentCollection";
		facet.interface_name = ComponentCollection.class.getName();
		ComponentCollectionServant facet2Servant = new ComponentCollectionServant(
				facet1Servant);
		facet.facet_ref = poa.servant_to_reference(facet2Servant);
		_putFacet(facet.name, facet);

		// Terceira faceta
		facet = new FacetDescription();
		facet.name = "componentHelp";
		facet.interface_name = ComponentHelp.class.getName();
		ComponentHelpServant facet3Servant = new ComponentHelpServant();
		facet.facet_ref = poa.servant_to_reference(facet3Servant);
		_putFacet(facet.name, facet);

		// Quarta faceta
		facet = new FacetDescription();
		facet.name = "registryComponentCollection";
		facet.interface_name = ComponentCollection.class.getName();
		facet.facet_ref = null;
		_putFacet(facet.name, facet);
	}

	public synchronized int connect(String receptacle, Object obj)
			throws InvalidName, InvalidConnection, AlreadyConnected,
			ExceededConnectionLimit {
		int result = super.connect(receptacle, obj);
		FacetDescription facet = null;
		if (receptacle.equals("componentCollectionReceptacle")) {
			facet = new FacetDescription();
			facet.name = "registryComponentCollection";
			facet.interface_name = ComponentCollection.class.getName();
			facet.facet_ref = obj;
			_putFacet(facet.name, facet);
		} else if (receptacle.equals("componentHelpReceptacle")) {
			facet = new FacetDescription();
			facet.name = "componentHelp";
			facet.interface_name = ComponentHelp.class.getName();
			facet.facet_ref = obj;
			_putFacet(facet.name, facet);
		}
		return 0;
	}
}
