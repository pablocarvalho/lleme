package uff.ic.letstalk.scs;

import uff.ic.letstalk.corbaObjects.scs.ComponentHelpPOA;
import uff.ic.letstalk.corbaObjects.scs.ComponentId;
import uff.ic.letstalk.corbaObjects.scs.ComponentNotFound;
import uff.ic.letstalk.corbaObjects.scs.HelpInfoNotAvailable;

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
