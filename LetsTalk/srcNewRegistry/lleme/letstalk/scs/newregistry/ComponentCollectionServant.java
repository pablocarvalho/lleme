package lleme.letstalk.scs.newregistry;

import java.util.ArrayList;

import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ComponentCollectionHelper;
import corbaObjects.scs.ComponentCollectionPOA;
import corbaObjects.scs.ComponentHandle;
import corbaObjects.scs.ComponentId;
import corbaObjects.scs.ContainerDescription;
import corbaObjects.scs.ExecutionNode;
import corbaObjects.scs.ExecutionNodeHelper;
import corbaObjects.scs.IComponent;
import corbaObjects.scs.IComponentHelper;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.NodeDescription;

public class ComponentCollectionServant extends ComponentCollectionPOA {

	private NodeRegisterServant register = null;

	public ComponentCollectionServant() {

	}

	public ComponentCollectionServant(NodeRegisterServant register) {
		this.register = register;
	}

	@SuppressWarnings("unchecked")
	public ComponentHandle[] getComponent(ComponentId id) throws InvalidName {
		ArrayList selectedComponents = new ArrayList();
		ComponentHandle[] allComponents = getComponents();
		for (int i = 0; i < allComponents.length; i++) {
			if (allComponents[i].id.name.equals(id.name)
					&& allComponents[i].id.version == id.version)
				selectedComponents.add(allComponents[i]);
		}
		return (ComponentHandle[]) selectedComponents
				.toArray(new ComponentHandle[0]);
	}

	@SuppressWarnings("unchecked")
	public ComponentHandle[] getComponents() throws InvalidName {
		ArrayList allComponents = new ArrayList();
		NodeDescription[] nodes = null;
		ContainerDescription[] containers = null;
		IComponent node = null;
		IComponent container = null;
		ExecutionNode exec = null;
		ComponentCollection collection = null;
		ComponentHandle[] containerComponents = null;

		nodes = register.getAllNodes();
		for (int i = 0; i < nodes.length; i++) {
			node = IComponentHelper.narrow(nodes[i].node);
			exec = ExecutionNodeHelper.narrow(node.getFacet(ExecutionNode.class
					.getName()));
			containers = exec.getContainers();
			for (int j = 0; j < containers.length; j++) {
				container = IComponentHelper.narrow(containers[j].container);
				collection = ComponentCollectionHelper.narrow(container
						.getFacetByName("componentCollection"));
				containerComponents = collection.getComponents();
				for (int k = 0; k < containerComponents.length; k++) {
					allComponents.add(containerComponents[k]);
				}
			}
		}
		return (ComponentHandle[]) allComponents
				.toArray(new ComponentHandle[0]);
	}
}
