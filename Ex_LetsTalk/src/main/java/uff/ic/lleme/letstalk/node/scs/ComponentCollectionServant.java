package uff.ic.lleme.letstalk.node.scs;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentCollectionPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentHandle;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentId;

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
