package lleme.letstalk;

import lleme.letstalk.scs.client.LetsTalkServant;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import corbaObjects.letstalk.CommFacet;
import corbaObjects.letstalk.CommFacetHelper;
import corbaObjects.letstalk.UserFacet;
import corbaObjects.letstalk.UserFacetHelper;
import corbaObjects.scs.InternalError;
import corbaObjects.scs.InvalidName;

/**
 * @author Luiz Leme
 */
public class Chat extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6125147204760164191L;

	private Container container;

	private Container cc;

	private GridBagLayout gbLayout;

	private GridBagConstraints gbConstraints;

	// ************************************
	// Luiz André - alterei visibilidade 
	//
	// private JTextArea mensRecList, mensEnvList;
	public JTextArea mensRecList;

	// ************************************
	// Luiz André - alterei visibilidade
	//
	// private JTextArea mensRecList, mensEnvList;
	public JTextArea mensEnvList;

	// ************************************
	private JList itemList;

	// ************************************
	private JList copyList;

	// ************************************
	// Luiz André - acrescentei
	//
	public DefaultListModel usuarios = null;

	public DefaultListModel destinatarios = null;

	public DefaultListSelectionModel selModel = null;

	// ************************************
	private JButton btCNok;

	// ************************************
	private JButton btDCok;

	// ************************************
	private JButton btICok;

	// ************************************
	private JButton btSEok;

	// ************************************
	private JButton btEMok;

	// ************************************
	// Luiz André - comentei essa linha
	//
	// private Inscrever inscrever;
	// ************************************
	private String[] destNames = { "  ", " " };

	int iniMens;

	int fimMens;

	boolean inicio;

	// String selUser[],selUser2[];
	public Chat(String chatId, String[] userIds) {
		// ************************************
		// Luiz André - alterei o nome da janela
		// e inclui o chatId
		//
		// super("Lets Talk");
		this.chatId = chatId;
		// ************************************
		container = getContentPane();
		gbLayout = new GridBagLayout();
		container.setLayout(gbLayout);
		// instantiate gridbag constraints
		gbConstraints = new GridBagConstraints();
		iniMens = 1;
		fimMens = 0;
		// ************************************
		// Luiz André - desabilitei os botões de conexão
		//
		// criar botões conectar e disconectar
		// btCNok = criarBotão("Conectar", 0, 0, 3, 1);
		// btCNok.setEnabled(true);
		// btDCok = criarBotão("Desconectar", 1, 0, 3, 1);
		// ************************************
		// lista de destinatarios
		JTextField tfLU = new JTextField("        Lista de Usuários  ");
		tfLU.setBorder(null);
		tfLU.setEditable(false);
		addComponent(tfLU, 2, 0, 3, 1);
		itemList = criarLista(userIds, 3, 0, 3, 3);
		// ************************************
		// Luiz André - alterei modelo da lista
		//
		usuarios = new DefaultListModel();
		selModel = new DefaultListSelectionModel();
		itemList.setModel(usuarios);
		itemList.setSelectionModel(selModel);
		// ************************************
		btICok = criarBotao("iniciar Chat", 7, 0, 3, 1);
		// ************************************
		// Luiz André - alterei nome do botão
		//
		btICok.setText("Incluir userId");
		// ************************************
		// lista de destinatarios
		JTextField tfLD = new JTextField("   Lista de Destinatários");
		tfLD.setBorder(null);
		tfLD.setEditable(false);
		addComponent(tfLD, 8, 0, 3, 1);
		copyList = criarLista(destNames, 9, 0, 3, 3);
		// ************************************
		// Luiz André - alterei modelo da lista
		//
		destinatarios = new DefaultListModel();
		copyList.setModel(destinatarios);
		// ************************************
		// ************************************
		// Luiz André - comentei essas linhas
		//
		// btSEok = criarBotão("Inscrever no Chat", 13, 0, 3, 1);
		// btSEok.setEnabled(true);
		// ************************************
		// **********************lado 2 da tela**************************
		// lista de destinatarios
		JTextField tfMR = new JTextField("        Mensagens Recebidas  ");
		tfMR.setEditable(false);
		tfMR.setBorder(null);
		addComponent(tfMR, 0, 4, 10, 1);
		mensRecList = new JTextArea(8, 40);
		mensRecList.setEditable(false);
		mensRecList.setBackground(Color.lightGray);
		mensRecList.setLineWrap(true);
		JScrollPane jsp3 = new JScrollPane(mensRecList);
		addComponent(jsp3, 1, 4, 10, 7);
		// lista de destinatarios
		JTextField tfME = new JTextField("        Mensagens a Enviar");
		tfME.setEditable(false);
		tfME.setBorder(null);
		addComponent(tfME, 8, 4, 10, 1);
		mensEnvList = new JTextArea(5, 40);
		mensEnvList.setEnabled(false);
		mensEnvList.setLineWrap(true);
		JScrollPane jsp4 = new JScrollPane(mensEnvList);
		addComponent(jsp4, 8, 5, 10, 6);
		btEMok = criarBotao("Enviar mensagem", 13, 5, 1, 1);
		// ************************************
		// Luiz André - habilitei mensagens
		//
		mensEnvList.setEnabled(true);
		// ************************************
		// ==Listeners do botões=========================================
		// ações do botão Enviar mensagem
		btEMok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Luiz André - desabilitei este trecho
				 * 
				 * String s = mensEnvList.getText(); fimMens =
				 * mensEnvList.getCaretPosition(); s = s.substring(iniMens,
				 * fimMens); System.out.println(s); mensEnvList.append("\n>");
				 * iniMens = mensEnvList.getCaretPosition();
				 * mensEnvList.requestFocus();
				 */
				try {
					sendMessage();
				} catch (InvalidName e1) {
					JOptionPane.showMessageDialog(Chat.this, e1.getMessage());
				}
			}
		});
		// ações do botão Conectar

		/*
		 * btCNok.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // se deixar o if fica preenchido
		 * com ultimo campo // if (inscrever == null) // primeira vez //
		 * inscrever = new Inscrever(LetsTalk.this, // "Informar
		 * User/password"); // inscrever.setVisible(true); // mostra janela //
		 * pegar username e password // String user = inscrever.getUserName(); //
		 * String pw = inscrever.getPassword(); btCNok.setEnabled(false);
		 * itemList.setEnabled(true); btICok.setEnabled(true);
		 * btDCok.setEnabled(true); btSEok.setEnabled(false);
		 * mensEnvList.setEnabled(false); btEMok.setEnabled(false); inicio =
		 * true; } });
		 */

		// ações do botão desconectar
		/*
		 * btDCok.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { // inserir ações
		 * btCNok.setEnabled(true); btDCok.setEnabled(false);
		 * copyList.setListData(destNames); itemList.setEnabled(false);
		 * itemList.clearSelection(); btICok.setEnabled(false);
		 * btSEok.setEnabled(true); mensEnvList.setText("");
		 * mensEnvList.setEnabled(false); btEMok.setEnabled(false); } });
		 */

		// ações do botão iniciar Chat
		btICok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// transferir os usuarios selecionados
				// ***********************
				// Luiz André - passei a utilizar um ListModel para
				// manipular os elementos da lista
				// copyList.setListData(itemList.getSelectedValues());
				addSelected();
				// ************************
				/*
				 * if (inicio){ String[] selUser = new String[20]; selUser =
				 * (String[]) itemList.getSelectedValue();
				 * copyList.setListData(selUser); itemList.clearSelection(); }
				 * else { String[] selUser2 = new String[20]; selUser2 =
				 * (String[]) itemList.getSelectedValues(); for(int i = 0;i <
				 * selUser2.length; i++) selUser[selUser.length + i]=
				 * selUser2[i]; copyList.setListData(selUser);
				 * itemList.clearSelection(); }
				 */
				inicio = false;
				mensEnvList.setEnabled(true);
				mensEnvList.setText("");
				mensEnvList.append(">");
				mensEnvList.requestFocus();
				btEMok.setEnabled(true);
			}
		});
		// ações do botão Subescrever

		/*
		 * btSEok.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { copyList.setListData(destNames); //
		 * se deixar o if fica preenchido com ultimo campo // if (inscrever ==
		 * null) // primeira vez // inscrever = new Inscrever(LetsTalk.this,
		 * "Inscrever no // Chat"); // inscrever.setVisible(true); // mostra
		 * janela // pegar username e password // String user =
		 * inscrever.getUserName(); // String pw = inscrever.getPassword(); }
		 * });
		 */

		setSize(700, 350);
		setVisible(true);
	}

	public void addSelected() {
		HashSet lista = new HashSet();
		usuarios.trimToSize();
		boolean achou = false;
		for (int i = 0; i < usuarios.size(); i++) {
			if (selModel.isSelectedIndex(i))
				lista.add(usuarios.getElementAt(i));
		}
		destinatarios.trimToSize();
		for (int i = 0; i < destinatarios.size(); i++) {
			lista.add(destinatarios.getElementAt(i));
		}
		destinatarios.removeAllElements();
		Iterator iter = lista.iterator();
		while (iter.hasNext()) {
			destinatarios.addElement(iter.next());
		}
	}

	// addComponent is programmer defined
	private void addComponent(Component c, int row, int column, int width,
			int height) {
		// set gridx and gridy
		gbConstraints.gridx = column;
		gbConstraints.gridy = row;
		// set gridwidth and gridheight
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		// set constraints
		gbLayout.setConstraints(c, gbConstraints);
		container.add(c); // add component
	}

	private JButton criarBotao(String nome, int lin, int col, int comp, int alt) {
		JButton bt = new JButton(nome);
		bt.setEnabled(false);
		addComponent(bt, lin, col, comp, alt);
		// ************************************
		// Luiz André - habilitei lista
		//
		bt.setEnabled(true);
		// ************************************
		return bt;
	}

	private JList criarLista(String[] nomes, int lin, int col, int comp, int alt) {
		// ***********************************
		// Luiz André - construção da lista sem parâmetros
		// JList li = new JList(nomes);
		JList li = new JList();
		// *******************************
		li.setVisibleRowCount(5);
		li.setFixedCellHeight(15);
		li.setFixedCellWidth(180);
		li.setBackground(Color.lightGray);
		li.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane jsp1 = new JScrollPane(li);
		li.setEnabled(false);
		addComponent(jsp1, lin, col, comp, alt);
		// ************************************
		// Luiz André - habilitei lista
		//
		li.setEnabled(true);
		// ************************************
		return li;
	}

	public String chatId = null;

	public LetsTalkServant component = null;

	private void sendMessage() throws InvalidName {

		CommFacet commFacet = null;
		UserFacet userFacet = null;

		commFacet = CommFacetHelper.narrow(component.getFacet(CommFacet.class
				.getName()));
		userFacet = UserFacetHelper.narrow(component.getFacet(UserFacet.class
				.getName()));

		Object[] lista = destinatarios.toArray();
		String[] _lista = new String[lista.length];
		for (int i = 0; i < lista.length; i++)
			_lista[i] = (String) lista[i];
		try {
			commFacet.sendMessage("", chatId, _lista, mensEnvList.getText());
		} catch (InternalError e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

}
