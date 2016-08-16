/**
 * A 1.4 application that requires the following additional files:
 *   TreeDemoHelp.html
 *    arnold.html
 *    bloch.html
 *    chan.html
 *    jls.html
 *    swingtutorial.html
 *    tutorial.html
 *    tutorialcont.html
 *    vm.html
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

public class DomainExplorer extends JPanel implements TreeSelectionListener {

	private JEditorPane htmlPane;

	private JTree tree;

	private DefaultMutableTreeNode top;

	private JScrollPane treeView;

	private JScrollPane htmlView;

	private JSplitPane splitPane1;

	private JSplitPane splitPane2;

	private JPanel jpanel;

	private JButton refreshButton;

	private JButton starterButton;

	private static JFrame frame;

	private static boolean DEBUG = false;

	private static boolean playWithLineStyle = false;

	private static String lineStyle = "Horizontal";

	private static boolean useSystemLookAndFeel = false;

	private static SCS scs = null;

	private static ORB orb;

	private static POA poa;

	private NodeLookup nodeLookup = null;

	private IComponent registry = null;

	private String text;

	private HashMap texts = null;

	public DomainExplorer() {
		super(new GridLayout(1, 0));

		texts = new HashMap();

		// Create the nodes.
		top = new DefaultMutableTreeNode("Root");

		// createNodes(top);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);

		if (playWithLineStyle) {
			System.out.println("line style = " + lineStyle);
			tree.putClientProperty("JTree.lineStyle", lineStyle);
		}

		// Create the scroll pane and add the tree to it.
		treeView = new JScrollPane(tree);

		// Create the HTML viewing pane.
		htmlPane = new JEditorPane();
		htmlPane.setEditable(false);
		htmlView = new JScrollPane(htmlPane);

		// Add the scroll panes to a split pane.
		splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane1.setTopComponent(treeView);
		splitPane1.setBottomComponent(htmlView);

		Dimension minimumSize = new Dimension(100, 50);
		htmlView.setMinimumSize(minimumSize);
		treeView.setMinimumSize(minimumSize);
		splitPane1.setDividerLocation(100); // XXX: ignored in some releases
		// of Swing. bug 4101306
		// workaround for bug 4101306:
		// treeView.setPreferredSize(new Dimension(100, 100));

		splitPane1.setPreferredSize(new Dimension(500, 300));

		jpanel = new JPanel();
		starterButton = new JButton("Start");
		starterButton.setEnabled(true);
		jpanel.add(starterButton);

		refreshButton = new JButton("Refresh");
		refreshButton.setEnabled(false);
		jpanel.add(refreshButton);

		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setTopComponent(splitPane1);
		splitPane2.setBottomComponent(jpanel);

		// Add the split pane to this panel.
		add(splitPane2);

		refreshWindow handler = new refreshWindow();
		refreshButton.addActionListener(handler);

		startComponent _handler = new startComponent();
		starterButton.addActionListener(_handler);

	}

	/** Required by TreeSelectionListener interface. */
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		if (node == null)
			return;

		Object nodeInfo = node.getUserObject();
		String text = (String) texts.get(nodeInfo.toString());
		htmlPane.setText(text);

	}

	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode node = null;
		DefaultMutableTreeNode container = null;
		DefaultMutableTreeNode component = null;
		DefaultMutableTreeNode host = null;

		NodeDescription[] _nodeDesc = new NodeDescription[10];

		_nodeDesc = nodeLookup.getAllNodes();

		for (int i = 0; i < _nodeDesc.length; i++) {
			ExecutionNode executionNodeServant = ExecutionNodeHelper
					.narrow(_nodeDesc[i].node
							.getFacetByName("ExecutionNodeFacet"));

			node = new DefaultMutableTreeNode(executionNodeServant.name());
			top.add(node);
			text = " ";

			for (int h = 0; h < _nodeDesc[i].props.length; h++)
				text = text + " " + _nodeDesc[i].props[h].name + " "
						+ _nodeDesc[i].props[h].value;

			texts.put(executionNodeServant.name(), text);

			ContainerDescription[] _containerDesc = new ContainerDescription[10];

			_containerDesc = executionNodeServant.getContainers();

			for (int j = 0; j < _containerDesc.length; j++) {
				container = new DefaultMutableTreeNode(
						_containerDesc[j].container_name);
				node.add(container);

				text = " ";
				texts.put(_containerDesc[j].container_name, text);

				ComponentCollection componentCollectionServant = ComponentCollectionHelper
						.narrow(_containerDesc[j].container
								.getFacetByName("ComponentCollectionFacet"));

				ComponentHandle[] _componentHandle = new ComponentHandle[10];
				_componentHandle = componentCollectionServant.getComponents();

				for (int k = 0; k < _componentHandle.length; k++) {
					component = new DefaultMutableTreeNode(
							_componentHandle[k].id.name
									+ _componentHandle[k].instance_id);
					container.add(component);

					text = "Acrescentar descrição de componente ";
					texts.put(_componentHandle[k].id.name
							+ _componentHandle[k].instance_id, text);
				}
			}
		}
	}

	private void updateTreeNodes() {
		top = null;
		tree = null;
		htmlPane = null;

		top = new DefaultMutableTreeNode("Root");
		htmlPane = new JEditorPane();

		createNodes(top);

		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);

		treeView.setViewportView(tree);
		htmlView.setViewportView(htmlPane);

		repaint();
	}

	private class refreshWindow implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			updateTreeNodes();
		}
	}

	private class startComponent implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (starterButton.getText() == "Start") {
				try {
					registry = scs.getIComponent("RegistryComponent", 1);

					nodeLookup = NodeLookupHelper.narrow(registry
							.getFacetByName("NodeLookupFacet"));
				} catch (InternalError e) {
					System.out.println("Erro");
				}

				starterButton.setText("Shutdown");
				refreshButton.setEnabled(true);

				updateTreeNodes();
			} else {
				/*
				 * try { NamingContextExt nc = NamingContextExtHelper.narrow(orb
				 * .resolve_initial_references("TNameService"));
				 * nc.unbind(nc.to_name("registry")); } catch
				 * (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
				 * System.out.println("Erro"); } catch (NotFound e) {
				 * System.out.println("Erro"); } catch (CannotProceed e) {
				 * System.out.println("Erro"); } catch (InvalidName e) {
				 * System.out.println("Erro"); }
				 */
				System.exit(1);
			}
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {

		if (useSystemLookAndFeel) {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				System.err.println("Couldn't use system look and feel.");
			}
		}

		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		frame = new JFrame("Domain Explorer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.

		DomainExplorer newContentPane = new DomainExplorer();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		orb = ORB.init(args, null);
		String SCS_IOR = "scsServant.ior";
		poa = null;
		scs = null;

		try {
			poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();
			String ior = null;
			BufferedReader in = new BufferedReader(new FileReader(SCS_IOR));
			ior = in.readLine();
			in.close();

			scs = SCSHelper.narrow(orb.string_to_object(ior));
		} catch (InvalidName e) {
			System.out.println("Erro");
		} catch (AdapterInactive e) {
			System.out.println("Erro");
		} catch (FileNotFoundException e) {
			System.out.println("Erro");
		} catch (IOException e) {
			System.out.println("Erro");
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}

		});
	}
}
