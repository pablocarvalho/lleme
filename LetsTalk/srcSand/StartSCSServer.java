import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class StartSCSServer extends AbstractAction {

	private SCSServer scsServer = null;

	public void actionPerformed(ActionEvent e) {
		scsServer.startServer();
	}

	public SCSServer getScsServer() {
		return scsServer;
	}

	public void setScsServer(SCSServer scsServer) {
		this.scsServer = scsServer;
	}

}
