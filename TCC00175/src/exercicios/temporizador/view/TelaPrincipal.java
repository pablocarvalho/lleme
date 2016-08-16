package exercicios.temporizador.view;

import javax.swing.JFrame;

public class TelaPrincipal extends Tela {

    private static final long serialVersionUID = 8094890868473495605L;
    private static TelaPrincipal instancia = null;
    private FuncaoRelogio funcaoRelogio = null;
    private FuncaoCronometro funcaoCronometro = null;
    private FuncaoRegressivo funcaoRegressivo = null;

    private TelaPrincipal(String nome) {
        super(nome);
        funcaoRelogio = new FuncaoRelogio();
        funcaoCronometro = new FuncaoCronometro();
        funcaoRegressivo = new FuncaoRegressivo();
        initComponents();
    }

    public static TelaPrincipal getInstance() {
        if (TelaPrincipal.instancia == null)
            TelaPrincipal.instancia = new TelaPrincipal("Temporizador");
        return TelaPrincipal.instancia;
    }

    public void initComponents() {
        super.initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(funcaoRelogio);
        getContentPane().add(funcaoCronometro);
        getContentPane().add(funcaoRegressivo);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        pack();
    }
}
