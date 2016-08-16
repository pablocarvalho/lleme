package lleme.letstalk.scs.newregistry;

import corbaObjects.scs.NodeDescription;
import corbaObjects.scs.NodeLookupPOA;
import corbaObjects.scs.Property;

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
