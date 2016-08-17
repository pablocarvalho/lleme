package provas.s20141.p220141;

public class Estado1 extends Estado {

    private static Estado1 instancia = null;

    private Estado1() {
        super(1);
    }

    public static Estado1 obterInstancia() {
        if (instancia == null)
            instancia = new Estado1();
        return instancia;
    }

    @Override
    public String decodificar() {
        return "decodificada";
    }
}
