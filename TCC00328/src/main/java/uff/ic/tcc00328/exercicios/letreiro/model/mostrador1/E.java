package uff.ic.tcc00328.exercicios.letreiro.model.mostrador1;

import uff.ic.tcc00328.exercicios.letreiro.model.Caractere;

public class E extends Caractere {

    private static E instancia = null;

    private E() {
    }

    public static E obterInstancia() {
        if (instancia == null)
            instancia = new E();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{true, true, true, true, true},
        {true, false, false, false, false},
        {true, true, true, true, false},
        {true, false, false, false, false},
        {true, true, true, true, true}};
        mostrador.acenderLeds(estados);
    }
}
