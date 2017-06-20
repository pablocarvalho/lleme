package uff.ic.letstalk.scs.newregistry;

import uff.ic.newregistry.RegistryStarter;

import java.util.ArrayList;

import uff.ic.letstalk.corbaObjects.scs.ComponentNotFound;
import uff.ic.letstalk.corbaObjects.scs.IComponent;
import uff.ic.letstalk.corbaObjects.scs.NodeDescription;
import uff.ic.letstalk.corbaObjects.scs.NodeRegisterPOA;
import uff.ic.letstalk.corbaObjects.scs.Property;

public class NodeRegisterServant extends NodeRegisterPOA {

	private ArrayList _nodes = null;

	private RegistryStarter starter = null;

	public NodeRegisterServant() {
		initialize();
	}

	public NodeRegisterServant(RegistryStarter starter) {
		initialize();
		this.starter = starter;
	}

	private void initialize() {
		_nodes = new ArrayList();
	}

	@SuppressWarnings("unchecked")
	public void register(IComponent node, Property[] props) {
		NodeDescription desc = new NodeDescription();
		desc.node = node;
		desc.props = props;
		_nodes.add(desc);
		// starter.updateTreeNodes();
		starter.getDomainExplorer().updateTreeNodes();
	}

	public void unregister(IComponent node) throws ComponentNotFound {
		for (int i = 0; i < _nodes.size(); i++) {
			if (((NodeDescription) _nodes.get(i)).node.equals(node)) {
				_nodes.remove(i);
				// starter.updateTreeNodes();
				starter.getDomainExplorer().updateTreeNodes();
				return;
			}
		}
		throw new ComponentNotFound();
	}

	@SuppressWarnings("unchecked")
	public NodeDescription[] getAllNodes() {
		return (NodeDescription[]) _nodes.toArray(new NodeDescription[0]);
	}
}
