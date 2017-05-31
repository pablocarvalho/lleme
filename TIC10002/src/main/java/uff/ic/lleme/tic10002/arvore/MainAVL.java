package uff.ic.lleme.tic10002.arvore;

import java.util.Random;
import uff.ic.lleme.tic10002.Empregado;

public class MainAVL {

    public static void main(String[] args) {
        {
            ArvoreAVL av = new ArvoreAVL(false);
            for (int i = 0; i < 20; i++)
                av.inserir(new Empregado((new Random()).nextInt(1000000)));

            System.out.println("altura = " + av.altura());
            System.out.println("maxSaldo = " + av.maxSaldo());
            System.out.println("");
        }

        {
            for (int k = 20; k < 100; k++) {
                ArvoreAVL av = new ArvoreAVL(true);
                for (int i = 0; i < k; i++)
                    av.inserir(new Empregado((new Random()).nextInt(1000000)));

                System.out.println("altura = " + av.altura());
                System.out.println("maxSaldo = " + av.maxSaldo());
                System.out.println("");
                av = null;
                System.gc();
            }
        }

    }
}
