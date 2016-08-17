package exercicios.calculadora.chainOfResponsability;

import java.util.Scanner;
import exercicios.calculadora.interpreter.Coseno;
import exercicios.calculadora.interpreter.RepresentacaoExpressao;

public class FragmentadorCoseno extends FragmentadorDeExpressao {

    @Override
    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr == null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        RepresentacaoExpressao op1;
        if (in.hasNext("cos")) {
            in.next("cos");
            if (getPilha().size() >= 1) {
                op1 = getPilha().pop();
                getPilha().add(new Coseno(op1));
                if (in.hasNextLine()) {
                    String resto = in.nextLine().trim();
                    if (resto.equals(""))
                        return null;
                    else
                        return resto;
                } else
                    return null;
            } else
                throw new Exception("Número inválido de operandos para a operação coseno") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
