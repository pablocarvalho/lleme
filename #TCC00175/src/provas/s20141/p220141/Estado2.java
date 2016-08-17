package provas.s20141.p220141;

public class Estado2 extends Estado {

    private static Estado2 instancia = null;

    private Estado2() {
        super(2);
    }

    public static Estado2 obterInstancia() {
        if (instancia == null)
            instancia = new Estado2();
        return instancia;
    }

    @Override
    public String decodificar() {
        return "Mensagem";
    }

}
