package exercicios.calculadora.interpreter;

public abstract class OperacaoBinaria extends RepresentacaoExpressao {

    public RepresentacaoExpressao operando1;
    public RepresentacaoExpressao operando2;

    public OperacaoBinaria(RepresentacaoExpressao operando1, RepresentacaoExpressao operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    @Override
    public OperacaoBinaria clone() throws CloneNotSupportedException {
        OperacaoBinaria operacao = (OperacaoBinaria) super.clone();
        if (operando1 != null)
            operacao.operando1 = operando1.clone();
        if (operando2 != null)
            operacao.operando2 = operando2.clone();
        return operacao;
    }
}
