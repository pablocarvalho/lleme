package uff.ic.lleme.tic10002.aulas.s20181.arvores.ABB;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class Main {

    public static void main(String[] args) {
        ABB abb = new ABB();

        abb.incluir(new Objeto(15));
        abb.printTree();
        abb.incluir(new Objeto(02));
        abb.printTree();
        abb.incluir(new Objeto(53));
        abb.printTree();
        abb.incluir(new Objeto(23));
        abb.printTree();
        abb.incluir(new Objeto(01));
        abb.printTree();
    }
}
