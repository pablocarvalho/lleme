package lleme.letstalk.scs;

import java.util.HashMap;
import java.util.Iterator;

import org.omg.CORBA.Object;

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
import corbaObjects.scs.StartupFailed;

public abstract class IComponentPOAImpl extends IComponentPOA {

	private HashMap facets = null;

	private HashMap receptacles = null;

	private int connId = 1;

	public IComponentPOAImpl() {
		facets = new HashMap();
		receptacles = new HashMap();
	}

	public Object getFacet(String facet_interface) throws InvalidName {
		Iterator iter = facets.values().iterator();
		FacetDescription desc = null;
		while (iter.hasNext()) {
			desc = (FacetDescription) iter.next();
			if (desc.interface_name.equals(facet_interface))
				return desc.facet_ref;
		}
		throw new InvalidName(facet_interface);
	}

	public Object getFacetByName(String facet) throws InvalidName {
		FacetDescription _facet = (FacetDescription) facets.get(facet);
		if (_facet != null)
			return _facet.facet_ref;
		throw new InvalidName(facet);
	}

	@SuppressWarnings("unused")
	public void startup() throws StartupFailed {
	}

	@SuppressWarnings("unused")
	public void shutdown() throws ShutdownFailed {
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

	@SuppressWarnings("unchecked")
	public FacetDescription[] getFacets() {
		return (FacetDescription[]) facets.values().toArray(
				new FacetDescription[0]);
	}

	@SuppressWarnings("unused")
	public FacetDescription[] getFacetsByName(String[] names)
			throws InvalidName {
		return null;
	}

	@SuppressWarnings("unchecked")
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
			receptacles[i] = receptacle;
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

	@SuppressWarnings("unused")
	public ConnectionDescription[] getReceptacleConnections(
			String receptacle_interface) throws InvalidName, InvalidConnection,
			AlreadyConnected, ExceededConnectionLimit, InternalError {
		Iterator iter = receptacles.values().iterator();
		ReceptacleDescription desc = null;
		while (iter.hasNext()) {
			desc = (ReceptacleDescription) iter.next();
			if (desc.interface_name.equals(receptacle_interface))
				return desc.connections;
		}
		throw new InvalidName(receptacle_interface);
	}

	@SuppressWarnings("unchecked")
	protected FacetDescription _putFacet(String facetName,
			FacetDescription facetDescription) {
		return (FacetDescription) facets.put(facetName, facetDescription);
	}

	protected FacetDescription _getFacet(String facetName) {
		return (FacetDescription) facets.get(facetName);
	}

	@SuppressWarnings("unchecked")
	protected ReceptacleDescription _putReceptacle(String receptacleName,
			ReceptacleDescription receptacleDescription) {
		return (ReceptacleDescription) receptacles.put(receptacleName,
				receptacleDescription);
	}

	protected ReceptacleDescription _getReceptacle(String receptacleName) {
		return (ReceptacleDescription) receptacles.get(receptacleName);
	}
}
