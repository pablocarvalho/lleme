package uff.ic.lleme.tic10002.aulas.arvores.arvoreB;

import java.util.Random;
import uff.ic.lleme.tic10002.aulas.utils.Empregado;

public class Main {

    public static void main(String[] args) {
        ArvoreB arvore = new ArvoreB();
        Random rand = new Random();

        Empregado[] num = new Empregado[20];

        for (int i = 0; i < 20; i++)
            num[i] = new Empregado(i);
        for (Empregado e : num)
            System.out.print(e.chave() + " ");
        System.out.println("");

        for (Empregado e : num) {
            arvore.incluir(e);
            arvore.print();
            System.out.println("");
        }
    }
}
