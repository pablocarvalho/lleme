package exercicios.calculadora.chainOfResponsability;

import java.util.Scanner;
import exercicios.calculadora.interpreter.RepresentacaoExpressao;
import exercicios.calculadora.interpreter.Subtracao;

public class FragmentadorSubtracao extends FragmentadorDeExpressao {

    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr == null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        RepresentacaoExpressao op1;
        RepresentacaoExpressao op2;
        if (in.hasNext("\\-")) {
            in.next("\\-");
            if (getPilha().size() >= 2) {
                op2 = getPilha().pop();
                op1 = getPilha().pop();
                getPilha().add(new Subtracao(op1, op2));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("Número inválido de operandos para a operação de subtracao") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
