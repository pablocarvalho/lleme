package lleme.letstalk;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class Connect extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1850007409601564107L;

	/**
	 * @bidirectional
	 */
	public LetsTalk letsTalk = null;

	public void actionPerformed(ActionEvent e) {
		if (this.letsTalk != null)
			letsTalk.connect();
	}

}
