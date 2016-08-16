import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

public class CreateComponent {
	private SCS scs = null;

	private POA poa = null;

	private ORB orb = null;

	public static String SCS_IOR;

	public CreateComponent(ORB orb) {
		this.orb = orb;
		SCS_IOR = "scsServant.ior";
	}

	public void create() {
		IComponent node1, node2 = null;
		IComponent container1, container2, container3 = null;
		IComponent registry = null;
		IComponent let1, let2, let3 = null;
		ExecutionNode nodeServant1, nodeServant2 = null;
		ComponentLoader loaderServant1, loaderServant2, loaderServant3 = null;
		NodeRegister nodeRegister = null;

		try {
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			System.out.println("Antes de ler ior");
			String ior = null;
			BufferedReader in = new BufferedReader(new FileReader(SCS_IOR));
			ior = in.readLine();
			in.close();
			scs = SCSHelper.narrow(orb.string_to_object(ior));

			// ---------------- no 1 ---------------------------
			// criando no1
			node1 = scs.getIComponent("ExecutionNodeComponent", 1);
			nodeServant1 = ExecutionNodeHelper.narrow(node1
					.getFacetByName("ExecutionNodeFacet"));

			System.out.println("nodeServant1 instanciado");
			System.out.println(nodeServant1);

			// criando container1 do no1
			container1 = scs.getIComponent("ContainerComponent", 1);

			System.out.println("container1 instanciado");

			ContainerDescription _container = new ContainerDescription();
			_container.container = container1;
			_container.container_name = "ContainerComponent1";
			_container.execution_node = node1;

			System.out
					.println("Antes de chamar o método startContainer de nodeServant1");

			nodeServant1.startContainer(_container);

			System.out
					.println("Apos chamar o método startContainer de nodeServant1");

			loaderServant1 = ComponentLoaderHelper.narrow(container1
					.getFacetByName("ComponentLoaderFacet"));

			System.out.println("loaderServant1 instanciado");
			System.out.println(loaderServant1);

			// criando o componente letstalk1
			let1 = scs.getIComponent("LetsTalkComponent", 1);

			ComponentHandle _handle = new ComponentHandle();
			_handle.id = new ComponentId();

			_handle.cmp = let1;
			_handle.id.name = "LetsTalkComponent";
			_handle.id.version = 1;
			_handle.instance_id = 1;

			System.out
					.println("Antes de chamar o método load de LoaderServant1");

			loaderServant1.load(_handle);

			System.out
					.println("Apos de chamar o método load de LoaderServant1");
			// criando container2 do no1
			container2 = scs.getIComponent("ContainerComponent", 2);

			_container = new ContainerDescription();
			_container.container = container2;
			_container.container_name = "ContainerComponent2";
			_container.execution_node = node1;
			nodeServant1.startContainer(_container);

			loaderServant2 = ComponentLoaderHelper.narrow(container2
					.getFacetByName("ComponentLoaderFacet"));

			System.out.println("loaderServant2 instanciado");
			System.out.println(loaderServant2);

			// criando o componente letstalk2
			let2 = scs.getIComponent("LetsTalkComponent", 2);

			_handle = new ComponentHandle();
			_handle.id = new ComponentId();
			_handle.cmp = let2;
			_handle.id.name = "LetsTalkComponent";
			_handle.id.version = 1;
			_handle.instance_id = 2;

			System.out
					.println("Antes de chamar o método load de LoaderServant2");

			loaderServant2.load(_handle);

			System.out
					.println("Depois de chamar o método load de LoaderServant2");

			// ---------------- no 2 ---------------------------

			// criando no2
			node2 = scs.getIComponent("ExecutionNodeComponent", 2);
			nodeServant2 = ExecutionNodeHelper.narrow(node2
					.getFacetByName("ExecutionNodeFacet"));

			// criando container3 do no3
			container3 = scs.getIComponent("ContainerComponent", 3);

			_container = new ContainerDescription();
			_container.container = container3;
			_container.container_name = "ContainerComponent3";
			_container.execution_node = node2;
			nodeServant2.startContainer(_container);

			loaderServant3 = ComponentLoaderHelper.narrow(container3
					.getFacetByName("ComponentLoaderFacet"));

			// criando o componente letstalk3
			let3 = scs.getIComponent("LetsTalkComponent", 3);

			_handle = new ComponentHandle();
			_handle.id = new ComponentId();

			_handle.cmp = let3;
			_handle.id.name = "LetsTalkComponent";
			_handle.id.version = 1;
			_handle.instance_id = 3;

			System.out
					.println("Antes de chamar o método load de LoaderServant3");

			loaderServant3.load(_handle);

			System.out
					.println("Depois de chamar o método load de LoaderServant3");

			// --------------- Registrando os nos 1 e 2 ----------------------

			registry = scs.getIComponent("RegistryComponent", 1);
			nodeRegister = NodeRegisterHelper.narrow(registry
					.getFacetByName("NodeRegisterFacet"));

			Property[] props = new Property[3];
			props[0] = new Property();
			props[0].name = "CPU";
			props[0].value = "60";
			props[1] = new Property();
			props[1].name = "Memoria";
			props[1].value = "512";
			props[2] = new Property();
			props[2].name = "OS";
			props[2].value = "Linux";

			nodeRegister.register(node1, props);
			nodeRegister.register(node2, props);

		} catch (InvalidName e) {
			System.out.println("Erro");
			// } catch (ServantNotActive e) {
			// System.out.println("Erro");
			// } catch (WrongPolicy e) {
			// System.out.println("Erro");
		} catch (AdapterInactive e) {
			System.out.println("Erro");
		} catch (InternalError e) {
			System.out.println("Erro");
		} catch (FileNotFoundException e) {
			System.out.println("Erro");
		} catch (IOException e) {
			System.out.println("Erro");
		}
	}

	public void delete() {
		IComponent node1, node2 = null;
		IComponent container1, container2, container3 = null;
		IComponent registry = null;
		IComponent let1, let2, let3 = null;
		ExecutionNode nodeServant1, nodeServant2 = null;
		ComponentLoader loaderServant1, loaderServant2, loaderServant3 = null;

		try {
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			System.out.println("Antes de ler ior");
			String ior = null;
			BufferedReader in = new BufferedReader(new FileReader(SCS_IOR));
			ior = in.readLine();
			in.close();
			scs = SCSHelper.narrow(orb.string_to_object(ior));

			registry = scs.getIComponent("RegistryComponent", 1);
			NodeRegister nodeRegister = NodeRegisterHelper.narrow(registry
					.getFacetByName("NodeRegisterFacet"));
			NodeLookup nodeLookup = NodeLookupHelper.narrow(registry
					.getFacetByName("NodeLookupFacet"));

			NodeDescription[] _nodeDesc = new NodeDescription[10];

			_nodeDesc = nodeLookup.getAllNodes();

			try {
				nodeRegister.unregister(_nodeDesc[0].node);
			} catch (ComponentNotFound e) {
				System.err.println("Erro");
			}

		} catch (InvalidName e) {
			System.out.println("Erro");
			// } catch (ServantNotActive e) {
			// System.out.println("Erro");
			// } catch (WrongPolicy e) {
			// System.out.println("Erro");
		} catch (AdapterInactive e) {
			System.out.println("Erro");
		} catch (InternalError e) {
			System.out.println("Erro");
		} catch (FileNotFoundException e) {
			System.out.println("Erro");
		} catch (IOException e) {
			System.out.println("Erro");
		}
	}

}