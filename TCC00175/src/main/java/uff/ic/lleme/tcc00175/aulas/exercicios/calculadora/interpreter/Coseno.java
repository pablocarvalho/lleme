package uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter;

import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.visitor.Visitor;

public class Coseno extends OperacaoUnaria {

    public Coseno(RepresentacaoExpressao operando1) {
        super(operando1);
    }

    @Override
    public void setValor(double valor) {
        // N�o faz nada
    }

    @Override
    public String getNome() {
        return "cos";
    }

    @Override
    public double calcular() {
        return Math.cos(operando1.calcular());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCoseno(this);
        operando1.accept(visitor);
    }

    public Coseno clone() throws CloneNotSupportedException {
        return (Coseno) super.clone();
    }
}
