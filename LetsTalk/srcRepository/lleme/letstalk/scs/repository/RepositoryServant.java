package lleme.letstalk.scs.repository;

import lleme.letstalk.scs.ComponentHelpServant;
import lleme.letstalk.scs.ComponentRepositoryServant;
import lleme.letstalk.scs.IComponentPOAImpl;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.scs.ComponentHelp;
import corbaObjects.scs.ComponentRepository;
import corbaObjects.scs.FacetDescription;

public class RepositoryServant extends IComponentPOAImpl {

	public RepositoryServant(ORB orb) throws ServantNotActive, WrongPolicy,
			org.omg.CORBA.ORBPackage.InvalidName {
		POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		// Primeira faceta
		FacetDescription facet = new FacetDescription();
		facet.name = "componentRepository";
		facet.interface_name = ComponentRepository.class.getName();
		ComponentRepositoryServant facet1Servant = new ComponentRepositoryServant();
		facet.facet_ref = poa.servant_to_reference(facet1Servant);
		_putFacet(facet.name, facet);

		// Segunda faceta
		facet = new FacetDescription();
		facet.name = "componentHelp";
		facet.interface_name = ComponentHelp.class.getName();
		ComponentHelpServant facet2Servant = new ComponentHelpServant();
		facet.facet_ref = poa.servant_to_reference(facet2Servant);
		_putFacet(facet.name, facet);
	}
}
