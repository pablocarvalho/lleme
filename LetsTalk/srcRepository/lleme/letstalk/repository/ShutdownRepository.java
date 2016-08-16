package lleme.letstalk.repository;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class ShutdownRepository extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7693931494038561776L;

	private RepositoryStarter starter = null;

	public void actionPerformed(ActionEvent e) {
		starter.shutdownComponent();
	}

	public RepositoryStarter getStarter() {
		return starter;
	}

	public void setStarter(RepositoryStarter starter) {
		this.starter = starter;
	}

}
