package uff.ic.tcc00328.exercicios.letreiro.model.mostrador1;

import uff.ic.tcc00328.exercicios.letreiro.model.Caractere;

public class U extends Caractere {

    private static U instancia = null;

    private U() {
    }

    public static U obterInstancia() {
        if (instancia == null)
            instancia = new U();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{true, false, false, false, true},
        {true, false, false, false, true},
        {true, false, false, false, true},
        {true, false, false, false, true},
        {false, true, true, true, false}};
        mostrador.acenderLeds(estados);
    }
}
