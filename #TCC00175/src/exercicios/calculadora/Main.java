package exercicios.calculadora;

import exercicios.calculadora.visitor.InicializarVariavel;
import exercicios.calculadora.visitor.ListarVariaveis;
import exercicios.calculadora.decorator.InterpretadorDeExpressao;
import exercicios.calculadora.decorator.InterpretadorTrigonometrico;
import exercicios.calculadora.decorator.InterpretadorBasico;
import exercicios.calculadora.interpreter.RepresentacaoExpressao;

public class Main {

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
