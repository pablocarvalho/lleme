import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/*import corbaObjects.letstalk.host.HostHelper;
 import corbaObjects.scs.AlreadyConnected;
 import corbaObjects.scs.ConnectionDescription;
 import corbaObjects.scs.ExceededConnectionLimit;
 import corbaObjects.scs.FacetDescription;
 import corbaObjects.scs.IComponentPOA;
 import corbaObjects.scs.InvalidConnection;
 import corbaObjects.scs.InvalidName;
 import corbaObjects.scs.NoConnection;
 import corbaObjects.scs.ReceptacleDescription;
 import corbaObjects.scs.ShutdownFailed;
 import corbaObjects.scs.StartupFailed;*/

public class RegistryComponentServant extends IComponentPOA implements Runnable {
	private HashMap facetsByName = null;

	private HashMap facetsByInterface = null;

	private HashMap receptacles = null;

	private int connId = 1;

	private Thread thread = null;

	public RegistryComponentServant(ORB orb) throws ServantNotActive,
			WrongPolicy, org.omg.CORBA.ORBPackage.InvalidName, IOException {
		POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		System.out.println("Dentro de RegistryComponentServant");
		System.out.println("Guardando receptáculo");
		facetsByName = new HashMap();
		facetsByInterface = new HashMap();
		receptacles = new HashMap();
		ReceptacleDescription receptacle = new ReceptacleDescription();
		receptacle.name = "none";
		receptacle.interface_name = "None";
		receptacle.is_multiplex = true;
		receptacle.connections = new ConnectionDescription[10];
		receptacles.put(receptacle.name, receptacle);
		System.out.println("Receptaculo Guardado");

		System.out.println("Guardando Faceta NodeRegisterFacet");
		FacetDescription facet = new FacetDescription();
		facet.name = "NodeRegisterFacet";
		facet.interface_name = "NodeRegister";
		NodeRegisterServant nodeRegisterServant = new NodeRegisterServant();
		nodeRegisterServant.component = this;
		facet.facet_ref = poa.servant_to_reference(nodeRegisterServant);
		facetsByName.put(facet.name, facet);
		facetsByInterface.put(facet.interface_name, facet);
		// System.out.println("ior de Faceta NodeRegisterFacet");
		// System.out.println(facet.facet_ref);

		System.out.println("Guardando Faceta NodeLookupFacet");
		facet = new FacetDescription();
		facet.name = "NodeLookupFacet";
		facet.interface_name = "NodeLookup";
		NodeLookupServant nodeLookupServant = new NodeLookupServant();
		nodeLookupServant.component = this;
		nodeLookupServant.registerServant = nodeRegisterServant;
		facet.facet_ref = poa.servant_to_reference(nodeLookupServant);
		facetsByName.put(facet.name, facet);
		facetsByInterface.put(facet.interface_name, facet);
		// System.out.println("ior de NodeLookupFacet");
		// System.out.println(facet.facet_ref);

		thread = new Thread(this);
		thread.start();
	}

	public synchronized void run() {
		Thread myThread = Thread.currentThread();
		while (thread == myThread) {
			try {
				wait();
			} catch (InterruptedException e) {
			} catch (Throwable e) {
			}
		}
	}

	public Object getFacet(String facet_interface) {
		FacetDescription facet = (FacetDescription) facetsByInterface
				.get(facet_interface);
		if (facet != null)
			return facet.facet_ref;
		return null;
	}

	public Object getFacetByName(String facet) {
		FacetDescription _facet = (FacetDescription) facetsByName.get(facet);
		if (_facet != null)
			return _facet.facet_ref;
		return null;
	}

	public void startup() throws StartupFailed {
		// TODO Auto-generated method stub
	}

	public void shutdown() throws ShutdownFailed {
		// TODO Auto-generated method stub
	}

	public synchronized int connect(String receptacle, Object obj)
			throws InvalidName, InvalidConnection, AlreadyConnected,
			ExceededConnectionLimit {
		ReceptacleDescription _receptacle = (ReceptacleDescription) this.receptacles
				.get(receptacle);
		if (_receptacle == null)
			throw new InvalidName();
		try {
			if (!Class.forName(_receptacle.interface_name).isAssignableFrom(
					obj.getClass()))
				throw new InvalidConnection();
		} catch (ClassNotFoundException e) {
			throw new InvalidConnection();
		}
		for (int i = 0; i < _receptacle.connections.length; i++)
			if (_receptacle.connections[i] != null
					&& _receptacle.connections[i].objref.equals(obj))
				throw new AlreadyConnected();
		ConnectionDescription conn = new ConnectionDescription();
		conn.id = connId++;
		conn.objref = obj;
		for (int i = 0; i < _receptacle.connections.length; i++) {
			if (_receptacle.connections[i] == null) {
				_receptacle.connections[i] = conn;
				notify();
				return conn.id;
			}
		}
		throw new ExceededConnectionLimit();
	}

	public synchronized void disconnect(int id) throws InvalidConnection,
			NoConnection {
		Iterator iter = receptacles.values().iterator();
		boolean noConnection = true;
		ReceptacleDescription _receptacle = null;
		while (iter.hasNext()) {
			_receptacle = (ReceptacleDescription) iter.next();
			for (int i = 0; i < _receptacle.connections.length; i++) {
				if (_receptacle.connections[i] != null) {
					noConnection = false;
					if (_receptacle.connections[i].id == id) {
						_receptacle.connections[i] = null;
						notify();
						return;
					}
				}
			}
		}
		if (noConnection)
			throw new NoConnection();
		throw new InvalidConnection();
	}

	public ConnectionDescription[] getConnections(String receptacle)
			throws InvalidName {
		ReceptacleDescription _receptacle = (ReceptacleDescription) receptacles
				.get(receptacle);
		if (_receptacle == null)
			throw new InvalidName();
		return _receptacle.connections;
	}

	public FacetDescription[] getFacets() {
		// TODO Auto-generated method stub
		return null;
	}

	public FacetDescription[] getFacetsByName(String[] names)
			throws InvalidName {
		return null;
	}

	/**
	 * @return Returns the receptacles.
	 * @uml.property name="receptacles"
	 */
	public ReceptacleDescription[] getReceptacles() {
		return (ReceptacleDescription[]) receptacles.values().toArray(
				new ReceptacleDescription[0]);
	}

	public ReceptacleDescription[] getReceptaclesByName(String[] names)
			throws InvalidName {
		if (names == null || names.length == 0)
			throw new InvalidName();
		ReceptacleDescription[] receptacles = new ReceptacleDescription[names.length];
		ReceptacleDescription receptacle = null;
		for (int i = 0; i < names.length; i++) {
			receptacle = (ReceptacleDescription) this.receptacles.get(names[i]);
			if (receptacle == null)
				throw new InvalidName();
		}
		return receptacles;
	}

	public ConnectionDescription getConnection(int id) throws InvalidConnection {
		ReceptacleDescription _receptacle = null;
		Iterator iter = receptacles.values().iterator();
		while (iter.hasNext()) {
			_receptacle = (ReceptacleDescription) iter.next();
			for (int i = 0; i < _receptacle.connections.length; i++) {
				if (_receptacle.connections[i] != null
						&& _receptacle.connections[i].id == id)
					return _receptacle.connections[i];
			}
		}
		throw new InvalidConnection();
	}
}
