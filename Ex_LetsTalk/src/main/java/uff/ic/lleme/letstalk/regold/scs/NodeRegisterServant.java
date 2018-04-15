package uff.ic.lleme.letstalk.regold.scs;

import uff.ic.lleme.letstalk.regold.RegistryStarter;

import java.util.ArrayList;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ComponentNotFound;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.IComponent;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.NodeDescription;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.NodeRegisterPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.Property;

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

	public void register(IComponent node, Property[] props) {
		NodeDescription desc = new NodeDescription();
		desc.node = node;
		desc.props = props;
		_nodes.add(desc);
		starter.updateTreeNodes();
	}

	public void unregister(IComponent node) throws ComponentNotFound {
		for (int i = 0; i < _nodes.size(); i++) {
			if (((NodeDescription) _nodes.get(i)).node.equals(node)) {
				_nodes.remove(i);
				starter.updateTreeNodes();
				return;
			}
		}
		throw new ComponentNotFound();
	}

	public NodeDescription[] getAllNodes() {
		return (NodeDescription[]) _nodes.toArray(new NodeDescription[0]);
	}
}
