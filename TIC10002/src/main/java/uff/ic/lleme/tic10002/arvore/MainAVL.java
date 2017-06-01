package uff.ic.lleme.tic10002.arvore;

import java.util.Random;
import uff.ic.lleme.tic10002.Empregado;

public class MainAVL {

    public static void main(String[] args) {
        {
            ArvoreAVL av = new ArvoreAVL(false);
            for (int i = 0; i < 100; i++)
                av.inserir(new Empregado((new Random()).nextInt(1000000)));

            System.out.println("===========================");
            System.out.println("altura = " + av.altura());
            System.out.println("maxSaldo = " + av.maxSaldo());
            System.out.println("===========================");
            System.out.println("");
        }

        {
            for (int n = 20; n < 100; n++) {
                ArvoreAVL av = new ArvoreAVL(true);
                for (int i = 0; i < n; i++)
                    av.inserir(new Empregado((new Random()).nextInt(1000000)));

                System.out.println("|Elementos| = " + n);
                System.out.println("altura = " + av.altura());
                System.out.println("maxSaldo = " + av.maxSaldo());
                System.out.println("");
            }
        }

    }
}
