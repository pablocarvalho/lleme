package uff.ic.lleme.tic10002.aulas.ordenacao;

import java.util.Random;
import uff.ic.lleme.tic10002.aulas.utils.Conteudo;

public class QuickSort {

    private static Random random = new Random();

    public static Conteudo[] sort(Conteudo[] lista) {
        return sort(lista, 0, lista.length - 1);

    }

    private static Conteudo[] sort(Conteudo[] lista, int p, int r) {
        if (p < r) {
            int q = partition(lista, p, r);
            sort(lista, p, q - 1);
            sort(lista, q + 1, r);
        }
        return lista;
    }

    private static int partition(Conteudo[] lista, int p, int r) {
        int sorteio = random.nextInt(r - p + 1) + p;
        trocar(lista, r, sorteio);

        Conteudo pivot = lista[r];
        int i = p - 1;
        for (int j = p; j < r; j++)
            if (lista[j].chaveAsNum() < pivot.chaveAsNum())
                trocar(lista, ++i, j);
        trocar(lista, i + 1, r);
        return i + 1;
    }

    private static void trocar(Conteudo[] lista, int i, int j) {
        Conteudo aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

}
