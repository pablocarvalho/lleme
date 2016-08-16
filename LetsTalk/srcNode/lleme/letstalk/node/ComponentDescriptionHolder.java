package lleme.letstalk.node;

import corbaObjects.scs.ComponentDescription;

public class ComponentDescriptionHolder {
	public ComponentDescription desc = null;

	public String toString() {
		if (desc != null)
			return desc.id.name + ", version: " + desc.id.version;
		return null;
	}
}
