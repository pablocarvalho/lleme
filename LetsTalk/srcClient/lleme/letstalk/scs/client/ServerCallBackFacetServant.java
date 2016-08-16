package lleme.letstalk.scs.client;

import lleme.letstalk.Chat;
import lleme.letstalk.LetsTalk;

import java.util.HashMap;
import java.util.Iterator;

import corbaObjects.letstalk.CommFacet;
import corbaObjects.letstalk.CommFacetHelper;
import corbaObjects.letstalk.ServerCallBackFacetPOA;
import corbaObjects.letstalk.UserFacet;
import corbaObjects.letstalk.UserFacetHelper;
import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ConnectionDescription;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;

/**
 * @author Luiz Leme
 */
public class ServerCallBackFacetServant extends ServerCallBackFacetPOA {

	public HashMap chats = null;

	public LetsTalkServant component = null;

	private ClientUserFacetServant clientUserFacetServant = null;

	public LetsTalk appWindow = null;

	public ServerCallBackFacetServant(LetsTalkServant component,
			ClientUserFacetServant clientUserFacetServant, LetsTalk appWindow) {
		chats = new HashMap();
		this.component = component;
		this.clientUserFacetServant = clientUserFacetServant;
		this.appWindow = appWindow;
	}

	public synchronized void updateDirectory() throws InternalError {
		UserFacet userFacet = null;
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserFacet.class.getName())[0];
			if (desc != null)
				userFacet = UserFacetHelper.narrow(desc.objref);
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

		String[] lista = userFacet.listUsers();
		appWindow.getDefaultListModel().removeAllElements();
		for (int i = 0; i < lista.length; i++) {
			appWindow.getDefaultListModel().addElement(lista[i]);
		}
		appWindow.repaint();
		Iterator iter = chats.values().iterator();
		Chat chat = null;
		while (iter.hasNext()) {
			chat = (Chat) iter.next();
			chat.usuarios.removeAllElements();
			for (int i = 0; i < lista.length; i++) {
				chat.usuarios.addElement(lista[i]);
			}
		}
	}

	public synchronized void receiveMessage(String user, String chatId,
			String[] userId, String message) throws InternalError {

		UserFacet userFacet = null;
		CommFacet commFacet = null;
		try {
			ConnectionDescription desc = component
					.getReceptacleConnections(UserFacet.class.getName())[0];
			if (desc != null)
				userFacet = UserFacetHelper.narrow(desc.objref);
			else
				throw new InternalError();

			desc = component
					.getReceptacleConnections(CommFacet.class.getName())[0];
			if (desc != null)
				commFacet = CommFacetHelper.narrow(desc.objref);
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

		Chat chat = null;
		if (chats.get(chatId) == null) {
			chats.put(chatId, new Chat(chatId, userId));
			String[] lista = userFacet.listUsers();
			chat = (Chat) chats.get(chatId);
			chat.setTitle(chatId + " - " + clientUserFacetServant.getUserId());
			chat.component = component;
			for (int i = 0; i < lista.length; i++) {
				chat.usuarios.addElement(lista[i]);
			}
		}
		if (chat == null)
			chat = (Chat) chats.get(chatId);
		chat.destinatarios.removeAllElements();
		for (int i = 0; i < userId.length; i++) {
			chat.destinatarios.addElement(userId[i]);
		}
		if (message != null && !message.equals("")) {
			chat.mensRecList.append("\n\n" + user + " -> " + message);
			chat.mensRecList.setCaretPosition(chat.mensRecList.getText()
					.length());
		}
		chat.setVisible(true);
		chat.setFocusable(true);
	}
}
