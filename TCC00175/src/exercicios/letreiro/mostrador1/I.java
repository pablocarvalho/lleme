package exercicios.letreiro.mostrador1;

import exercicios.letreiro.Caractere;

public class I extends Caractere {

    private static I instancia = null;

    private I() {
    }

    public static I obterInstancia() {
        if (instancia == null)
            instancia = new I();
        return instancia;
    }

    @Override
    public void acenderMostrador(Mostrador mostrador) {
        boolean[][] estados = {{false, false, true, false, false},
        {false, false, true, false, false},
        {false, false, true, false, false},
        {false, false, true, false, false},
        {false, false, true, false, false}};
        mostrador.acenderLeds(estados);
    }
}
