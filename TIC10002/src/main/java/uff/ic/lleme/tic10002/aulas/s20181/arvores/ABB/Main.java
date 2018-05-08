package uff.ic.lleme.tic10002.aulas.s20181.arvores.ABB;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class Main {

    public static void main(String[] args) {
        ABB abb = new ABB();

        abb.incluir(new Objeto(15));
        abb.print();
        abb.incluir(new Objeto(2));
        abb.print();
        abb.incluir(new Objeto(53));
        abb.print();
        abb.incluir(new Objeto(23));
        abb.print();
        abb.incluir(new Objeto(1));
        abb.print();
        abb.incluir(new Objeto(74));
        abb.print();
        abb.incluir(new Objeto(13));
        abb.print();
    }
}
