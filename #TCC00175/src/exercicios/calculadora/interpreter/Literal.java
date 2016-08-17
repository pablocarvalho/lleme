package exercicios.calculadora.interpreter;

import exercicios.calculadora.visitor.Visitor;

public class Literal extends RepresentacaoExpressao {

    public double numero;

    public Literal(double numero) {
        this.numero = numero;
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return numero + "";
    }

    @Override
    public double calcular() {
        return numero;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLiteral(this);
    }

    public Literal clone() throws CloneNotSupportedException {
        return (Literal) super.clone();
    }
}
