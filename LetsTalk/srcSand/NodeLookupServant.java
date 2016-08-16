import java.util.Iterator;

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

public class NodeLookupServant extends NodeLookupPOA {

	public NodeRegisterServant registerServant = null;

	public IComponentPOA component = null;

	public NodeLookupServant() {
		System.out.println("NodeLookupServant:Objeto NodeLookupServant criado");
	}

	public NodeDescription getNode(String name) {
		System.out.println("Dentro do metodo getNode do objeto nodeLookup");
		return (NodeDescription) this.registerServant.nodes.get(name);
	}

	public NodeDescription[] getNodes(Property[] props) {
		Iterator iter = this.registerServant.nodes.values().iterator();
		NodeDescription[] nodeVector = new NodeDescription[10];
		NodeDescription _node = null;
		int count = 0;
		int conformance = 0;

		while (iter.hasNext()) {
			_node = (NodeDescription) iter.next();
			if (_node.props.length >= props.length)
				for (int i = 0; i < _node.props.length; i++)
					for (int j = 0; j < props.length; j++)
						if (_node.props[i].name == props[j].name
								&& _node.props[i].value == props[j].value)
							conformance++;
			if (conformance == props.length) {
				nodeVector[count] = _node;
				count++;
			}
			conformance = 0;
		}
		return nodeVector;
	}

	public NodeDescription[] getAllNodes() {
		return (NodeDescription[]) this.registerServant.nodes.values().toArray(
				new NodeDescription[0]);
	}
}