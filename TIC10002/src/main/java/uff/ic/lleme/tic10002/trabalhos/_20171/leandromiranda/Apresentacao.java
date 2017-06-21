package uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InvalidObjectException;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Apresentacao {

    private JFrame frame;
    private JTextField txtMinimo;
    private JTextField txtMaximo;
    private JTextField txtTamanhoNumeroObjetos;
    private JTextField txtResultado;
    public static final int TAMANHO_DE_VENDAS = 10;
    private Intermediaria main;
    boolean booleanButtonAtivadoCodVendedor = false;
    boolean booleanButtonAtivadoAnoMes = false;
    private String maximoCodVendedor;
    private String minimoCodVendedor;
    private int resultadoSomaFinal;
    private ListaDinamicaDeVenda listaLetraA;
    private ListaDinamicaDeVenda listaLetraC;
    private JButton buttonCodVendedor;
    private JButton buttonMesAno;

    private String inicioMes;
    private String inicioAno;
    private String fimMes;
    private String fimANo;

    private JSpinner mesInicial_spinner;
    private JSpinner mesFinal_spinner;
    private JSpinner anoInicial_spinner;
    private JSpinner anoFinal_spinner;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Apresentacao window = new Apresentacao();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Apresentacao() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setForeground(Color.WHITE);
        panel.setToolTipText("All right Reserved by Leandro Miranda\n");
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBackground(Color.BLUE);

        JDesktopPane desktopPane = new JDesktopPane();
        frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

        JTextPane txtpnAnoms = new JTextPane();
        txtpnAnoms.setEditable(false);
        txtpnAnoms.setText("Mes/Ano (Inicio)");
        txtpnAnoms.setBackground(Color.PINK);
        txtpnAnoms.setBounds(176, 126, 117, 16);
        desktopPane.add(txtpnAnoms);

        SpinnerNumberModel spinnetNumber = new SpinnerNumberModel(1, 1, 12, 1);
        mesInicial_spinner = new JSpinner(spinnetNumber);
        desktopPane.setLayer(mesInicial_spinner, 0);
        mesInicial_spinner.setBounds(177, 154, 50, 28);
        desktopPane.add(mesInicial_spinner);

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 1900; i < 2018; i++)
            listModel.addElement("caramba");
        JList list = new JList(listModel);

        list.setBackground(Color.GREEN);
        list.setBounds(176, 166, 137, -24);
        desktopPane.add(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        list.setVisible(true);

        SpinnerNumberModel spinnetNumber_2 = new SpinnerNumberModel(1, 1, 12, 1);
        mesFinal_spinner = new JSpinner(spinnetNumber_2);
        desktopPane.setLayer(mesFinal_spinner, 0);
        mesFinal_spinner.setBounds(309, 154, 50, 28);
        desktopPane.add(mesFinal_spinner);

        JTextPane txtpnMsanofim = new JTextPane();
        txtpnMsanofim.setEditable(false);
        txtpnMsanofim.setText("   Mes/Ano (fim)");
        txtpnMsanofim.setBackground(Color.PINK);
        txtpnMsanofim.setBounds(309, 126, 128, 16);
        desktopPane.add(txtpnMsanofim);

        JButton btnNewButton = new JButton("Gerar Dataset");
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    main = new Intermediaria();
                    String valor = txtTamanhoNumeroObjetos.getText();
                    int valorInteiro = Integer.parseInt(valor);
                    try {
                        main.carregarDadosNasEDs(valorInteiro);
                    } catch (InvalidObjectException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    buttonCodVendedor.setText("Ativar Campo");
                    buttonMesAno.setText("Ativar Campo");

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Digite o valor em inteiros positivos");
                }

            }
        });

        btnNewButton.setBounds(227, 13, 117, 29);
        desktopPane.add(btnNewButton);

        txtTamanhoNumeroObjetos = new JTextField();
        txtTamanhoNumeroObjetos.setBackground(Color.YELLOW);
        txtTamanhoNumeroObjetos.setText("N\u00BA obj");
        txtTamanhoNumeroObjetos.setHorizontalAlignment(SwingConstants.CENTER);
        txtTamanhoNumeroObjetos.setColumns(10);
        txtTamanhoNumeroObjetos.setBounds(164, 11, 63, 31);
        desktopPane.add(txtTamanhoNumeroObjetos);

        /**
         * CRIA CAMPO DE TEXTO RELACIONADO AO VENDEDOR *
         */
        /*Cria o campo de texto para entrade de dados*/
        txtMinimo = new JTextField();
        txtMinimo.setBackground(Color.YELLOW);
        txtMinimo.setHorizontalAlignment(SwingConstants.CENTER);
        txtMinimo.setText("Minimo");
        txtMinimo.setBounds(186, 72, 87, 31);
        desktopPane.add(txtMinimo);
        txtMinimo.setColumns(10);

        txtMaximo = new JTextField();
        txtMaximo.setBackground(Color.YELLOW);
        txtMaximo.setHorizontalAlignment(SwingConstants.CENTER);
        txtMaximo.setText("Maximo");
        txtMaximo.setColumns(10);
        txtMaximo.setBounds(272, 72, 87, 31);
        desktopPane.add(txtMaximo);

        buttonCodVendedor = new JButton("Ativar Campo");
        buttonCodVendedor.setBackground(Color.LIGHT_GRAY);
        buttonCodVendedor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                if (booleanButtonAtivadoCodVendedor) {
                    booleanButtonAtivadoCodVendedor = false;
                    buttonCodVendedor.setText("desativado");
                } else {
                    booleanButtonAtivadoCodVendedor = true;
                    buttonCodVendedor.setText("ativado");
//					resultadoSomaFinal = main.resolverLetraA(listaLetraA);
                }

                if (booleanButtonAtivadoCodVendedor) {
                    maximoCodVendedor = txtMaximo.getText();
                    minimoCodVendedor = txtMinimo.getText();
                } else {
                    maximoCodVendedor = "0";
                    minimoCodVendedor = "0";
                }

            }
        });
        buttonCodVendedor.setBounds(67, 74, 117, 29);
        desktopPane.add(buttonCodVendedor);

        buttonMesAno = new JButton("Ativar Campo");
        buttonMesAno.setBackground(Color.LIGHT_GRAY);
        buttonMesAno.setBounds(57, 155, 117, 29);
        desktopPane.add(buttonMesAno);
        buttonMesAno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (booleanButtonAtivadoAnoMes) {
                    booleanButtonAtivadoAnoMes = false;
                    buttonMesAno.setText("desativado");
                } else {
                    booleanButtonAtivadoAnoMes = true;
                    buttonMesAno.setText("ativado");
                }

                if (booleanButtonAtivadoAnoMes) {
                    inicioMes = mesInicial_spinner.getValue().toString();
                    inicioAno = anoInicial_spinner.getValue().toString();
                    fimMes = mesFinal_spinner.getValue().toString();
                    fimANo = anoFinal_spinner.getValue().toString();
                } else {
                    inicioMes = "1";
                    fimMes = "12";
                    inicioAno = "1900";
                    fimANo = "2100";
                }

            }
        });

        JTextPane txtpnCdigoDoVendedor = new JTextPane();
        txtpnCdigoDoVendedor.setText("     C\u00F3digo do Vendedor");
        txtpnCdigoDoVendedor.setEditable(false);
        txtpnCdigoDoVendedor.setBackground(Color.PINK);
        txtpnCdigoDoVendedor.setBounds(190, 50, 161, 16);
        desktopPane.add(txtpnCdigoDoVendedor);

        SpinnerNumberModel spinnetNumber_3 = new SpinnerNumberModel((int) 1900, (int) 1900, (int) 2100, (int) 1);
        anoInicial_spinner = new JSpinner(spinnetNumber_3);
        anoInicial_spinner.setBounds(224, 154, 69, 28);
        JSpinner.NumberEditor ne_spinner = new JSpinner.NumberEditor(anoInicial_spinner, "0");
        ne_spinner.getFormat().setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        anoInicial_spinner.setEditor(ne_spinner);
        desktopPane.add(anoInicial_spinner);

        SpinnerNumberModel spinnetNumber_4 = new SpinnerNumberModel(1900, 1900, 2100, 1);
        anoFinal_spinner = new JSpinner(spinnetNumber_4);
        anoFinal_spinner.setBounds(362, 154, 82, 28);
        JSpinner.NumberEditor ne_spinner2 = new JSpinner.NumberEditor(anoFinal_spinner, "0");
        ne_spinner2.getFormat().setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        anoFinal_spinner.setEditor(ne_spinner2);
        desktopPane.add(anoFinal_spinner);

        txtResultado = new JTextField();
        txtResultado.setText("Resultado");
        txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
        txtResultado.setColumns(10);
        txtResultado.setBackground(Color.CYAN);
        txtResultado.setBounds(265, 206, 87, 31);
        desktopPane.add(txtResultado);

        JButton btnCalcularTotalVendas = new JButton("Calcular total vendas");
        btnCalcularTotalVendas.setBounds(77, 207, 176, 29);
        desktopPane.add(btnCalcularTotalVendas);
        btnCalcularTotalVendas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                listaLetraA = new ListaDinamicaDeVenda();
                listaLetraC = new ListaDinamicaDeVenda();
                if (booleanButtonAtivadoCodVendedor && !booleanButtonAtivadoAnoMes) {

                    resultadoSomaFinal = main.resolverLetraA(listaLetraA, Integer.parseInt(minimoCodVendedor), Integer.parseInt(maximoCodVendedor));
                    txtResultado.setText(Integer.toString(resultadoSomaFinal));
                } else if (!booleanButtonAtivadoCodVendedor && booleanButtonAtivadoAnoMes) {

                    try {
                        resultadoSomaFinal = main.resolverLetraC(listaLetraC, inicioMes + "/" + inicioAno, fimMes + "/" + fimANo);
                    } catch (InvalidObjectException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    txtResultado.setText(Integer.toString(resultadoSomaFinal));
                } else if (booleanButtonAtivadoAnoMes && booleanButtonAtivadoCodVendedor) {
                    main.resolverLetraA(listaLetraA, Integer.parseInt(minimoCodVendedor), Integer.parseInt(maximoCodVendedor));
                    try {
                        main.resolverLetraC(listaLetraC, inicioMes + "/" + inicioAno, fimMes + "/" + fimANo);
                    } catch (InvalidObjectException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    resultadoSomaFinal = main.resolverLetraB(listaLetraA, listaLetraC);
                    txtResultado.setText(Integer.toString(resultadoSomaFinal));

                } else
                    JOptionPane.showMessageDialog(null, "Nao tem nenhum campo disponível");
            }
        });

        JPanel panel_2 = new JPanel();
        panel_2.setToolTipText("All right Reserved by Leandro Miranda\n");
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_2.setBackground(Color.ORANGE);
        panel_2.setBounds(23, 194, 450, 14);
        desktopPane.add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setToolTipText("All right Reserved by Leandro Miranda\n");
        panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_3.setBackground(Color.ORANGE);
        panel_3.setBounds(6, 103, 450, 14);
        desktopPane.add(panel_3);

        JButton btnInserirDados = new JButton("Inserir Dados");
        btnInserirDados.setBounds(366, 13, 137, 29);
        btnInserirDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            JanelaInserirDados window = new JanelaInserirDados(main);
                            window.getFrame2().setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
        desktopPane.add(btnInserirDados);

        JButton btnRemoverDados = new JButton("Rem/Bus Dados");
        btnRemoverDados.setBounds(366, 39, 137, 29);
        desktopPane.add(btnRemoverDados);
        btnRemoverDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            janelaExcluirBuscar window = new janelaExcluirBuscar(main);
                            window.getFrame3().setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

        JButton btnVerDataset = new JButton("Ver Dataset");
        btnVerDataset.setBounds(23, 11, 117, 29);
        desktopPane.add(btnVerDataset);
        btnVerDataset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String alo = main.getSells().printString();
                System.out.println("=========INFORMACAO SOBRE A ARVORE DE COD_VENDEDOR GERADAS ==============");
                ImpressaoEmArvores.imprimirNo(main.getArvoreCodVendedorLista().getRaiz());
                System.out.println("================================");
                System.out.println("================================");
                System.out.println("=========INFORMACAO SOBRE A ARVORE DE FILIAIS GERADAS ==============");
                ImpressaoEmArvores.imprimirNo(main.getArvoreFilialLista().getRaiz());
                System.out.println("================================");

                JOptionPane.showMessageDialog(null, alo);
            }
        });

        frame.getContentPane().add(panel, BorderLayout.SOUTH);

        JPanel panel_1 = new JPanel();
        panel_1.setToolTipText("");
        panel_1.setBackground(Color.BLUE);
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        frame.setBounds(100, 100, 503, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
