package uff.ic.lleme.letstalk.cbobjs.scs;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentHelpPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentId;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentNotFound;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.HelpInfoNotAvailable;

public class ComponentHelpServant extends ComponentHelpPOA {

	public ComponentHelpServant() {

	}

	@SuppressWarnings("unused")
	public String getHelpInfo(ComponentId id) throws ComponentNotFound,
			HelpInfoNotAvailable {
		// TODO Auto-generated method stub
		return null;
	}

}
