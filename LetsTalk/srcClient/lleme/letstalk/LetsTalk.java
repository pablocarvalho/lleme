package lleme.letstalk;

import lleme.letstalk.scs.client.LetsTalkServant;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.omg.CORBA.ORB;

import corbaObjects.letstalk.CommFacet;
import corbaObjects.letstalk.CommFacetHelper;
import corbaObjects.letstalk.UserFacet;
import corbaObjects.letstalk.UserFacetHelper;
import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.NoConnection;

/**
 * @author Luiz Leme
 */
public class LetsTalk extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu fileMenu = null;

	private JMenu helpMenu = null;

	private JMenuItem exitMenuItem = null;

	private JMenuItem aboutMenuItem = null;

	private JTextField identification = null;

	private JButton connection = null;

	private JPanel jPanel = null;

	private JButton chat = null;

	private OpenChatWindow openDialogWindow = null; // @jve:decl-index=0:visual-constraint="-21,22"

	private JPanel jPanel1 = null;

	private Connect connect = null;

	private Disconnect disconnect = null;

	public LetsTalk() throws HeadlessException {
		initialize();
	}

	private JTextField getIdentification() {
		if (identification == null) {
			identification = new JTextField();
			identification.setText("<user identification>");
			identification.setColumns(10);
		}
		return identification;
	}

	/**
	 * @return Returns the connection.
	 */
	private JButton getConnection() {
		if (connection == null) {
			connection = new JButton();
			connection.setBorder(javax.swing.BorderFactory
					.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
			connection.setAction(getConnect());
			connection.setBorderPainted(true);
			connection.setEnabled(true);
			connection.setActionCommand("Connect");
			connection.setText("Connect");
		}
		return connection;
	}

	/**
	 * @return Returns the jPanel.
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.insets = new java.awt.Insets(5, 5, 5, 5);
			gridBagConstraints51.gridy = 1;
			gridBagConstraints51.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints51.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.ipadx = 55;
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new java.awt.Insets(2, 2, 2, 2);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new java.awt.Insets(5, 5, 5, 5);
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.ipadx = 20;
			gridBagConstraints3.ipady = 22;
			gridBagConstraints3.gridheight = 2;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 55;
			gridBagConstraints2.ipady = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new java.awt.Insets(2, 2, 2, 2);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new java.awt.Insets(5, 5, 5, 5);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.ipady = 0;
			gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints1.gridheight = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints9.ipadx = 120;
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 1;
			gridBagConstraints9.weightx = 1.0;
			jLabel1 = new JLabel();
			jLabel1.setText("Password: ");
			jLabel = new JLabel();
			jLabel.setText("User id: ");
			jLabel.setOpaque(false);
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel
					.setCursor(new java.awt.Cursor(
							java.awt.Cursor.DEFAULT_CURSOR));
			jPanel.setName("jPanel");
			jPanel.setMinimumSize(new java.awt.Dimension(100, 50));
			jPanel.setPreferredSize(new java.awt.Dimension(100, 50));
			jPanel.setMaximumSize(new java.awt.Dimension(2147483647, 0));
			jPanel.add(jLabel, gridBagConstraints1);
			jPanel.add(getIdentification(), gridBagConstraints2);
			jPanel.add(getConnection(), gridBagConstraints3);
			jPanel.add(getPassword(), gridBagConstraints4);
			jPanel.add(jLabel1, gridBagConstraints51);
		}
		return jPanel;
	}

	/**
	 * @return Returns the chat.
	 */
	private JButton getChat() {
		if (chat == null) {
			chat = new JButton();
			chat.setActionCommand("openDialogWindow");
			chat.setAction(getOpenDialogWindow());
			chat.setEnabled(false);
			chat.setText("Chat");
		}
		return chat;
	}

	/**
	 * @return Returns the openDialogWindow.
	 */
	private OpenChatWindow getOpenDialogWindow() {
		if (openDialogWindow == null) {
			openDialogWindow = new OpenChatWindow();
			openDialogWindow.letsTalk = this;
		}
		return openDialogWindow;
	}

	/**
	 * @return Returns the jPanel1.
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.ipadx = 200;
			gridBagConstraints6.ipady = 10;
			gridBagConstraints6.weightx = 0.0;
			gridBagConstraints6.weighty = 100.0;
			gridBagConstraints6.gridwidth = 1;
			gridBagConstraints6.anchor = java.awt.GridBagConstraints.NORTH;
			gridBagConstraints6.gridx = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.insets = new java.awt.Insets(0, 0, 0, 0);
			gridBagConstraints5.gridy = 0;
			gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.ipadx = 0;
			gridBagConstraints5.anchor = java.awt.GridBagConstraints.NORTH;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.ipady = 0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.gridx = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getChat(), gridBagConstraints5);
			jPanel1.add(getJScrollPane(), gridBagConstraints6);
		}
		return jPanel1;
	}

	/**
	 * @return Returns the disconnect.
	 */
	private Disconnect getDisconnect() {
		if (disconnect == null) {
			disconnect = new Disconnect();
			disconnect.letsTalk = this;
		}
		return disconnect;
	}

	/**
	 * @return Returns the connect.
	 */
	private Connect getConnect() {
		if (connect == null) {
			connect = new Connect();
			connect.letsTalk = this;
		}
		return connect;
	}

	/**
	 * @return Returns the users.
	 */
	private JList getUsers() {
		if (users == null) {
			users = new JList();
			users.setPreferredSize(new java.awt.Dimension(2, 100));
			users.setEnabled(false);
			users.setModel(getDefaultListModel());
			users.setSelectionModel(getDefaultListSelectionModel());
			users.setLayoutOrientation(JList.VERTICAL);
			users.setVisibleRowCount(-1);
		}
		return users;
	}

	/**
	 * @return Returns the jScrollPane.
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setAutoscrolls(false);
			jScrollPane.setCursor(new java.awt.Cursor(
					java.awt.Cursor.DEFAULT_CURSOR));
			jScrollPane.setPreferredSize(new java.awt.Dimension(259, 200));
			jScrollPane
					.setComponentOrientation(java.awt.ComponentOrientation.UNKNOWN);
			jScrollPane.setViewportView(getUsers());
		}
		return jScrollPane;
	}

	/**
	 * @return Returns the password.
	 */
	private JPasswordField getPassword() {
		if (password == null) {
			password = new JPasswordField();
			password.setText("password");
		}
		return password;
	}

	/**
	 * @return Returns the defaultListModel.
	 */
	public DefaultListModel getDefaultListModel() {
		if (defaultListModel == null) {
			defaultListModel = new DefaultListModel();
			defaultListModel.setSize(0);
		}
		return defaultListModel;
	}

	/**
	 * @return Returns the defaultListSelectionModel.
	 */
	private DefaultListSelectionModel getDefaultListSelectionModel() {
		if (defaultListSelectionModel == null) {
			defaultListSelectionModel = new DefaultListSelectionModel();
		}
		return defaultListSelectionModel;
	}

	/**
	 * This method initializes subscribeMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSubscribeMenuItem() {
		if (subscribeMenuItem == null) {
			subscribeMenuItem = new JMenuItem();
			subscribeMenuItem.setText("Subscribe LetsTalk");
			subscribeMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					(new Inscrever(LetsTalk.this)).setVisible(true);
				}
			});
		}
		return subscribeMenuItem;
	}

	public static final String LOG_FILENAME = "letstalk.log";

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream(LetsTalk.LOG_FILENAME),
					true);
			System.setErr(ps);
			System.setOut(ps);
			(new LetsTalk()).setVisible(true);
		} catch (FileNotFoundException e) {

		}
	}

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
		this.setLocation(new java.awt.Point(100, 100));
		this.setSize(new java.awt.Dimension(261, 435));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("LetsTalk");
	}

	public void exitForm() {
		disconnect();
	}

	/**
	 * @return Returns the jContentPane.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(),
					BoxLayout.Y_AXIS));
			jContentPane.setPreferredSize(new java.awt.Dimension(162, 52));
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
		}
		return jContentPane;
	}

	/**
	 * @return Returns the jJMenuBar.
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * @return Returns the fileMenu.
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getExitMenuItem());
			fileMenu.add(getSubscribeMenuItem());
		}
		return fileMenu;
	}

	/**
	 * @return Returns the helpMenu.
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * @return Returns the exitMenuItem.
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					disconnect();
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * @return Returns the aboutMenuItem.
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new JDialog(LetsTalk.this, "About", true).setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JList users = null;

	private JScrollPane jScrollPane = null;

	private JPasswordField password = null;

	private DefaultListModel defaultListModel = null; // @jve:decl-index=0:visual-constraint=""

	private DefaultListSelectionModel defaultListSelectionModel = null; // @jve:decl-index=0:visual-constraint=""

	private JMenuItem subscribeMenuItem = null;

	// **********************************************

	private ORB orb = null;

	public LetsTalkServant letsTalkServant = null;

	public void run() {
		orb.run();
	}

	public void connect() {
		try {
			UserFacet clientUserFacet = UserFacetHelper.narrow(letsTalkServant
					.getFacet(UserFacet.class.getName()));
			clientUserFacet.connect(getIdentification().getText(),
					getPassword().getPassword().toString(), null);

			connection.setAction(getDisconnect());
			connection.setActionCommand("Disconnect");
			connection.setText("Disconnect");
			identification.setEnabled(false);
			password.setEnabled(false);
			users.setEnabled(true);
			chat.setEnabled(true);

		} catch (InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (InvalidConnection e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (AlreadyConnected e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (ExceededConnectionLimit e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (InternalError e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public void disconnect() {
		try {
			UserFacet clientUserFacet = UserFacetHelper.narrow(letsTalkServant
					.getFacet(UserFacet.class.getName()));
			clientUserFacet.disconnect(getIdentification().getText());

			getDefaultListModel().removeAllElements();
			connection.setAction(getConnect());
			connection.setActionCommand("Connect");
			connection.setText("Connect");
			identification.setEnabled(true);
			password.setEnabled(true);
			users.setEnabled(false);
			chat.setEnabled(false);

		} catch (InvalidConnection e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (InternalError e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (NoConnection e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		} catch (InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public void openChat() {

		CommFacet clientCommFacet = null;
		try {
			clientCommFacet = CommFacetHelper.narrow(letsTalkServant
					.getFacet(CommFacet.class.getName()));
		} catch (InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

		ArrayList lista = new ArrayList();
		lista.add(getIdentification().getText());
		for (int i = 0; i < getDefaultListModel().size(); i++) {
			if (getDefaultListSelectionModel().isSelectedIndex(i)
					&& !((String) getDefaultListModel().get(i))
							.equals(getIdentification().getText()))
				lista.add(getDefaultListModel().get(i));
		}
		if (lista.isEmpty())
			JOptionPane.showMessageDialog(this, "Selecione algum usuário");
		else
			try {
				clientCommFacet.startChatting("", (String[]) lista
						.toArray(new String[0]));
			} catch (InvalidConnection e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			} catch (InternalError e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
	}

	public void finalize() throws Throwable {
		exitForm();
		super.finalize();
	}
}
