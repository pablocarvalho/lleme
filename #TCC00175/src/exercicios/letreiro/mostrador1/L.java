package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class L extends Caractere {

    private static L instancia = null;

    private L() {
    }

    public static L obterInstancia() {
        if (instancia == null)
            instancia = new L();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{true, false, false, false, false},
        {true, false, false, false, false},
        {true, false, false, false, false},
        {true, false, false, false, false},
        {true, true, true, true, true}};
        mostrador.acenderLeds(estados);
    }
}
