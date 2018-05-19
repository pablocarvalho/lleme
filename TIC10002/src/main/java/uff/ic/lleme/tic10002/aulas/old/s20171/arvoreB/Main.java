package uff.ic.lleme.tic10002.aulas.old.s20171.arvoreB;

import java.util.Random;
import uff.ic.lleme.tic10002.utils.Empregado;

public class Main {

    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB();
        Random rand = new Random();
        int[] nums = {58, 14, 20, 49, 81, 97};

        //for (int i = 0; i < 6; i++)
        //    arvore.incluir(new Empregado(rand.nextInt(100)));
        for (int n : nums)
            arvore.incluir(new Empregado(n));
        arvore.print();
    }
}
