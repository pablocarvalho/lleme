package exercicios.calculadora;

import exercicios.calculadora.mediator.MediadorDeAlteracao;

public class Main3 {

    public static void main(String[] args) throws Exception {

        MediadorDeAlteracao expr = new MediadorDeAlteracao();
        expr.expressao.setExpressaoStr("2 _a * _b + _b *");
        expr.mapaVariaveis.printVars();
        expr.mapaVariaveis.setVar("_a", 5.0);
        expr.mapaVariaveis.setVar("_b", 3.0);
        System.out.println(expr.expressao.expressao.calcular());
        expr.expressao.setExpressaoStr("2 _a * _b + _b * _c -");
        expr.mapaVariaveis.setVar("_c", 6.0);
        expr.mapaVariaveis.printVars();
        System.out.println(expr.expressao.expressao.calcular());

    }
}
