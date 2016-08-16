import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class SCSServer extends JFrame implements Runnable {

	private JPanel jContentPane = null;

	private org.omg.CORBA.ORB myOrb = null;

	private JButton serverButton = null;

	private StartSCSServer startSCSServer = null; // @jve:decl-index=0:visual-constraint=""

	private ShutdownSCSServer shutdownSCSServer = null; // @jve:decl-index=0:visual-constraint=""

	private Thread thread = null;

	public static String IOR = "scsServant.ior";

	public SCSServer() throws HeadlessException {
		super();
		initialize();
		getStartSCSServer().setScsServer(this);
		getShutdownSCSServer().setScsServer(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm();
			}

			public void windowClosed(java.awt.event.WindowEvent evt) {
				System.gc();
			}
		});
	}

	public SCSServer(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public SCSServer(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	public SCSServer(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}


	private JButton getServerButton() {
		if (serverButton == null) {
			serverButton = new JButton();
			serverButton.setPreferredSize(new java.awt.Dimension(180, 180));
			serverButton.setMinimumSize(new java.awt.Dimension(180, 180));
			serverButton.setMaximumSize(new java.awt.Dimension(500, 500));
			serverButton
					.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			serverButton.setAction(getStartSCSServer());
			serverButton.setText("Start SCSServer");
		}
		return serverButton;
	}


	private StartSCSServer getStartSCSServer() {
		if (startSCSServer == null) {
			startSCSServer = new StartSCSServer();
		}
		return startSCSServer;
	}

	private ShutdownSCSServer getShutdownSCSServer() {
		if (shutdownSCSServer == null) {
			shutdownSCSServer = new ShutdownSCSServer();
		}
		return shutdownSCSServer;
	}


	private void initialize() {
		this.setSize(183, 61);
		// this.setPreferredSize(new java.awt.Dimension(0, 0));
		// this.setMinimumSize(new java.awt.Dimension(0, 0));
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}


	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.setPreferredSize(new java.awt.Dimension(180, 200));
			jContentPane.setMinimumSize(new java.awt.Dimension(180, 200));
			jContentPane.add(getServerButton(), gridBagConstraints);
		}
		return jContentPane;
	}

	public org.omg.CORBA.ORB getMyOrb() {
		return myOrb;
	}

	public void setMyOrb(org.omg.CORBA.ORB orb) {
		this.myOrb = orb;
	}

	public static void main(String[] args) {
		(new SCSServer()).setVisible(true);
	}

	public void run() {
		ORB orb = null;
		// NamingContextExt nc = null;
		String[] args = new String[2];
		// args[0] = "-ORBInitialPort";
		// args[1] = "2900";
		// args[2] = "-ORBInitialHost";
		// args[3] = "192.168.254.1";
		orb = ORB.init(args, null);
		this.myOrb = orb;
		SCSFactoryServant scs = null;
		POA poa = null;
		try {
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			SCSFactoryServant servant = new SCSFactoryServant();
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			// nc = NamingContextExtHelper.narrow(orb
			// .resolve_initial_references("TNameService"));
			// nc.rebind(nc.to_name("scs"), obj);

			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter(SCSServer.IOR)));
				out.println(orb.object_to_string(obj));
				out.close();
			} catch (Exception e) {
				System.err.println(e);
			}
			getServerButton().setAction(getShutdownSCSServer());
			getServerButton().setActionCommand("shutdown");
			getServerButton().setText("Shutdown SCSServer");
			orb.run();
		} catch (AdapterInactive e) {
			e.printStackTrace();
		} catch (ServantNotActive e) {
			e.printStackTrace();
		} catch (WrongPolicy e) {
			e.printStackTrace();
		} catch (org.omg.CORBA.ORBPackage.InvalidName e) {
			e.printStackTrace();
		}
	}

	public void startServer() {
		(new Thread(this)).start();
	}

	public void shutdownServer() {
		myOrb.shutdown(true);
		myOrb = null;
		getServerButton().setAction(getStartSCSServer());
		getServerButton().setActionCommand("start");
		getServerButton().setText("Start SCSServer");
		repaint();
	}

	public void exitForm() {
		if (myOrb != null)
			shutdownServer();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
