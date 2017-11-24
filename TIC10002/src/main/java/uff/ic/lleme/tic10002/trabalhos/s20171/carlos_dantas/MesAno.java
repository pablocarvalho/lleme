package uff.ic.lleme.tic10002.trabalhos.s20171.carlos_dantas;

/**
 *
 * @author Carlos
 */
public class MesAno implements Comparable<MesAno> {

    private String mesAno;
    private int mes;
    private int ano;
    private boolean valido;

    public MesAno(String str) {
        mesAno = str;
        int index = mesAno.indexOf("/");

        mes = getMes(str.substring(0, index));
        ano = Integer.parseInt(mesAno.substring(index + 1));
        valido = true;
    }

    public MesAno() {
        valido = false;
    }

    public boolean eValido() {
        return valido;
    }

    private int getMes(String str) {
        str = str.toLowerCase();
        switch (str) {
            case "jan":
                return 1;
            case "fev":
                return 2;
            case "mar":
                return 3;
            case "abr":
                return 4;
            case "mai":
                return 5;
            case "jun":
                return 6;
            case "jul":
                return 7;
            case "ago":
                return 8;
            case "set":
                return 9;
            case "out":
                return 10;
            case "nov":
                return 11;
            case "dez":
                return 12;
        }
        return -1;
    }

    public int mes() {
        return mes;
    }

    public int ano() {
        return ano;
    }

    @Override
    public int compareTo(MesAno o) {
        if (ano > o.ano())
            return 1;
        else if (ano < o.ano())
            return -1;
        else if (mes < o.mes)
            return -1;
        else if (mes > o.mes())
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return mesAno;
    }

    public void incremento() {
        mes++;
        if (mes > 12) {
            mes = 1;
            ano++;
        }
    }

}
