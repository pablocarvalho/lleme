package lleme.letstalk.scs.node;

import corbaObjects.scs.ComponentCollectionPOA;
import corbaObjects.scs.ComponentHandle;
import corbaObjects.scs.ComponentId;

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
