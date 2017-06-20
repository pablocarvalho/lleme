package uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda;

import uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda.Intermediaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InvalidObjectException;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class janelaExcluirBuscar {

	private JFrame frame3;
	private JTextField txtDigiteAChave;
	private DefaultListModel listModel;
	private JList list;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					janelaExcluirBuscar window = new janelaExcluirBuscar();
//					window.frame3.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public janelaExcluirBuscar(Intermediaria dados) {
		initialize(dados);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Intermediaria dados) {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 450, 300);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setToolTipText("All right Reserved by Leandro Miranda\n");
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		panel.setBackground(Color.BLUE);

		JDesktopPane desktopPane = new JDesktopPane();
		getFrame3().getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		
		listModel = new DefaultListModel();
		listModel.addElement("filial");
		listModel.addElement("ano_mes");
		listModel.addElement("cod_vendedor");
		list = new JList(listModel);
		list.setBounds(259, 76, 140, 86);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
//		JScrollPane listScroller = new JScrollPane(list);
//		listScroller.setPreferredSize(new Dimension(250, 80));
		desktopPane.add(list);
		
		txtDigiteAChave = new JTextField();
		txtDigiteAChave.setText("Digite a chave");
		txtDigiteAChave.setBounds(111, 104, 134, 28);
		desktopPane.add(txtDigiteAChave);
		txtDigiteAChave.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(111, 174, 117, 29);
		desktopPane.add(btnRemover);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String chave = txtDigiteAChave.getText();
				String tipo = null;
				int index = list.getSelectedIndex();
				switch (index) {
				case 0:
					tipo = "filial"; 
					break;
				case 1:
					tipo = "ano_mes"; 
					break;
				case 2:
					tipo = "cod_vendedor"; 
					break;
				default:
					JOptionPane.showMessageDialog(null,"Deu erro!");
					break;
				}
				try {
					dados.removerDados(chave,tipo);
				} catch (InvalidObjectException e) {
					JOptionPane.showMessageDialog(null,"Deu erro na remocao! Reveja seus dados!");
					e.printStackTrace();
				}
			}});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(231, 174, 117, 29);
		desktopPane.add(btnBuscar);
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String chave = txtDigiteAChave.getText();
				String tipo = null;
				int index = list.getSelectedIndex();
				switch (index) {
				case 0:
					tipo = "filial"; 
					break;
				case 1:
					tipo = "ano_mes"; 
					break;
				case 2:
					tipo = "cod_vendedor"; 
					break;
				default:
					JOptionPane.showMessageDialog(null,"Deu erro!");
					break;
				}
				try {
					dados.buscarDados(chave, tipo);
				} catch (InvalidObjectException e) {
					JOptionPane.showMessageDialog(null,"Deu erro na busca! Reveja seus dados!");
					e.printStackTrace();
				}
			}});

		getFrame3().getContentPane().add(panel, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBackground(Color.BLUE);
		getFrame3().getContentPane().add(panel_1, BorderLayout.NORTH);
		getFrame3().setBounds(100, 100, 503, 330);
		getFrame3().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame3() {
		// TODO Auto-generated method stub
		return frame3;
	}
}
