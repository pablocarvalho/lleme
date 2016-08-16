package exercicios.calculadora.interpreter;

import exercicios.calculadora.visitor.Visitor;

public class Seno extends OperacaoUnaria {

    public Seno(RepresentacaoExpressao operando1) {
        super(operando1);
    }

    @Override
    public void setValor(double valor) {
        // Não faz nada
    }

    @Override
    public String getNome() {
        return "sen";
    }

    @Override
    public double calcular() {
        return Math.sin(operando1.calcular());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSeno(this);
        operando1.accept(visitor);
    }

    public Seno clone() throws CloneNotSupportedException {
        return (Seno) super.clone();
    }
}
