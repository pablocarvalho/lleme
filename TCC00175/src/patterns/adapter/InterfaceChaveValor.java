package patterns.adapter;

import java.text.ParseException;
import java.util.Map;

public abstract interface InterfaceChaveValor {

    public abstract String reservar(Map<String, String> parametros) throws ParseException;
}
