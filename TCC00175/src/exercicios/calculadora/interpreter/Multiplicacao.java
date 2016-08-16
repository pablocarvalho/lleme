package exercicios.calculadora.interpreter;

import exercicios.calculadora.visitor.Visitor;

public class Multiplicacao extends OperacaoBinaria {

    public Multiplicacao(RepresentacaoExpressao operando1, RepresentacaoExpressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return "prod";
    }

    @Override
    public double calcular() {
        return operando1.calcular() * operando2.calcular();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMultiplicacao(this);
        operando1.accept(visitor);
        operando2.accept(visitor);
    }

    public Multiplicacao clone() throws CloneNotSupportedException {
        return (Multiplicacao) super.clone();
    }
}
