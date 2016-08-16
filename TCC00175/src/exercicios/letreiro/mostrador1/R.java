package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class R extends Caractere {

    private static R instancia = null;

    private R() {
    }

    public static R obterInstancia() {
        if (instancia == null)
            instancia = new R();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{true, true, true, true, false},
        {true, false, false, false, true},
        {true, true, true, true, false},
        {true, false, false, true, false},
        {true, false, false, false, true}};
        mostrador.acenderLeds(estados);
    }
}
