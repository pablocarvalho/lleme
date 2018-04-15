package uff.ic.lleme.tcc00175.exercicios.calculadora.chainOfResponsability;

import java.util.Scanner;
import uff.ic.lleme.tcc00175.exercicios.calculadora.interpreter.RepresentacaoExpressao;
import uff.ic.lleme.tcc00175.exercicios.calculadora.interpreter.Multiplicacao;

public class FragmentadorMultiplicacao extends FragmentadorDeExpressao {

    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr == null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        RepresentacaoExpressao op1;
        RepresentacaoExpressao op2;
        if (in.hasNext("\\*")) {
            in.next("\\*");
            if (getPilha().size() >= 2) {
                op2 = getPilha().pop();
                op1 = getPilha().pop();
                getPilha().add(new Multiplicacao(op1, op2));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("N�mero inv�lido de operandos para a opera��o de multiplicacao") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
