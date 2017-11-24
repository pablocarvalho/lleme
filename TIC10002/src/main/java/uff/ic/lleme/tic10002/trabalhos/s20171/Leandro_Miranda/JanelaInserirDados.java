package uff.ic.lleme.tic10002.trabalhos.s20171.Leandro_Miranda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InvalidObjectException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class JanelaInserirDados {

    private JFrame frame2;
    public static final int TAMANHO_DE_VENDAS = 10;
//	private IFacade main;
    boolean booleanButtonAtivadoCodVendedor = false;
    boolean booleanButtonAtivadoAnoMes = false;

    private JTable table;
    private JTextField filialtextField;
    private JTextField anoMestextField_1;
    private JTextField codVendedortextField_2;
    private JTextField totalVendidotextField_3;
    private JTextField txtCdigoVendedor;
    private JTextField txtAnomes;
    private JTextField txtCodvendedor;
    private JTextField txtTotalvendido;
    private JButton btnInserir;

    /**
     * Launch the application.
     *
     * @wbp.parser.entryPoint
     */
    // public static void main(String[] args) {
    // EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // try {
    // // JanelaInserirDados window = new JanelaInserirDados();
    // // window.frame.setVisible(true);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    // });
    // }
    /**
     * Create the application.
     */
    public JanelaInserirDados(Intermediaria dados) {
        initialize(dados);
    }

    /**
     * Initialize the contents of the frame.
     *
     * @param dados
     */
    public void initialize(final Intermediaria dados) {
        setFrame2(new JFrame());
        getFrame2().getContentPane().setBackground(Color.CYAN);
        getFrame2().setResizable(false);

        JPanel panel = new JPanel();
        panel.setForeground(Color.WHITE);
        panel.setToolTipText("All right Reserved by Leandro Miranda\n");
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
                null));
        panel.setBackground(Color.BLUE);

        JDesktopPane desktopPane = new JDesktopPane();
        getFrame2().getContentPane().add(desktopPane, BorderLayout.CENTER);

        table = new JTable();
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);
        table.setBounds(232, 208, 49, -135);
        desktopPane.add(table);

        filialtextField = new JTextField();
        filialtextField.setBounds(187, 45, 134, 28);
        desktopPane.add(filialtextField);
        filialtextField.setColumns(10);

        anoMestextField_1 = new JTextField();
        anoMestextField_1.setBounds(187, 75, 134, 28);
        desktopPane.add(anoMestextField_1);
        anoMestextField_1.setColumns(10);

        codVendedortextField_2 = new JTextField();
        codVendedortextField_2.setBounds(187, 105, 134, 28);
        desktopPane.add(codVendedortextField_2);
        codVendedortextField_2.setColumns(10);

        totalVendidotextField_3 = new JTextField();
        totalVendidotextField_3.setBounds(187, 135, 134, 28);
        desktopPane.add(totalVendidotextField_3);
        totalVendidotextField_3.setColumns(10);

        txtCdigoVendedor = new JTextField();
        txtCdigoVendedor.setEditable(false);
        txtCdigoVendedor.setText("Filial:");
        txtCdigoVendedor.setBackground(Color.GREEN);
        txtCdigoVendedor.setColumns(10);
        txtCdigoVendedor.setBounds(50, 45, 134, 28);
        desktopPane.add(txtCdigoVendedor);

        txtAnomes = new JTextField();
        txtAnomes.setEditable(false);
        txtAnomes.setText("Ano_mes:");
        txtAnomes.setColumns(10);
        txtAnomes.setBackground(Color.GREEN);
        txtAnomes.setBounds(50, 75, 134, 28);
        desktopPane.add(txtAnomes);

        txtCodvendedor = new JTextField();
        txtCodvendedor.setEditable(false);
        txtCodvendedor.setText("Cod_vendedor:");
        txtCodvendedor.setColumns(10);
        txtCodvendedor.setBackground(Color.GREEN);
        txtCodvendedor.setBounds(50, 105, 134, 28);
        desktopPane.add(txtCodvendedor);

        txtTotalvendido = new JTextField();
        txtTotalvendido.setEditable(false);
        txtTotalvendido.setText("Total_vendido:\n");
        txtTotalvendido.setColumns(10);
        txtTotalvendido.setBackground(Color.GREEN);
        txtTotalvendido.setBounds(50, 135, 134, 28);
        desktopPane.add(txtTotalvendido);

        btnInserir = new JButton("Inserir");
        btnInserir.setBounds(197, 175, 117, 29);
        desktopPane.add(btnInserir);

        btnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String filialString = filialtextField.getText();
                    String anoMesString = anoMestextField_1.getText();
                    String codvendedorString = codVendedortextField_2.getText();
                    String totalVendidoString = totalVendidotextField_3.getText();
                    Venda newVenda = null;
                    try {
                        Integer.parseInt(filialString);
                        Integer.parseInt(totalVendidoString);
                        newVenda = new Venda(filialString, anoMesString, codvendedorString, totalVendidoString);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha erro nas entradas");
                    }

                    try {
                        dados.incluirDados(newVenda);
                        JOptionPane.showMessageDialog(null, "Dados Inseridos");
                    } catch (InvalidObjectException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "A entrada está incorreta");
                }

            }
        });

        getFrame2().getContentPane().add(panel, BorderLayout.SOUTH);

        JPanel panel_1 = new JPanel();
        panel_1.setToolTipText("");
        panel_1.setBackground(Color.BLUE);
        getFrame2().getContentPane().add(panel_1, BorderLayout.NORTH);
        getFrame2().setBounds(100, 100, 503, 330);
        getFrame2().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame2() {
        return frame2;
    }

    public void setFrame2(JFrame frame2) {
        this.frame2 = frame2;
    }
}
