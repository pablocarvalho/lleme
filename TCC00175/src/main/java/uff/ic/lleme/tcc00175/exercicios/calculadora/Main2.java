package uff.ic.lleme.tcc00175.exercicios.calculadora;

import uff.ic.lleme.tcc00175.exercicios.calculadora.decorator.InterpretadorDeExpressao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.decorator.InterpretadorTrigonometrico;
import uff.ic.lleme.tcc00175.exercicios.calculadora.decorator.InterpretadorBasico;
import uff.ic.lleme.tcc00175.exercicios.calculadora.interpreter.RepresentacaoExpressao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.visitor.InicializarVariavel;
import uff.ic.lleme.tcc00175.exercicios.calculadora.visitor.ListarVariaveis;

public class Main2 {

    public static void main(String[] args) throws Exception {

        InterpretadorDeExpressao componente = new InterpretadorBasico();
        InterpretadorDeExpressao decorador = new InterpretadorTrigonometrico(componente);

        RepresentacaoExpressao expr = decorador.interpretar("2 _a * _b + _b *");
        expr.accept(new InicializarVariavel("_a", 5));
        expr.accept(new InicializarVariavel("_b", 3));
        ListarVariaveis v = new ListarVariaveis();
        expr.accept(v);

        System.out.println(expr.calcular());
    }
}
