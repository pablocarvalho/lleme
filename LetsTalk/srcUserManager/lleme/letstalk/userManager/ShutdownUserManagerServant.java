package lleme.letstalk.userManager;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class ShutdownUserManagerServant extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2242175634464844751L;

	private UserManagerStarter userManagerServer = null;

	public void actionPerformed(ActionEvent e) {
		userManagerServer.shutdownServant();
	}

	/**
	 * @return Returns the userManagerServer.
	 */
	public UserManagerStarter getUserManagerServer() {
		return userManagerServer;
	}

	/**
	 * @param userManagerServer
	 *            The userManagerServer to set.
	 */
	public void setUserManagerServer(UserManagerStarter userManagerServer) {
		this.userManagerServer = userManagerServer;
	}

}
