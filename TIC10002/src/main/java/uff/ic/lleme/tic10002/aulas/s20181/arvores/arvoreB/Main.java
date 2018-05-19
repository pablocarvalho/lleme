package uff.ic.lleme.tic10002.aulas.s20181.arvores.arvoreB;

import java.util.Random;
import uff.ic.lleme.tic10002.utils.Empregado;

public class Main {

    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB();
        Random rand = new Random();

        for (int i = 0; i < 200; i++)
            arvore.incluir(new Empregado(rand.nextInt(1000)));
        arvore.print();
    }
}
