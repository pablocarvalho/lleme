package uff.ic.letstalk.scs.node;

import uff.ic.letstalk.corbaObjects.scs.ComponentCollectionPOA;
import uff.ic.letstalk.corbaObjects.scs.ComponentHandle;
import uff.ic.letstalk.corbaObjects.scs.ComponentId;

public class ComponentCollectionServant extends ComponentCollectionPOA {

	private ComponentLoaderServant loader = null;

	public ComponentCollectionServant(ComponentLoaderServant loader) {
		this.loader = loader;
	}

	public ComponentHandle[] getComponent(ComponentId id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ComponentHandle[] getComponents() {
		return loader.getLoadedComponents();
	}

}
