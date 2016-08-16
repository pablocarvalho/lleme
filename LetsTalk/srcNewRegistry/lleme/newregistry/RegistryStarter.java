package lleme.newregistry;

import lleme.letstalk.scs.newregistry.RegistryServant;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

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

import corbaObjects.scs.IComponent;
import corbaObjects.scs.IComponentHelper;
import corbaObjects.scs.NodeDescription;
import corbaObjects.scs.NodeLookup;
import corbaObjects.scs.NodeLookupHelper;


public class RegistryStarter extends JFrame implements Runnable {


	private static final long serialVersionUID = -5544530363277417600L;

	private JPanel jContentPane = null;

	private org.omg.CORBA.ORB myOrb = null;

	private JButton serverButton = null;

	private StartRegistry startRegistry = null; // @jve:decl-index=0:visual-constraint=""

	private ShutdownRegistry shutdownRegistry = null; // @jve:decl-index=0:visual-constraint=""

	private Thread thread = null;

	private static final String LOG_FILENAME = "registryStarter.log";

	private JScrollPane jScrollPane = null;

	private JTree jTree = null;

	public RegistryStarter() throws HeadlessException {
		super();
		initialize();
	}

	public RegistryStarter(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public RegistryStarter(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public RegistryStarter(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

	private JButton getServerButton() {
		if (serverButton == null) {
			serverButton = new JButton();
			serverButton
					.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			serverButton.setActionCommand("start");
			serverButton.setMaximumSize(new java.awt.Dimension(100, 100));
			serverButton.setAction(getStartRegistry());
			serverButton.setText("Start Registry");
		}
		return serverButton;
	}

	private StartRegistry getStartRegistry() {
		if (startRegistry == null) {
			startRegistry = new StartRegistry();
		}
		return startRegistry;
	}

	private ShutdownRegistry getShutdownRegistry() {
		if (shutdownRegistry == null) {
			shutdownRegistry = new ShutdownRegistry();
		}
		return shutdownRegistry;
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new java.awt.Dimension(335, 294));
		this.setLocation(new java.awt.Point(0, 120));
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
		this.setTitle("Registry");
		getStartRegistry().setStarter(this);
		getShutdownRegistry().setStarter(this);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.ipadx = 1;
			gridBagConstraints1.ipady = 1;
			gridBagConstraints1.insets = new java.awt.Insets(0, 0, 0, 0);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints.ipadx = 1;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.setPreferredSize(new java.awt.Dimension(180, 200));
			jContentPane.setMinimumSize(new java.awt.Dimension(180, 200));
			jContentPane.add(getServerButton(), gridBagConstraints);
			jContentPane.add(getJButton(), gridBagConstraints11);
			// jContentPane.add(getJScrollPane(), gridBagConstraints1);
			jContentPane.add(getDomainExplorer(), gridBagConstraints1);
		}
		return jContentPane;
	}

	private DomainExplorer domainExplorer = null;

	public DomainExplorer getDomainExplorer() {
		if (domainExplorer == null)
			domainExplorer = new DomainExplorer();
		return domainExplorer;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTree());
		}
		return jScrollPane;
	}


	private JTree getJTree() {
		if (jTree == null) {
			jTree = new JTree(getTreeNodes());
		}
		return jTree;
	}

	private DefaultMutableTreeNode treeNodes = null;

	private IComponent registry = null;

	private JButton jButton = null;

	private DefaultMutableTreeNode getTreeNodes() {
		if (treeNodes == null) {
			DefaultMutableTreeNode treeNode = null;
			NodeLookup nodeLookup = null;
			NodeDescription[] nodes = null;
			treeNodes = new DefaultMutableTreeNode("Registry domain");
			if (registry != null) {
				try {
					nodeLookup = NodeLookupHelper.narrow(registry
							.getFacet(NodeLookup.class.getName()));
					nodes = nodeLookup.getAllNodes();
					NodeDescriptionHolder holder = null;
					for (int i = 0; i < nodes.length; i++) {
						holder = new NodeDescriptionHolder();
						holder.desc = nodes[i];
						treeNode = new DefaultMutableTreeNode(holder);
						treeNodes.add(treeNode);
					}
				} catch (corbaObjects.scs.InvalidName e) {

				}
			}
		}
		return treeNodes;
	}

	public void updateTreeNodes() {
		jTree = null;
		treeNodes = null;
		getJScrollPane().setViewportView(getJTree());
		repaint();
	}


	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Refresh nodes");
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getDomainExplorer().updateTreeNodes();
				}
			});
		}
		return jButton;
	}

	public static void main(String[] args) {
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(
					RegistryStarter.LOG_FILENAME), true);
			System.setErr(ps);
			System.setOut(ps);
			(new RegistryStarter()).setVisible(true);
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
			RegistryServant servant = new RegistryServant(myOrb, this);
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);
			this.registry = IComponentHelper.narrow(obj);
			nc = NamingContextExtHelper.narrow(myOrb
					.resolve_initial_references("TNameService"));
			nc.rebind(nc.to_name("registry"), obj);

			getDomainExplorer().registry = this.registry;

			// try {
			// PrintWriter out = new PrintWriter(new BufferedWriter(
			// new FileWriter(RegistryStarter.IOR)));
			// out.println(orb.object_to_string(obj));
			// out.close();
			// } catch (Exception e) {
			// JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
			// }
			getServerButton().setAction(getShutdownRegistry());
			getServerButton().setActionCommand("shutdown");
			getServerButton().setText("Shutdown Registry");
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
			nc.unbind(nc.to_name("registry"));
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
			getServerButton().setAction(getStartRegistry());
			getServerButton().setActionCommand("start");
			getServerButton().setText("Start Registry");
			repaint();
		}
	}

	private void exitForm() {
		if (myOrb != null)
			shutdownComponent();
		System.out.close();
	}

} // @jve:decl-index=0:visual-constraint="10,10"
