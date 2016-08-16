package trabalhos.s20141.teste2;

public abstract class OperacaoBinaria extends Expressao {

    private Matriz oper1 = null;
    private Matriz oper2 = null;

    public OperacaoBinaria(Matriz oper1, Matriz oper2) {
        this.oper1 = oper1;
        this.oper2 = oper2;
    }

    public Matriz getOper1() {
        return oper1;
    }

    public Matriz getOper2() {
        return oper2;
    }

}
