import java.io.IOException;
import java.util.HashMap;

/*import corbaObjects.letstalk.InvalidSubscriptionValues;
 import corbaObjects.letstalk.host.Host;
 import corbaObjects.letstalk.host.HostHelper;
 import corbaObjects.letstalk.userManager.UserManager;
 import corbaObjects.letstalk.userManager.UserManagerHelper;
 import corbaObjects.letstalk.userManager.enum_type;
 import corbaObjects.letstalk.userfacet.UserFacetPOA;
 import corbaObjects.scs.AlreadyConnected;
 import corbaObjects.scs.ExceededConnectionLimit;
 import corbaObjects.scs.IComponentPOA;
 import corbaObjects.scs.InvalidConnection;
 import corbaObjects.scs.InvalidName;
 import corbaObjects.scs.NoConnection;*/

public class NodeRegisterServant extends NodeRegisterPOA {

	public HashMap nodes = null;

	public IComponentPOA component = null;

	public NodeRegisterServant() throws IOException {
		System.out
				.println("NodeRegisterServant:Objeto ExecutionRegisterServant criado");
		nodes = new HashMap();
	}

	public void register(IComponent node, Property[] props) {

		System.out.println("Dentro do metodo register do objeto nodeRegister");
		ExecutionNode executionNode = null;
		executionNode = ExecutionNodeHelper.narrow(node
				.getFacetByName("ExecutionNodeFacet"));
		NodeDescription nodeDesc = new NodeDescription();
		nodeDesc.node = node;
		nodeDesc.props = props;
		nodes.put(executionNode.name(), nodeDesc);
	}

	public void unregister(IComponent node) throws ComponentNotFound {
		ExecutionNode executionNode = null;
		executionNode = ExecutionNodeHelper.narrow(node
				.getFacetByName("ExecutionNodeFacet"));
		if (executionNode == null)
			throw new ComponentNotFound();
		nodes.remove(executionNode.name());
	}

}
