package lleme.letstalk.scs.server;

import corbaObjects.letstalk.CommFacetPOA;
import corbaObjects.letstalk.ServerCallBackFacet;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidConnection;

/**
 * @author Luiz Leme
 */
public class ServerCommFacetServant extends CommFacetPOA {

	public LetsTalkServerServant component = null;

	private ServerUserFacetServant serverUserFacetServant = null;

	private int chatNumber = 1;

	public ServerCommFacetServant(LetsTalkServerServant component,
			ServerUserFacetServant serverUserFacetServant) {
		this.component = component;
		this.serverUserFacetServant = serverUserFacetServant;

	}

	@SuppressWarnings("unused")
	public void startChatting(String user, String[] users)
			throws InvalidConnection, InternalError {
		ServerCallBackFacet host = serverUserFacetServant.getUser(user).callBack;
		host.receiveMessage(user, "chat#" + chatNumber++, users, "");

	}

	public void sendMessage(String user, String chatId, String[] recipients,
			String message) throws InternalError {

		for (int i = 0; i < recipients.length; i++) {
			try {
				serverUserFacetServant.getUser((recipients[i])).callBack
						.receiveMessage(user, chatId, recipients, message);
			} finally {

			}
		}
	}
}
