package lleme.letstalk.repository;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class StartRepository extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1008562070718206367L;

	private RepositoryStarter starter = null;

	public void actionPerformed(ActionEvent e) {
		starter.startComponent();
	}

	public RepositoryStarter getStarter() {
		return starter;
	}

	public void setStarter(RepositoryStarter starter) {
		this.starter = starter;
	}

}
