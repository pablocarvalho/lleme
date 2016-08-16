package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class D extends Caractere {

    private static D instancia = null;

    private D() {
    }

    public static D obterInstancia() {
        if (instancia == null)
            instancia = new D();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{true, true, true, true, false},
        {true, false, false, false, true},
        {true, false, false, false, true},
        {true, false, false, false, true},
        {true, true, true, true, false}};
        mostrador.acenderLeds(estados);
    }
}
