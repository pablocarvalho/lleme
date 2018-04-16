package uff.ic.lleme.letstalk.regold.scs;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.NodeDescription;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.NodeLookupPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.Property;

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
