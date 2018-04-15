package uff.ic.lleme.tcc00175.enumeration;

public class MainEnum {

    public static void main(String[] args) {

        TipoQuarto tp = TipoQuarto.values()[2];
        System.out.println(tp + " " + tp.ordinal());
    }
}
