package exercicios.temporizador.view;

public class FuncaoRegressivo extends Funcao {

    private static final long serialVersionUID = 1L;

    public FuncaoRegressivo() {
        super("Temporizador");
        setMostrador(new MostradorRegressivo(200));
        setBotoeira(new Botoeira(getMostrador().getTemporizador()));
        initComponents();
    }

    private void initComponents() {
        add(getMostrador());
        add(getBotoeira());
    }
}
