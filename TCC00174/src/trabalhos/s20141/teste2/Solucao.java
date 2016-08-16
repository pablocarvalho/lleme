package trabalhos.s20141.teste2;

public class Solucao extends OperacaoUnaria {

    public Solucao(Matriz oper1) {
        super(oper1);
        if (getOper1() == null || getOper1().linhas() != getOper1().colunas() - 1)
            throw new IllegalArgumentException();
    }

    @Override
    public Matriz calcular() {
        Matriz resultado = null;
        // implementacao da solucao do sistema linear
        return resultado;
    }

}
