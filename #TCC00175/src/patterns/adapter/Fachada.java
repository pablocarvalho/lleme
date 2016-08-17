package patterns.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Fachada implements InterfaceChaveValor {

    Operacoes op;

    public String reservar(Map<String, String> parametros) throws ParseException {

        String tipoQuarto = parametros.get("tipoQuarto");
        String inicioStr = parametros.get("inicio");
        String fimStr = parametros.get("fim");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return op.reservar(tipoQuarto, sdf.parse(inicioStr), sdf.parse(fimStr));
    }
}
