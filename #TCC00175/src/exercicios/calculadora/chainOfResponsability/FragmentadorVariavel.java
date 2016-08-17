package exercicios.calculadora.chainOfResponsability;

import java.util.Scanner;
import exercicios.calculadora.interpreter.Variavel;

public class FragmentadorVariavel extends FragmentadorDeExpressao {

    @Override
    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr == null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        if (in.hasNext("_[a-z]+")) {
            getPilha().add(new Variavel(in.next("_[a-z]+")));
            if (in.hasNextLine()) {
                String resto = in.nextLine().trim();
                if (resto.equals(""))
                    return null;
                else
                    return resto;
            } else
                throw new Exception("Número inválido de operandos para a operação de soma") {
                };
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
