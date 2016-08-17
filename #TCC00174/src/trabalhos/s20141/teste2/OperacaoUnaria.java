package trabalhos.s20141.teste2;

public abstract class OperacaoUnaria extends Expressao {

    private Matriz oper1 = null;

    public OperacaoUnaria(Matriz oper1) {
        this.oper1 = oper1;
    }

    public Matriz getOper1() {
        return oper1;
    }

}
