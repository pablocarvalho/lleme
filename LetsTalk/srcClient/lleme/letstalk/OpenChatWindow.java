package lleme.letstalk;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * @author Luiz Leme
 */
public class OpenChatWindow extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5732736318280209374L;

	public LetsTalk letsTalk = null;

	public void actionPerformed(ActionEvent e) {
		if (this.letsTalk != null)
			letsTalk.openChat();
	}

}
