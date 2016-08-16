package lleme.letstalk.registry;

import corbaObjects.scs.ExecutionNode;
import corbaObjects.scs.ExecutionNodeHelper;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.NodeDescription;

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
