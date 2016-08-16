package exercicios.calculadora.interpreter;

import exercicios.calculadora.visitor.Node;

public abstract class RepresentacaoExpressao implements Cloneable, Node {

    @Override
    public RepresentacaoExpressao clone() throws CloneNotSupportedException {
        return (RepresentacaoExpressao) super.clone();
    }

    public abstract void setValor(double valor);

    public abstract String getNome();

    public abstract double calcular();

}
