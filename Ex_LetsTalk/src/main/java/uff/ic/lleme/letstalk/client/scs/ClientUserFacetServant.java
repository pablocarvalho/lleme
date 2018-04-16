package uff.ic.lleme.letstalk.client.scs;

import org.omg.CORBA.Object;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.InvalidSubscriptionValues;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.ServerCallBackFacet;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.UserFacet;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.UserFacetHelper;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.UserFacetPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.AlreadyConnected;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ConnectionDescription;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ExceededConnectionLimit;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.InternalError;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.InvalidConnection;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.InvalidName;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.NoConnection;

public class ClientUserFacetServant extends UserFacetPOA {

	public String userId = null;

	public int connId = 0;

	private LetsTalkServant component = null;

	public ClientUserFacetServant(LetsTalkServant component) {
		this.component = component;
	}

	public void subscribe(String login, String password)
			throws InvalidSubscriptionValues, InternalError {
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserFacet.class.getName())[0];
			if (desc != null)
				UserFacetHelper.narrow(desc.objref).subscribe(login, password);
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
		}

	}

	public int connect(String login, String password, Object host)
			throws InvalidName, InvalidConnection, AlreadyConnected,
			ExceededConnectionLimit, InternalError {
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserFacet.class.getName())[0];
			if (desc != null) {
				connId = UserFacetHelper.narrow(desc.objref)
						.connect(
								login,
								password,
								component.getFacet(ServerCallBackFacet.class
										.getName()));
				userId = login;
			} else
				throw new InternalError();
			return connId;
		} finally {

		}
	}

	public void disconnect(String login) throws InvalidConnection,
			NoConnection, InternalError {
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserFacet.class.getName())[0];
			if (desc != null)
				UserFacetHelper.narrow(desc.objref).disconnect(login);
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
		}
	}

	public String[] listUsers() throws InternalError {
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserFacet.class.getName())[0];
			if (desc != null)
				return UserFacetHelper.narrow(desc.objref).listUsers();
			throw new InternalError();
		} catch (InvalidName e) {
			throw new InternalError();
		} catch (InvalidConnection e) {
			throw new InternalError();
		} catch (AlreadyConnected e) {
			throw new InternalError();
		} catch (ExceededConnectionLimit e) {
			throw new InternalError();
		}
	}

	public String getUserId() {
		return userId;
	}

	public int getConnectionId() {
		return connId;
	}

}
