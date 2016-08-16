package lleme.letstalk.scs.client;

import corbaObjects.letstalk.CommFacet;
import corbaObjects.letstalk.CommFacetHelper;
import corbaObjects.letstalk.CommFacetPOA;
import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;

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
