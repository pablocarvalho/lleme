package uff.ic.tcc00174.trabalhos.s20141.teste2;

public class Determinante extends OperacaoUnaria {

    public Determinante(Matriz oper1) {
        super(oper1);
        if (getOper1() == null || getOper1().linhas() != getOper1().colunas())
            throw new IllegalArgumentException();
    }

    @Override
    public Escalar calcular() {
        Escalar resultado = null;
        // implementacao do c�lculo do determinante
        return resultado;
    }

}
