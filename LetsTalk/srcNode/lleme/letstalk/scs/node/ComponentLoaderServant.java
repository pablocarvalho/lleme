package lleme.letstalk.scs.node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;

import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ComponentAlreadyLoaded;
import corbaObjects.scs.ComponentHandle;
import corbaObjects.scs.ComponentId;
import corbaObjects.scs.ComponentLoaderPOA;
import corbaObjects.scs.ComponentNotFound;
import corbaObjects.scs.ComponentNotInstalled;
import corbaObjects.scs.ComponentRepository;
import corbaObjects.scs.ComponentRepositoryHelper;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.IComponentHelper;
import corbaObjects.scs.IComponentPOA;
import corbaObjects.scs.IOException;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.LoadFailure;

public class ComponentLoaderServant extends ComponentLoaderPOA {
	private ContainerServant container = null;

	private ArrayList components = null;

	private int instanceId = 1;

	public ComponentLoaderServant(ContainerServant container) {
		this.container = container;
		this.components = new ArrayList();
	}

	@SuppressWarnings( { "unchecked", "unused", "unused" })
	public ComponentHandle load(ComponentId id, String[] args)
			throws ComponentNotFound, ComponentAlreadyLoaded, LoadFailure {
		File file = null;
		String filename = null;
		byte[] data = null;
		filename = id.name + id.version + ".jar";
		file = new File(filename);
		ComponentRepository repository = null;
		JarClassLoader loader = null;
		try {
			ConnectionDescription desc = container
					.getReceptacleConnections(ComponentRepository.class
							.getName())[0];
			if (desc != null)
				repository = ComponentRepositoryHelper.narrow(desc.objref);

			data = repository.getComponentFile(id);
			FileOutputStream out = new FileOutputStream(filename);
			out.write(data);
			out.close();

			loader = new JarClassLoader(new URL("file:\\"
					+ file.getAbsolutePath()), this._orb(), container,
					id.version);
			String name = null;
			name = loader.getMainClassName();
			IComponentPOA servant = loader.invokeClass(repository
					.getComponentDescription(id).entry_point, new String[] {});
			org.omg.CORBA.Object obj = this._poa()
					.servant_to_reference(servant);
			servant.connect("componentCollection", container
					.getFacetByName("registryComponentCollection"));

			ComponentHandle handle = new ComponentHandle();
			handle.id = id;
			handle.cmp = IComponentHelper.narrow(obj);
			handle.instance_id = instanceId++;
			components.add(handle);
			return handle;
		} catch (InvalidName e) {
			throw new LoadFailure();
		} catch (ComponentNotInstalled e) {
			throw new LoadFailure();
		} catch (IOException e) {
			throw new LoadFailure();
		} catch (FileNotFoundException e) {
			throw new LoadFailure();
		} catch (java.io.IOException e) {
			throw new LoadFailure();
		} catch (ClassNotFoundException e) {
			throw new LoadFailure();
		} catch (NoSuchMethodException e) {
			throw new LoadFailure();
		} catch (InvocationTargetException e) {
			throw new LoadFailure();
		} catch (IllegalArgumentException e) {
			throw new LoadFailure();
		} catch (IllegalAccessException e) {
			throw new LoadFailure();
		} catch (ServantNotActive e) {
			throw new LoadFailure();
		} catch (WrongPolicy e) {
			throw new LoadFailure();
		} catch (InvalidConnection e) {
			throw new LoadFailure();
		} catch (AlreadyConnected e) {
			throw new LoadFailure();
		} catch (ExceededConnectionLimit e) {
			throw new LoadFailure();
		} finally {
		}
	}

	@SuppressWarnings("unused")
	public void unload(ComponentHandle handle) throws ComponentNotFound {
		// TODO Auto-generated method stub

	}

	public ComponentId[] getInstalledComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public ComponentHandle[] getLoadedComponents() {
		return (ComponentHandle[]) components.toArray(new ComponentHandle[0]);
	}
}
