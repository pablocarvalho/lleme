package uff.ic.tcc00175.exercicios.calculadora.interpreter;

import uff.ic.tcc00175.exercicios.calculadora.visitor.Visitor;

public class Subtracao extends OperacaoBinaria {

    public Subtracao(RepresentacaoExpressao operando1, RepresentacaoExpressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public void setValor(double valor) {
        // N�o faz nada
    }

    @Override
    public String getNome() {
        return "sub";
    }

    @Override
    public double calcular() {
        return operando1.calcular() - operando2.calcular();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSubtracao(this);
        operando1.accept(visitor);
        operando2.accept(visitor);
    }

    public Subtracao clone() throws CloneNotSupportedException {
        return (Subtracao) super.clone();
    }
}
