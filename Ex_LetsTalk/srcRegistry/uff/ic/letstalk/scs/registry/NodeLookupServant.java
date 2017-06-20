package uff.ic.letstalk.scs.registry;

import uff.ic.letstalk.corbaObjects.scs.NodeDescription;
import uff.ic.letstalk.corbaObjects.scs.NodeLookupPOA;
import uff.ic.letstalk.corbaObjects.scs.Property;

public class NodeLookupServant extends NodeLookupPOA {

	private NodeRegisterServant register = null;

	public NodeLookupServant(NodeRegisterServant register) {
		this.register = register;
	}

	public NodeDescription getNode(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeDescription[] getNodes(Property[] props) {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeDescription[] getAllNodes() {
		return register.getAllNodes();
	}

}
