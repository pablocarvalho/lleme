package lleme.letstalk.scs.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.omg.CORBA.Object;

import corbaObjects.letstalk.InvalidSubscriptionValues;
import corbaObjects.letstalk.ServerCallBackFacet;
import corbaObjects.letstalk.ServerCallBackFacetHelper;
import corbaObjects.letstalk.UserFacetPOA;
import corbaObjects.letstalk.usermanager.UserManagerFacet;
import corbaObjects.letstalk.usermanager.UserManagerFacetHelper;
import corbaObjects.letstalk.usermanager.enum_type;
import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.NoConnection;

/**
 * @author Luiz Leme
 */
public class ServerUserFacetServant extends UserFacetPOA {

	private HashMap users = null;

	private String catalogFilename = null;

	private LetsTalkServerServant component = null;

	public ServerUserFacetServant(LetsTalkServerServant component) {
		this.component = component;
		this.catalogFilename = "..\\usersMap.dat";
		try {
			load();
		} catch (ClassNotFoundException e) {
			users = new HashMap();
		} catch (java.io.IOException e) {
			users = new HashMap();
		}
	}

	public synchronized void disconnect(String login) throws InvalidConnection,
			NoConnection, InternalError {

		UserManagerFacet userManager = null;
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserManagerFacet.class.getName())[0];
			if (desc != null)
				userManager = UserManagerFacetHelper.narrow(desc.objref);
			else
				throw new InternalError();
			ServerCallBackFacetHolder holder = (ServerCallBackFacetHolder) users
					.get(login);
			if (holder == null)
				throw new InvalidConnection();
			if (userManager.desconnect(login) == enum_type.OK) {
				users.remove(login);
				component.disconnect(holder.connId);
				save();
			}
		} catch (InvalidName e) {
			throw new InternalError();
		} catch (InvalidConnection e) {
			throw new InternalError();
		} catch (AlreadyConnected e) {
			throw new InternalError();
		} catch (ExceededConnectionLimit e) {
			throw new InternalError();
		} catch (IOException e) {
			throw new InternalError();
		} finally {
		}
	}

	public synchronized String[] listUsers() {
		return (String[]) users.keySet().toArray(new String[0]);
	}

	public synchronized int connect(String login, String password, Object host)
			throws InvalidName, InvalidConnection, AlreadyConnected,
			ExceededConnectionLimit, InternalError {

		UserManagerFacet userManager = null;
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserManagerFacet.class.getName())[0];
			if (desc != null)
				userManager = UserManagerFacetHelper.narrow(desc.objref);
			else
				throw new InternalError();
			ServerCallBackFacetHolder holder = new ServerCallBackFacetHolder();
			ServerCallBackFacet _host = null;
			int connId = 0;
			if (login != null && login != "" && host != null
					&& users.get(login) == null) {
				if (userManager.connect(login, password) == enum_type.OK) {
					connId = component.connect("serverCallBackFacetReceptacle",
							host);
					_host = ServerCallBackFacetHelper.narrow(host);
					holder.callBack = _host;
					holder.connId = connId;
					users.put(login, holder);
				}
			}
			save();
			return connId;
		} catch (InvalidName e) {
			throw new InternalError();
		} catch (IOException e) {
			throw new InternalError();
		} finally {
		}
	}

	public void subscribe(String login, String password)
			throws InvalidSubscriptionValues, InternalError {

		UserManagerFacet userManager = null;
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserManagerFacet.class.getName())[0];
			if (desc != null)
				userManager = UserManagerFacetHelper.narrow(desc.objref);
			else
				throw new InternalError();
		} catch (InvalidName e) {
			throw new InternalError();
		} catch (InvalidConnection e) {
			throw new InternalError();
		} catch (AlreadyConnected e) {
			throw new InternalError();
		} catch (ExceededConnectionLimit e) {
			throw new InternalError();
		} finally {
		}

		if (userManager.subscribe(login, password) != enum_type.OK)
			throw new InvalidSubscriptionValues();

	}

	public ServerCallBackFacetHolder getUser(String login) {
		return (ServerCallBackFacetHolder) users.get(login);
	}

	private synchronized void load() throws ClassNotFoundException,
			java.io.IOException {
		if (users == null) {
			File file = new File(catalogFilename);
			if (file.exists()) {
				FileInputStream in = new FileInputStream(catalogFilename);
				ObjectInputStream s = new ObjectInputStream(in);
				users = (HashMap) s.readObject();
				s.close();
			} else {
				users = new HashMap();
			}
		}
	}

	private synchronized void save() throws java.io.IOException {
		ObjectOutputStream s = null;
		FileOutputStream out = null;
		out = new FileOutputStream(catalogFilename);
		s = new ObjectOutputStream(out);
		// s.writeObject(users);
		// s.flush();
		s.close();
	}
}
