package uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.visitor;

import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Coseno;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Divisao;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Literal;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Multiplicacao;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Seno;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Soma;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Subtracao;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Tangente;
import uff.ic.lleme.tcc00175.aulas.exercicios.calculadora.interpreter.Variavel;

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
