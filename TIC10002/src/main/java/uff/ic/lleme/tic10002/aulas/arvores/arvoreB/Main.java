package uff.ic.lleme.tic10002.aulas.arvores.arvoreB;

import java.util.Random;
import uff.ic.lleme.tic10002.aulas.utils.Empregado;

public class Main {

    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB();
        Random rand = new Random();

        for (int i = 0; i < 10; i++)
            arvore.incluir(new Empregado(rand.nextInt(100)));
        arvore.print();
    }
}
