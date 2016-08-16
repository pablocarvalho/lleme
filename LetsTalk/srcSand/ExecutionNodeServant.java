import java.util.HashMap;

//import corbaObjects.letstalk.commfacet.CommFacetPOA;
//import corbaObjects.letstalk.host.Host;
//import corbaObjects.letstalk.host.HostHelper;
//import corbaObjects.scs.IComponentPOA;
//import corbaObjects.scs.InvalidConnection;

public class ExecutionNodeServant extends ExecutionNodePOA {

	private String name;

	static int instance = 1;

	public HashMap containers = null;

	public ExecutionNodeServant() {
		System.out
				.println("ExecutionNodeServant:Objeto ExecutionNodeServant criado");
		this.name = "No_" + instance;
		instance++;
		containers = new HashMap();
	}

	public String name() {
		return name;
	}

	public void startContainer(ContainerDescription container) {
		System.out
				.println("ExecutionNodeServant:Dentro do metodo startContainer");
		containers.put(container.container_name, container);
	}

	public ContainerDescription[] getContainers() {
		return (ContainerDescription[]) containers.values().toArray(
				new ContainerDescription[0]);
	}
}
