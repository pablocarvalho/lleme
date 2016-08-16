package lleme.letstalk.registry;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class StartRegistry extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1008562070718206367L;

	private RegistryStarter starter = null;

	public void actionPerformed(ActionEvent e) {
		starter.startComponent();
	}

	public RegistryStarter getStarter() {
		return starter;
	}

	public void setStarter(RegistryStarter starter) {
		this.starter = starter;
	}

}
