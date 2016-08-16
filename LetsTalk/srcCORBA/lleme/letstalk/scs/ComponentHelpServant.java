package lleme.letstalk.scs;

import corbaObjects.scs.ComponentHelpPOA;
import corbaObjects.scs.ComponentId;
import corbaObjects.scs.ComponentNotFound;
import corbaObjects.scs.HelpInfoNotAvailable;

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
