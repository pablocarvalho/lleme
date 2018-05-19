package uff.ic.lleme.tic10002.aulas.s20171.arvoreAVL;

import uff.ic.lleme.tic10002.aulas.s20171.arvoreAVL.ArvoreAVLCorrigida;
import uff.ic.lleme.tic10002.aulas.s20171.arvoreAVL.ArvoreAVLErrada;
import uff.ic.lleme.tic10002.aulas.s20171.arvoreAVL.ArvoreAVLLuan;
import java.util.Arrays;
import uff.ic.lleme.tic10002.utils.Empregado;

public class MainAVLLuan {

    public static void main(String[] args) {
        {
            int[] chaves = {843779, 227559, 309958, 899394, 986152, 403202, 629179, 101630, 965388};

            System.out.println("****************************************************************");
            System.out.println("Input: " + Arrays.toString(chaves));
            System.out.println("");
            {
                System.out.println(">>> Com codigo que estava errado.");
                ArvoreAVLErrada av = new ArvoreAVLErrada(true);
                for (int chave : chaves)
                    av.inserir(new Empregado(chave));
                System.out.println("altura = " + av.altura());
                System.out.println("maxSaldo = " + av.maxSaldo());
                System.out.println("");
                av.print();
                System.out.println("");
            }
            {
                System.out.println(">>> Sua proposta.");
                ArvoreAVLLuan av = new ArvoreAVLLuan(true);
                for (int chave : chaves)
                    av.inserir(new Empregado(chave));
                System.out.println("altura = " + av.altura());
                System.out.println("maxSaldo = " + av.maxSaldo());
                System.out.println("");
                av.print();
                System.out.println("");
            }
            {
                System.out.println(">>> Minha proposta.");
                ArvoreAVLCorrigida av = new ArvoreAVLCorrigida(true);
                for (int chave : chaves)
                    av.inserir(new Empregado(chave));
                System.out.println("altura = " + av.altura());
                System.out.println("maxSaldo = " + av.maxSaldo());
                System.out.println("");
                av.print();
                System.out.println("");
            }
            System.out.println("****************************************************************");

        }
    }
}
