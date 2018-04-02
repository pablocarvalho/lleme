package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;
import java.util.Random;

public class QuickSort {

    private static Random random = new Random();

    public static Objeto[] quickSort(Objeto[] lista) {
        return quickSort(lista, 0, lista.length - 1);

    }

    private static Objeto[] quickSort(Objeto[] lista, int p, int r) {
        if (p < r) {
            int q = partition(lista, p, r);
            quickSort(lista, p, q - 1);
            quickSort(lista, q + 1, r);
        }
        return lista;
    }

    private static int partition(Objeto[] lista, int e, int d) {
        int sorteio = random.nextInt(d - e + 1) + e;
        trocar(lista, d, sorteio);

        Objeto pivot = lista[d];
        int i = e - 1;
        for (int j = e; j < d; j++)
            if (lista[j].chave < pivot.chave)
                trocar(lista, ++i, j);
        trocar(lista, i + 1, d);
        return i + 1;
    }

    private static void trocar(Objeto[] lista, int i, int j) {
        Objeto aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

}
