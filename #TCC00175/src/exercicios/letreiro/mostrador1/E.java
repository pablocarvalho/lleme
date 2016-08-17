package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

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
