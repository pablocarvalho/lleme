package lleme.letstalk.scs.newregistry;

import lleme.newregistry.RegistryStarter;
import lleme.letstalk.scs.IComponentPOAImpl;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExecutionNode;
import corbaObjects.scs.FacetDescription;
import corbaObjects.scs.NodeLookup;
import corbaObjects.scs.NodeRegister;
import corbaObjects.scs.ReceptacleDescription;

public class RegistryServant extends IComponentPOAImpl {

	public RegistryServant(ORB orb) throws ServantNotActive, WrongPolicy,
			org.omg.CORBA.ORBPackage.InvalidName {
		initialize(orb, null);
	}

	public RegistryServant(ORB orb, RegistryStarter starter)
			throws ServantNotActive, WrongPolicy,
			org.omg.CORBA.ORBPackage.InvalidName {
		initialize(orb, starter);
	}

	private void initialize(ORB orb, RegistryStarter starter)
			throws ServantNotActive, WrongPolicy,
			org.omg.CORBA.ORBPackage.InvalidName {
		POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		// Primeiro receptacle
		ReceptacleDescription receptacle = new ReceptacleDescription();
		receptacle.name = "executionNodeReceptacle";
		receptacle.interface_name = ExecutionNode.class.getName();
		receptacle.is_multiplex = true;
		receptacle.connections = new ConnectionDescription[100];
		_putReceptacle(receptacle.name, receptacle);

		// Primeira faceta
		FacetDescription facet = new FacetDescription();
		facet.name = "nodeRegister";
		facet.interface_name = NodeRegister.class.getName();
		lleme.letstalk.scs.newregistry.NodeRegisterServant facet1Servant = null;
		if (starter == null)
			facet1Servant = new lleme.letstalk.scs.newregistry.NodeRegisterServant();
		else
			facet1Servant = new lleme.letstalk.scs.newregistry.NodeRegisterServant(
					starter);
		facet.facet_ref = poa.servant_to_reference(facet1Servant);
		_putFacet(facet.name, facet);

		// Segunda faceta
		facet = new FacetDescription();
		facet.name = "nodeLookup";
		facet.interface_name = NodeLookup.class.getName();
		NodeLookupServant facet2Servant = new NodeLookupServant(facet1Servant);
		facet.facet_ref = poa.servant_to_reference(facet2Servant);
		_putFacet(facet.name, facet);

		// Terceira faceta
		facet = new FacetDescription();
		facet.name = "componentCollection";
		facet.interface_name = ComponentCollection.class.getName();
		ComponentCollectionServant facet3Servant = new ComponentCollectionServant(
				facet1Servant);
		facet.facet_ref = poa.servant_to_reference(facet3Servant);
		_putFacet(facet.name, facet);

		// Terceira faceta
		facet = new FacetDescription();
		facet.name = "namingContextExt";
		facet.interface_name = NamingContextExt.class.getName();
		facet.facet_ref = NamingContextExtHelper.narrow(orb
				.resolve_initial_references("TNameService"));
		_putFacet(facet.name, facet);
	}
}
