package lleme.letstalk;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class Disconnect extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6131206862360664469L;

	/**
	 * @bidirectional
	 */
	public LetsTalk letsTalk = null;

	public void actionPerformed(ActionEvent e) {
		if (this.letsTalk != null)
			letsTalk.disconnect();
	}
}
