package uff.ic.tcc00175.exercicios.calculadora.chainOfResponsability;

import java.util.Scanner;
import uff.ic.tcc00175.exercicios.calculadora.interpreter.RepresentacaoExpressao;
import uff.ic.tcc00175.exercicios.calculadora.interpreter.Soma;

public class FragmentadorSoma extends FragmentadorDeExpressao {

    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr == null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        RepresentacaoExpressao op1;
        RepresentacaoExpressao op2;
        if (in.hasNext("\\+")) {
            in.next("\\+");
            if (getPilha().size() >= 2) {
                op2 = getPilha().pop();
                op1 = getPilha().pop();
                getPilha().add(new Soma(op1, op2));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("N�mero inv�lido de operandos para a opera��o de soma") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
