package exercicios.calculadora;

import exercicios.calculadora.interpreter.Literal;
import exercicios.calculadora.interpreter.Seno;
import exercicios.calculadora.interpreter.Coseno;
import java.util.HashMap;
import java.util.Map;
import org.omg.CORBA.UserException;

public class Teste {

    public static void main(String[] args) throws UserException, CloneNotSupportedException {

        Map<String, String> vars = new HashMap<>();
        String str = "Luiz André";
        vars.put("v1", str);
        Map<String, String> vars2 = new HashMap<>();
        vars2.putAll(vars);

        Seno sen = new Seno(new Literal(2.3));
        Seno sen2 = sen.clone();
        Coseno cos = new Coseno(new Literal(2.3));
        Coseno cos2 = cos;
        System.out.println(cos.operando1.equals(cos2.operando1));

    }
}
