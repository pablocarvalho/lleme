package provas.s20141.p220141;

public class Estado0 extends Estado {

    private static Estado0 instancia = null;

    private Estado0() {
        super(0);
    }

    public static Estado0 obterInstancia() {
        if (instancia == null)
            instancia = new Estado0();
        return instancia;
    }

    @Override
    public String decodificar() {
        return "Mensagem";
    }

}
