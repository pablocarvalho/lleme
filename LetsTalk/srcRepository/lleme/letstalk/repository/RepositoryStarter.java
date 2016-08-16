package lleme.letstalk.repository;

import lleme.letstalk.scs.repository.RepositoryServant;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;


public class RepositoryStarter extends JFrame implements Runnable {


	private static final long serialVersionUID = -5544530363277417600L;

	private JPanel jContentPane = null;

	private org.omg.CORBA.ORB myOrb = null;

	private JButton serverButton = null;

	private StartRepository startRepository = null; // @jve:decl-index=0:visual-constraint=""

	private ShutdownRepository shutdownRepository = null; // @jve:decl-index=0:visual-constraint=""

	private Thread thread = null;

	private static final String LOG_FILENAME = "repositoryStarter.log";

	public RepositoryStarter() throws HeadlessException {
		super();
		initialize();
	}

	public RepositoryStarter(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public RepositoryStarter(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public RepositoryStarter(String title, GraphicsConfiguration gc) {
		super(title, gc);
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
			serverButton.setActionCommand("start");
			serverButton.setAction(getStartRepository());
			serverButton.setText("Start Repository");
		}
		return serverButton;
	}


	private StartRepository getStartRepository() {
		if (startRepository == null) {
			startRepository = new StartRepository();
		}
		return startRepository;
	}


	private ShutdownRepository getShutdownRepository() {
		if (shutdownRepository == null) {
			shutdownRepository = new ShutdownRepository();
		}
		return shutdownRepository;
	}


	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(new java.awt.Rectangle(0, 60, 183, 60));
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm();
			}

			public void windowClosed(java.awt.event.WindowEvent evt) {
				System.gc();
			}
		});
		this.setPreferredSize(new java.awt.Dimension(0, 0));
		this.setMinimumSize(new java.awt.Dimension(0, 0));
		this.setContentPane(getJContentPane());
		this.setTitle("Repository");
		getStartRepository().setStarter(this);
		getShutdownRepository().setStarter(this);
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
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(
					RepositoryStarter.LOG_FILENAME), true);
			System.setErr(ps);
			System.setOut(ps);
			(new RepositoryStarter()).setVisible(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		myOrb.run();
	}

	public void startComponent() {
		ORB orb = null;
		String[] args = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "2900";
		// args[2] = "-ORBInitialHost";
		// args[3] = "192.168.254.1";
		orb = ORB.init(args, null);
		this.myOrb = orb;
		// (new Thread(this)).start();
		NamingContextExt nc = null;
		POA poa = null;
		try {
			poa = POAHelper.narrow(myOrb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			RepositoryServant servant = new RepositoryServant(myOrb);
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			nc = NamingContextExtHelper.narrow(myOrb
					.resolve_initial_references("TNameService"));
			nc.rebind(nc.to_name("repository"), obj);
			// try {
			// PrintWriter out = new PrintWriter(new BufferedWriter(
			// new FileWriter(RepositoryStarter.IOR)));
			// out.println(orb.object_to_string(obj));
			// out.close();
			// } catch (Exception e) {
			// JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
			// }
			getServerButton().setAction(getShutdownRepository());
			getServerButton().setActionCommand("shutdown");
			getServerButton().setText("Shutdown Repository");
		} catch (AdapterInactive e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ServantNotActive e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (WrongPolicy e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (org.omg.CORBA.ORBPackage.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (NotFound e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (CannotProceed e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		}
	}

	public void shutdownComponent() {
		try {
			NamingContextExt nc = NamingContextExtHelper.narrow(myOrb
					.resolve_initial_references("TNameService"));
			nc.unbind(nc.to_name("repository"));
		} catch (org.omg.CORBA.ORBPackage.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (NotFound e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (CannotProceed e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} finally {
			// myOrb.shutdown(true);
			myOrb = null;
			getServerButton().setAction(getStartRepository());
			getServerButton().setActionCommand("start");
			getServerButton().setText("Start Repository");
			repaint();
		}
	}

	public void exitForm() {
		if (myOrb != null)
			shutdownComponent();
		System.out.close();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
