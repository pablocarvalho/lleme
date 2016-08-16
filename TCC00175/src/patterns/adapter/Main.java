package patterns.adapter;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ParseException {

        InterfaceChaveValor is = new Fachada();
        Map<String, String> param = new HashMap<String, String>();
        param.put("tipoQuarto", "duplo");
        param.put("inicio", "02/10/2011");
        param.put("fim", "08/10/2011");
        System.out.println(is.reservar(param));

    }
}
