package uff.ic.tcc00175.exercicios.calculadora.interpreter;

import uff.ic.tcc00175.exercicios.calculadora.visitor.Node;

public abstract class RepresentacaoExpressao implements Cloneable, Node {

    @Override
    public RepresentacaoExpressao clone() throws CloneNotSupportedException {
        return (RepresentacaoExpressao) super.clone();
    }

    public abstract void setValor(double valor);

    public abstract String getNome();

    public abstract double calcular();

}
