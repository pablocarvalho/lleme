package uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino;

/**
 * @author bernardino
 */
public class StringUtils {

    private static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public static StringUtils getInstance() {
        return INSTANCE;
    }

    public String mapeia_mes_ano(String mes_ano) {
        mes_ano = mes_ano.replace(" ", "");

        if (mes_ano == null || mes_ano.equals(""))
            return "";

        String[] arr = mes_ano.split("/");
        if (arr.length > 1) {
            String mes = arr[0].length() > 3 ? arr[0].substring(0, 3) : arr[0];
            String ano = arr[1].length() > 2 ? arr[1].substring(arr[1].length() - 2, arr[1].length()) : arr[1];
            return mapeia_mes(mes, ano);
        }

        return "";
    }

    private String mapeia_mes(String mes, String ano) {
        mes = mes.toLowerCase();

        switch (mes) {
            case "jan":
                return ano + "01";
            case "fev":
                return ano + "02";
            case "mar":
                return ano + "03";
            case "abr":
                return ano + "04";
            case "mai":
                return ano + "05";
            case "jun":
                return ano + "06";
            case "jul":
                return ano + "07";
            case "ago":
                return ano + "08";
            case "set":
                return ano + "09";
            case "out":
                return ano + "10";
            case "nov":
                return ano + "11";
            case "dez":
                return ano + "12";
            default:
                return "";
        }
    }

}
