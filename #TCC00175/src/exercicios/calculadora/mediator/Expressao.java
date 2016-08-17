package exercicios.calculadora.mediator;

import exercicios.calculadora.decorator.InterpretadorAritmetico;
import exercicios.calculadora.decorator.InterpretadorBasico;
import exercicios.calculadora.decorator.InterpretadorDeExpressao;
import exercicios.calculadora.decorator.InterpretadorTrigonometrico;
import exercicios.calculadora.interpreter.RepresentacaoExpressao;

public class Expressao extends ClasseMediada implements Cloneable {

    private String expressaoStr;
    public RepresentacaoExpressao expressao;
    private InterpretadorDeExpressao interpretador;

    public Expressao(Mediador mediador) {
        super(mediador);
        interpretador = new InterpretadorTrigonometrico(new InterpretadorAritmetico(new InterpretadorBasico()));
    }

    public void setExpressaoStr(String expressaoStr) throws Exception {
        if (!expressaoStr.trim().equals(this.expressaoStr)) {
            this.expressaoStr = expressaoStr;
            expressao = interpretador.interpretar(this.expressaoStr);
            alterado();
        }
    }

    public String getExpressaoStr() {
        return expressaoStr;
    }

    public Double getResultado() {
        return expressao.calcular();
    }

    @Override
    public void alterado() {
        mediador.objetoAlterado(this);
    }

    public Expressao clone() throws CloneNotSupportedException {
        Expressao expr = (Expressao) super.clone();
        if (expr.expressao != null)
            expr.expressao = expressao.clone();
        return expr;
    }
}
