package uff.ic.lleme.tic10002.arvore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import uff.ic.lleme.tic10002.Empregado;

public class MainAVLLuan1 {

    public static void main(String[] args) {
        while (true) {
            List<Integer> c = new ArrayList<>();
            for (int i = 0; i < 15; i++)
                c.add((new Random()).nextInt(1000000));
            Integer[] chaves = c.toArray(new Integer[0]);

            ArvoreAVLErrada av1 = new ArvoreAVLErrada(true);
            for (int chave : chaves)
                av1.inserir(new Empregado(chave));

            ArvoreAVLLuan av2 = new ArvoreAVLLuan(true);
            for (int chave : chaves)
                av2.inserir(new Empregado(chave));

            ArvoreAVLCorrigida av3 = new ArvoreAVLCorrigida(true);
            for (int chave : chaves)
                av3.inserir(new Empregado(chave));

            if (av1.maxSaldo() > 1 && av2.maxSaldo() > 1) {
                System.out.println("****************************************************************");
                System.out.println("Input: " + c.toString());
                System.out.println("");

                System.out.println(">>> Com codigo que estava errado.");
                System.out.println("altura = " + av1.altura());
                System.out.println("maxSaldo = " + av1.maxSaldo());
                System.out.println("");
                av1.print();
                System.out.println("");

                System.out.println(">>> Sua proposta.");
                System.out.println("altura = " + av2.altura());
                System.out.println("maxSaldo = " + av2.maxSaldo());
                System.out.println("");
                av2.print();
                System.out.println("");
                System.out.println(">>> Minha proposta.");
                System.out.println("altura = " + av3.altura());
                System.out.println("maxSaldo = " + av3.maxSaldo());
                System.out.println("");
                av3.print();
                System.out.println("****************************************************************");
                break;
            }

        }
    }
}
