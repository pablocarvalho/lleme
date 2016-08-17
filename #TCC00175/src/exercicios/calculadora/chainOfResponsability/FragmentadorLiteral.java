package exercicios.calculadora.chainOfResponsability;

import java.util.Scanner;
import exercicios.calculadora.interpreter.Literal;

public class FragmentadorLiteral extends FragmentadorDeExpressao {

    public String extrairSimbolo(String expressaoStr) throws Exception {
        if (expressaoStr == null)
            return null;
        Scanner in = new Scanner(expressaoStr.trim());
        if (in.hasNextFloat()) {
            getPilha().add(new Literal(in.nextFloat()));
            if (in.hasNextLine()) {
                String resto = in.nextLine().trim();
                if (resto.equals(""))
                    return null;
                else
                    return resto;
            } else
                return null;
        } else if (proximo != null)
            return proximo.extrairSimbolo(expressaoStr);
        else
            return expressaoStr;
    }
}
