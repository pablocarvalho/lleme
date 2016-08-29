package uff.ic.letstalk.registry;

import uff.ic.letstalk.corbaObjects.scs.ExecutionNode;
import uff.ic.letstalk.corbaObjects.scs.ExecutionNodeHelper;
import uff.ic.letstalk.corbaObjects.scs.InvalidName;
import uff.ic.letstalk.corbaObjects.scs.NodeDescription;

public class NodeDescriptionHolder {
	public NodeDescription desc = null;

	public String toString() {
		if (desc != null) {
			try {
				org.omg.CORBA.Object obj = desc.node
						.getFacet(ExecutionNode.class.getName());
				ExecutionNode exec = ExecutionNodeHelper.narrow(desc.node
						.getFacet(ExecutionNode.class.getName()));
				return exec.name();
			} catch (InvalidName e) {
			}
		}
		return null;
	}
}
