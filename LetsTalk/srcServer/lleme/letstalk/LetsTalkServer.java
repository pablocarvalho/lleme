package lleme.letstalk;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LetsTalkServer extends JFrame {

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	public LetsTalkServer() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}

	public LetsTalkServer(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public LetsTalkServer(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public LetsTalkServer(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	@SuppressWarnings("static-access")
	private void initialize() {
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm();
			}

			public void windowClosed(java.awt.event.WindowEvent evt) {
				System.gc();
			}
		});
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(186, 66);
		this.setContentPane(getJContentPane());
		this.setTitle("LetsTalk Server");
	}

	public void exitForm() {

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints.gridx = 0;
			jLabel = new JLabel();
			jLabel.setText("LetsTalkServer is running...");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jLabel.setBorder(null);
		}
		return jContentPane;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
