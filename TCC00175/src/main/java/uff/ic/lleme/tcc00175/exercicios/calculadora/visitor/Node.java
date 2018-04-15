package uff.ic.lleme.tcc00175.exercicios.calculadora.visitor;

public abstract interface Node {

    public abstract void accept(Visitor visitor);
}
