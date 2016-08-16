import java.util.HashMap;

//import corbaObjects.letstalk.commfacet.CommFacetPOA;
//import corbaObjects.letstalk.host.Host;
//import corbaObjects.letstalk.host.HostHelper;
//import corbaObjects.scs.IComponentPOA;
//import corbaObjects.scs.InvalidConnection;

public class ComponentLoaderServant extends ComponentLoaderPOA {

	public HashMap components = null;

	public ComponentLoaderServant() {
		System.out
				.println("ComponentLoaderServant:Objeto ComponentLoaderServant criador");
		components = new HashMap();
	}

	public void load(ComponentHandle handle) {
		System.out.println("Dentro do metodo load de ComponentLoaderServant");
		String fullname = handle.id.name + handle.instance_id;
		components.put(fullname, handle);
	}

	public void unload(ComponentHandle handle) {
	}
}
