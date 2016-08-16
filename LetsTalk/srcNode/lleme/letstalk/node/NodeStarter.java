package lleme.letstalk.node;

import lleme.letstalk.scs.node.NodeServant;

import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import corbaObjects.scs.AlreadyConnected;
import corbaObjects.scs.ComponentAlreadyInstalled;
import corbaObjects.scs.ComponentAlreadyLoaded;
import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ComponentDescription;
import corbaObjects.scs.ComponentHelp;
import corbaObjects.scs.ComponentLoader;
import corbaObjects.scs.ComponentLoaderHelper;
import corbaObjects.scs.ComponentNotFound;
import corbaObjects.scs.ComponentNotInstalled;
import corbaObjects.scs.ComponentRepository;
import corbaObjects.scs.ComponentRepositoryHelper;
import corbaObjects.scs.ContainerAlreadyExists;
import corbaObjects.scs.ExceededConnectionLimit;
import corbaObjects.scs.ExecutionNode;
import corbaObjects.scs.ExecutionNodeHelper;
import corbaObjects.scs.IComponent;
import corbaObjects.scs.IComponentHelper;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidConnection;
import corbaObjects.scs.LoadFailure;
import corbaObjects.scs.NoConnection;
import corbaObjects.scs.NodeRegister;

public class NodeStarter extends JFrame implements Runnable {

	private static final long serialVersionUID = -5807608374289072393L;

	private JTextField filename = null;

	private JButton install = null;

	private JButton uninstall = null;

	private JPanel instalationPanel = null;

	public static final String LOG_FILENAME = "nodeStarter.log";

	private JPanel repositoryPanel = null;

	private JPanel actionPanel = null;

	private JPanel dataPanel = null;

	private JLabel jLabel = null;

	private JButton refresh = null;

	private JButton start = null;

	private JScrollPane jScrollPane = null;

	private JList installedComponents = null;

	private JPanel actinPanel = null;

	private JPanel dataPanel2 = null;

	private JLabel jLabel1 = null;

	private JPanel jContentPane = null;

	private DefaultListModel defaultListModel = null;

	private DefaultListSelectionModel defaultListSelectionModel = null;

	public NodeStarter() throws HeadlessException {
		super();
		initialize();
	}

	public NodeStarter(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public NodeStarter(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	public NodeStarter(String title, GraphicsConfiguration gc) {
		super(title, gc);
		initialize();
	}

	private JTextField getFilename() {
		if (filename == null) {
			filename = new JTextField();
			filename.setText("Install.xml");
		}
		return filename;
	}

	private JButton getInstall() {
		if (install == null) {
			install = new JButton();
			install.setText("Install");
			install.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					install();
				}
			});
		}
		return install;
	}

	private JButton getUninstall() {
		if (uninstall == null) {
			uninstall = new JButton();
			uninstall.setText("Uninstall");
			uninstall.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					uninstall();
				}
			});
		}
		return uninstall;
	}

	private JPanel getInstalationPanel() {
		if (instalationPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridx = -1;
			gridBagConstraints.gridy = -1;
			gridBagConstraints.ipadx = 1;
			gridBagConstraints.ipady = 1;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.insets = new Insets(0, 0, 0, 0);
			instalationPanel = new JPanel();
			instalationPanel.setLayout(new BoxLayout(getInstalationPanel(),
					BoxLayout.Y_AXIS));
			instalationPanel.setBorder(null);
			instalationPanel.add(getDataPanel(), null);
			instalationPanel.add(getActionPanel(), null);
		}
		return instalationPanel;
	}

	private JPanel getRepositoryPanel() {
		if (repositoryPanel == null) {
			repositoryPanel = new JPanel();
			repositoryPanel.setPreferredSize(new java.awt.Dimension(353, 300));
			repositoryPanel
					.setComponentOrientation(java.awt.ComponentOrientation.UNKNOWN);
			repositoryPanel.setLayout(new BoxLayout(getRepositoryPanel(),
					BoxLayout.Y_AXIS));
			repositoryPanel.add(getActinPanel(), null);
			repositoryPanel.add(getDataPanel2(), null);
		}
		return repositoryPanel;
	}

	private JPanel getActionPanel() {
		if (actionPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			actionPanel = new JPanel();
			actionPanel.setLayout(gridLayout);
			actionPanel.add(getInstall(), null);
			actionPanel.add(getUninstall(), null);
		}
		return actionPanel;
	}

	private JPanel getDataPanel() {
		if (dataPanel == null) {
			jLabel = new JLabel();
			jLabel.setBorder(null);
			jLabel.setText("Filename: ");
			dataPanel = new JPanel();
			dataPanel
					.setLayout(new BoxLayout(getDataPanel(), BoxLayout.X_AXIS));
			dataPanel.add(jLabel, null);
			dataPanel.add(getFilename(), null);
		}
		return dataPanel;
	}

	private JButton getRefresh() {
		if (refresh == null) {
			refresh = new JButton();
			refresh.setText("Refresh installed components list");
			refresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					refreshComponentsList();
				}
			});
		}
		return refresh;
	}

	private JButton getStart() {
		if (start == null) {
			start = new JButton();
			start.setText("Start component");
			start.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadComponent();
				}
			});
		}
		return start;
	}

	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setPreferredSize(new java.awt.Dimension(259, 150));
			jScrollPane.setViewportView(getInstalledComponents());
		}
		return jScrollPane;
	}

	private JList getInstalledComponents() {
		if (installedComponents == null) {
			installedComponents = new JList();
			installedComponents
					.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			installedComponents.setModel(getDefaultListModel());
			installedComponents
					.setSelectionModel(getDefaultListSelectionModel());
		}
		return installedComponents;
	}

	private JPanel getActinPanel() {
		if (actinPanel == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(2);
			gridLayout1.setColumns(1);
			actinPanel = new JPanel();
			actinPanel.setLayout(gridLayout1);
			actinPanel.add(getStart(), null);
			actinPanel.add(getRefresh(), null);
		}
		return actinPanel;
	}

	private JPanel getDataPanel2() {
		if (dataPanel2 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Installed components");
			dataPanel2 = new JPanel();
			dataPanel2.setLayout(new BoxLayout(getDataPanel2(),
					BoxLayout.Y_AXIS));
			dataPanel2.setPreferredSize(new java.awt.Dimension(396, 300));
			dataPanel2.add(jLabel1, null);
			dataPanel2.add(getJScrollPane(), null);
		}
		return dataPanel2;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(),
					BoxLayout.Y_AXIS));
			jContentPane.add(getInstalationPanel(), null);
			jContentPane.add(getRepositoryPanel(), null);
		}
		return jContentPane;
	}

	private DefaultListModel getDefaultListModel() {
		if (defaultListModel == null) {
			defaultListModel = new DefaultListModel();
		}
		return defaultListModel;
	}

	private DefaultListSelectionModel getDefaultListSelectionModel() {
		if (defaultListSelectionModel == null) {
			defaultListSelectionModel = new DefaultListSelectionModel();
		}
		return defaultListSelectionModel;
	}

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(
					new FileOutputStream(NodeStarter.LOG_FILENAME), true);
			System.setErr(ps);
			System.setOut(ps);
			(new NodeStarter()).setVisible(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				exitForm();
			}

			public void windowClosed(java.awt.event.WindowEvent evt) {
				System.gc();
			}
		});
		this.setTitle("ExecutionNode");
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.setBounds(new java.awt.Rectangle(400, 300, 270, 311));
		startComponent();
		refreshComponentsList();
	}

	private void exitForm() {
		System.out.close();
		shutdownComponent();
	}

	private int registryConnectionId = 0;

	private ORB orb = null;

	private IComponent node = null;

	private IComponent registry = null;

	private IComponent repository = null;

	public void startComponent() {
		ORB orb = null;
		String[] args = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "2900";
		// args[2] = "-ORBInitialHost";
		// args[3] = "192.168.254.1";
		orb = ORB.init(args, null);
		this.orb = orb;
		// (new Thread(this)).start();
		NamingContextExt nc = null;
		POA poa = null;
		try {
			nc = NamingContextExtHelper.narrow(orb
					.resolve_initial_references("TNameService"));
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			repository = IComponentHelper.narrow(nc.resolve(nc
					.to_name("repository")));
			registry = IComponentHelper.narrow(nc.resolve(nc
					.to_name("registry")));
			NamingContextExt namingFacet = NamingContextExtHelper
					.narrow(registry.getFacet(NamingContextExt.class.getName()));

			NodeServant servant = new NodeServant(orb);
			org.omg.CORBA.Object obj = poa.servant_to_reference(servant);

			servant.connect("componentRepositoryReceptacle", repository
					.getFacet(ComponentRepository.class.getName()));

			servant.connect("componentHelpReceptacle", repository
					.getFacet(ComponentHelp.class.getName()));

			servant.connect("componentCollectionReceptacle", registry
					.getFacet(ComponentCollection.class.getName()));

			registryConnectionId = servant.connect("nodeRegisterReceptacle",
					registry.getFacet(NodeRegister.class.getName()));
			servant.connect("namingContextExtReceptacle", namingFacet);

			node = IComponentHelper.narrow(obj);

		} catch (InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (AdapterInactive e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (NotFound e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (CannotProceed e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ServantNotActive e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (WrongPolicy e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (corbaObjects.scs.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (InvalidConnection e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (AlreadyConnected e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ExceededConnectionLimit e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} finally {
		}
	}

	public void shutdownComponent() {
		try {
			node.disconnect(registryConnectionId);
		} catch (SecurityException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (InvalidConnection e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (NoConnection e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} finally {
			// orb.shutdown(true);
		}
	}

	public void run() {
		orb.run();
	}

	public void loadComponent() {
		for (int i = 0; i < getDefaultListModel().size(); i++) {
			if (getDefaultListSelectionModel().isSelectedIndex(i)) {
				ComponentDescriptionHolder descHolder = null;
				ExecutionNode exec = null;
				IComponent container = null;
				ComponentLoader loader = null;
				ComponentRepository repFacet = null;
				ComponentCollection collFacet = null;
				try {
					descHolder = (ComponentDescriptionHolder) getDefaultListModel()
							.get(i);
					exec = ExecutionNodeHelper.narrow(node
							.getFacet(ExecutionNode.class.getName()));
					container = exec.startContainer(descHolder.desc.id.name);
					loader = ComponentLoaderHelper.narrow(container
							.getFacet(ComponentLoader.class.getName()));
					loader.load(descHolder.desc.id, new String[0]);

				} catch (ContainerAlreadyExists e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + "\n"
							+ e);
				} catch (ComponentNotFound e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + "\n"
							+ e);
				} catch (ComponentAlreadyLoaded e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + "\n"
							+ e);
				} catch (LoadFailure e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + "\n"
							+ e);
				} catch (corbaObjects.scs.InvalidName e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + "\n"
							+ e);
				} catch (InternalError e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + "\n"
							+ e);
				}
			}
		}
	}

	private void install() {
		try {
			ComponentRepository repositoryFacet = ComponentRepositoryHelper
					.narrow(node.getFacet(ComponentRepository.class.getName()));
			Builder builder = new ComponentsInfoBuilder();
			MyXMLReader reader = new MyXMLReader(builder);
			reader.parse(new InputSource(getFilename().getText()));
			ComponentInfo[] components = (ComponentInfo[]) builder.getResult();
			FileInputStream in = null;
			byte[] file = null;
			for (int i = 0; i < components.length; i++) {
				in = new FileInputStream(components[i].filename);
				in.read(file = new byte[in.available()]);
				in.close();
				repositoryFacet.install(components[i].desc.id,
						components[i].desc.entry_point,
						components[i].desc.shared, file,
						components[i].desc.help_info);
			}
			refreshComponentsList();
		} catch (InvalidSourceContentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ParserConfigurationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (SAXException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ComponentAlreadyInstalled e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (corbaObjects.scs.IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (corbaObjects.scs.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} finally {

		}
	}

	private void uninstall() {
		try {
			ComponentRepository repositoryFacet = ComponentRepositoryHelper
					.narrow(node.getFacet(ComponentRepository.class.getName()));
			Builder builder = new ComponentsInfoBuilder();
			MyXMLReader reader = new MyXMLReader(builder);
			reader.parse(new InputSource(getFilename().getText()));
			ComponentInfo[] components = (ComponentInfo[]) builder.getResult();
			for (int i = 0; i < components.length; i++) {
				repositoryFacet.uninstall(components[i].desc.id);
			}
			refreshComponentsList();
		} catch (InvalidSourceContentException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ParserConfigurationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (SAXException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (corbaObjects.scs.IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (ComponentNotInstalled e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} catch (corbaObjects.scs.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		} finally {

		}
	}

	private void refreshComponentsList() {
		ComponentRepository repository = null;
		try {
			repository = ComponentRepositoryHelper.narrow(node
					.getFacet(ComponentRepository.class.getName()));
		} catch (corbaObjects.scs.InvalidName e) {
			JOptionPane.showMessageDialog(this, e.getMessage() + "\n" + e);
		}
		ComponentDescription[] lista = repository.getInstalledComponents();
		ComponentDescriptionHolder[] components = null;
		if (lista != null && lista.length != 0) {
			components = new ComponentDescriptionHolder[lista.length];
			for (int i = 0; i < lista.length; i++) {
				components[i] = new ComponentDescriptionHolder();
				components[i].desc = lista[i];
			}
		}
		getDefaultListModel().removeAllElements();
		for (int i = 0; i < lista.length; i++) {
			getDefaultListModel().addElement(components[i]);
		}
		repaint();
	}
}
