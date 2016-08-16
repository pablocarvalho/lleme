package trabalhos.s20141.teste2;

public class Determinante extends OperacaoUnaria {

    public Determinante(Matriz oper1) {
        super(oper1);
        if (getOper1() == null || getOper1().linhas() != getOper1().colunas())
            throw new IllegalArgumentException();
    }

    @Override
    public Escalar calcular() {
        Escalar resultado = null;
        // implementacao do cálculo do determinante
        return resultado;
    }

}
