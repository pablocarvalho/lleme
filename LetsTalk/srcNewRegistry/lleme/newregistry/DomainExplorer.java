package lleme.newregistry;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import corbaObjects.scs.ComponentCollection;
import corbaObjects.scs.ComponentCollectionHelper;
import corbaObjects.scs.ComponentHandle;
import corbaObjects.scs.ContainerDescription;
import corbaObjects.scs.ExecutionNode;
import corbaObjects.scs.ExecutionNodeHelper;
import corbaObjects.scs.IComponent;
import corbaObjects.scs.InvalidName;
import corbaObjects.scs.NodeDescription;
import corbaObjects.scs.NodeLookup;
import corbaObjects.scs.NodeLookupHelper;

@SuppressWarnings( { "serial", "serial" })
public class DomainExplorer extends JPanel implements TreeSelectionListener {

	private JEditorPane htmlPane;

	private JTree tree;

	private DefaultMutableTreeNode top;

	private JScrollPane treeView;

	private JScrollPane htmlView;

	private JSplitPane splitPane1;

	private JSplitPane splitPane2;

	private JPanel jpanel;

	private static boolean DEBUG = false;

	private static boolean playWithLineStyle = false;

	private static String lineStyle = "Horizontal";

	private static boolean useSystemLookAndFeel = false;

	public IComponent registry = null;

	private String text;

	private HashMap texts = null;

	public DomainExplorer() {
		super();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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

		// Dimension minimumSize = new Dimension(100, 100);
		// htmlView.setMinimumSize(minimumSize);
		// treeView.setMinimumSize(minimumSize);
		splitPane1.setDividerLocation(100); // XXX: ignored in some releases
		// of Swing. bug 4101306
		// workaround for bug 4101306:
		// treeView.setPreferredSize(new Dimension(100, 100));

		splitPane1.setPreferredSize(new Dimension(500, 300));

		jpanel = new JPanel();

		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setTopComponent(splitPane1);
		splitPane2.setBottomComponent(jpanel);

		// Add the split pane to this panel.
		// add(splitPane2);
		add(splitPane1);

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

	@SuppressWarnings( { "unchecked", "unchecked", "unchecked" })
	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode node = null;
		DefaultMutableTreeNode container = null;
		DefaultMutableTreeNode component = null;
		DefaultMutableTreeNode host = null;

		NodeDescription[] _nodeDesc = new NodeDescription[10];

		NodeLookup nodeLookup = null;
		try {
			nodeLookup = NodeLookupHelper.narrow(registry
					.getFacet(NodeLookup.class.getName()));
		} catch (InvalidName e1) {
			JOptionPane.showMessageDialog(DomainExplorer.this, e1.getMessage()
					+ "\n" + e1);
		}
		_nodeDesc = nodeLookup.getAllNodes();

		for (int i = 0; i < _nodeDesc.length; i++) {
			ExecutionNode executionNodeServant = null;
			try {
				executionNodeServant = ExecutionNodeHelper
						.narrow(_nodeDesc[i].node.getFacet(ExecutionNode.class
								.getName()));
			} catch (corbaObjects.scs.InvalidName e) {
				JOptionPane.showMessageDialog(DomainExplorer.this, e
						.getMessage()
						+ "\n" + e);
			}

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

				ComponentCollection componentCollectionServant = null;
				try {
					componentCollectionServant = ComponentCollectionHelper
							.narrow(_containerDesc[j].container
									.getFacetByName("componentCollection"));
				} catch (corbaObjects.scs.InvalidName e) {
					JOptionPane.showMessageDialog(DomainExplorer.this, e
							.getMessage()
							+ "\n" + e);
				}

				ComponentHandle[] _componentHandle = new ComponentHandle[10];
				try {
					_componentHandle = componentCollectionServant
							.getComponents();
				} catch (corbaObjects.scs.InvalidName e) {
					JOptionPane.showMessageDialog(DomainExplorer.this, e
							.getMessage()
							+ "\n" + e);
				}

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

	public void updateTreeNodes() {
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
}
