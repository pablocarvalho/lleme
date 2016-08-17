package exercicios.calculadora.visitor;

import exercicios.calculadora.interpreter.Coseno;
import exercicios.calculadora.interpreter.Divisao;
import exercicios.calculadora.interpreter.Literal;
import exercicios.calculadora.interpreter.Multiplicacao;
import exercicios.calculadora.interpreter.Seno;
import exercicios.calculadora.interpreter.Soma;
import exercicios.calculadora.interpreter.Subtracao;
import exercicios.calculadora.interpreter.Tangente;
import exercicios.calculadora.interpreter.Variavel;

public abstract class Visitor {

    public abstract void visitLiteral(Literal expr);

    public abstract void visitVariavel(Variavel expr);

    public abstract void visitSoma(Soma expr);

    public abstract void visitSubtracao(Subtracao expr);

    public abstract void visitMultiplicacao(Multiplicacao expr);

    public abstract void visitDivisao(Divisao expr);

    public abstract void visitSeno(Seno expr);

    public abstract void visitCoseno(Coseno expr);

    public abstract void visitTangente(Tangente expr);

}
