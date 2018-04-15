package uff.ic.lleme.letstalk.client.scs;

import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.CommFacet;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.CommFacetHelper;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.letstalk.CommFacetPOA;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.AlreadyConnected;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ConnectionDescription;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.ExceededConnectionLimit;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.InternalError;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.InvalidConnection;
import uff.ic.lleme.letstalk.cbobjs.corbaObjects.scs.InvalidName;

public class ClientCommFacetServant extends CommFacetPOA {

	private LetsTalkServant component = null;

	private ClientUserFacetServant clientuserFacetServant = null;

	public ClientCommFacetServant(LetsTalkServant component,
			ClientUserFacetServant clientuserFacetServant) {
		this.component = component;
		this.clientuserFacetServant = clientuserFacetServant;
	}

	public void startChatting(String login, String[] users)
			throws InvalidConnection, InternalError {
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(CommFacet.class.getName())[0];
			if (desc != null)
				CommFacetHelper.narrow(desc.objref).startChatting(
						clientuserFacetServant.getUserId(), users);
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

	public void sendMessage(String login, String chatId, String[] recipients,
			String message) throws InternalError {
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(CommFacet.class.getName())[0];
			if (desc != null)
				CommFacetHelper.narrow(desc.objref).sendMessage(
						clientuserFacetServant.getUserId(), chatId, recipients,
						message);
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
}
