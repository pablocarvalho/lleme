package uff.ic.lleme.tcc00175.exercicios.calculadora.interpreter;

import uff.ic.lleme.tcc00175.exercicios.calculadora.visitor.Visitor;

public class Soma extends OperacaoBinaria {

    public Soma(RepresentacaoExpressao operando1, RepresentacaoExpressao operando2) {
        super(operando1, operando2);
    }

    @Override
    public void setValor(double valor) {
        // N�o faz nada
    }

    @Override
    public String getNome() {
        return "som";
    }

    @Override
    public double calcular() {
        return operando1.calcular() + operando2.calcular();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSoma(this);
        operando1.accept(visitor);
        operando2.accept(visitor);
    }

    public Soma clone() throws CloneNotSupportedException {
        return (Soma) super.clone();
    }
}
