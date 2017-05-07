package uff.ic.tcc00328.exercicios.letreiro.model.mostrador1;

import uff.ic.tcc00328.exercicios.letreiro.model.Caractere;

public class N extends Caractere {

    private static N instancia = null;

    private N() {
    }

    public static N obterInstancia() {
        if (instancia == null)
            instancia = new N();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{true, false, false, false, true},
        {true, true, false, false, true},
        {true, false, true, false, true},
        {true, false, false, true, true},
        {true, false, false, false, true}};
        mostrador.acenderLeds(estados);
    }
}
