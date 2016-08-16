package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class Space extends Caractere {

    private static Space instancia = null;

    private Space() {
    }

    public static Space obterInstancia() {
        if (instancia == null)
            instancia = new Space();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador1) {
        boolean[][] estados = {{false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false},
        {false, false, false, false, false}};
        mostrador1.acenderLeds(estados);
    }
}
