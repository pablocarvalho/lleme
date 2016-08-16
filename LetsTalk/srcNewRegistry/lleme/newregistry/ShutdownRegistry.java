package lleme.newregistry;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class ShutdownRegistry extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7693931494038561776L;

	private RegistryStarter starter = null;

	public void actionPerformed(ActionEvent e) {
		starter.shutdownComponent();
	}

	public RegistryStarter getStarter() {
		return starter;
	}

	public void setStarter(RegistryStarter starter) {
		this.starter = starter;
	}

}
