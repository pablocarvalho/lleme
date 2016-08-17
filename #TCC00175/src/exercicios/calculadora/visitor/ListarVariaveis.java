package exercicios.calculadora.visitor;

import exercicios.calculadora.interpreter.Coseno;
import exercicios.calculadora.interpreter.Divisao;
import exercicios.calculadora.interpreter.Literal;
import exercicios.calculadora.interpreter.Multiplicacao;
import exercicios.calculadora.interpreter.Seno;
import exercicios.calculadora.interpreter.Soma;
import exercicios.calculadora.interpreter.Subtracao;
import exercicios.calculadora.interpreter.Tangente;
import java.util.HashSet;
import java.util.Set;
import exercicios.calculadora.interpreter.Variavel;

public class ListarVariaveis extends Visitor {

    public Set<String> nomesVars = new HashSet<>();

    @Override
    public void visitVariavel(Variavel expr) {
        nomesVars.add(expr.getNome());
    }

    @Override
    public void visitLiteral(Literal expr) {

    }

    @Override
    public void visitSoma(Soma expr) {

    }

    @Override
    public void visitSubtracao(Subtracao expr) {

    }

    @Override
    public void visitMultiplicacao(Multiplicacao expr) {

    }

    @Override
    public void visitDivisao(Divisao expr) {

    }

    @Override
    public void visitSeno(Seno expr) {

    }

    @Override
    public void visitCoseno(Coseno expr) {

    }

    @Override
    public void visitTangente(Tangente expr) {

    }
}
