package uff.ic.lleme.tcc00175.exercicios.calculadora.interpreter;

import uff.ic.lleme.tcc00175.exercicios.calculadora.visitor.Visitor;

public class Tangente extends OperacaoUnaria {

    public Tangente(RepresentacaoExpressao operando1) {
        super(operando1);
    }

    @Override
    public void setValor(double valor) {
        // N�o faz nada
    }

    @Override
    public String getNome() {
        return "tan";
    }

    @Override
    public double calcular() {
        return Math.tan(operando1.calcular());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTangente(this);
        operando1.accept(visitor);
    }

    public Tangente clone() throws CloneNotSupportedException {
        return (Tangente) super.clone();
    }
}
