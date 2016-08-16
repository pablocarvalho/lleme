import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

public class RunCreateComponent {
	public static void main(String args[]) {

		ORB orb = ORB.init(args, null);
		POA poa = null;

		try {
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
		} catch (InvalidName e) {
			System.out.println("Erro");
		} catch (AdapterInactive e) {
			System.out.println("Erro");
		}

		CreateComponent object = new CreateComponent(orb);
		object.create();
	}
}

/*
 * NodeRegister nodeRegister = NodeRegisterHelper
 * .narrow(registry.getFacetByName("NodeRegisterFacet"));
 * 
 * NodeDescription[] _nodeDesc = new NodeDescription[10];
 * 
 * _nodeDesc = nodeLookup.getAllNodes();
 * 
 * try{ nodeRegister.unregister(_nodeDesc[0].node); } catch (ComponentNotFound
 * e) { System.err.println("Erro"); }
 */