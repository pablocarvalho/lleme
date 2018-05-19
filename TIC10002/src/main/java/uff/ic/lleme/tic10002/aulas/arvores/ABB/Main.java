package uff.ic.lleme.tic10002.aulas.arvores.ABB;

import uff.ic.lleme.tic10002.aulas.utils.Conteudo;

public class Main {

    public static void main(String[] args) {
        ABB abb = new ABB();

        abb.incluir(new Conteudo(15));
        abb.print();
        abb.incluir(new Conteudo(2));
        abb.print();
        abb.incluir(new Conteudo(53));
        abb.print();
        abb.incluir(new Conteudo(23));
        abb.print();
        abb.incluir(new Conteudo(1));
        abb.print();
        abb.incluir(new Conteudo(74));
        abb.print();
        abb.incluir(new Conteudo(13));
        abb.print();
    }
}
