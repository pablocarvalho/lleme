package uff.ic.lleme.tic10002.provas.s20171;

import java.util.Arrays;

public class QuickSortAshey {

    private static void print(int[] lista, int tipo) {
        if (tipo == 1)
            System.out.print("--> " + Arrays.toString(lista));
        else
            System.out.print("    " + Arrays.toString(lista));
        System.out.println("");
    }

    public static int partition(int[] lista, int p, int r) {
        int i = p;
        int j, k;
        int[] aux = lista;
        int kk = r;

        for (j = p, k = r - 1; j < k; j++, k--) {
            if (lista[j] < lista[r])
                aux[i++] = lista[j];
            else
                aux[kk--] = lista[j];

            if (lista[k] >= lista[r])
                aux[kk--] = lista[k];
            else
                aux[i++] = lista[k];

        }
        if (j == k && lista[j] < lista[r]) {
            aux[i] = lista[j];
            aux[kk] = lista[r];
            i = kk;
        } else if (j == k) {
            aux[kk] = lista[j];
            aux[i] = lista[r];
        } else
            aux[i] = lista[r];

        lista = aux;
        return i;

    }

    public static void quickSort(int[] lista, int p, int r) {
        if (p < r) {
            int q = partition(lista, p, r);
            print(lista, 1);
            quickSort(lista, p, q - 1);
            quickSort(lista, q + 1, r);
        }
    }

    public static void quickSort(int[] lista) {
        quickSort(lista, 0, lista.length - 1);
    }

    public static void main(String[] args) {
        int lista[] = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};
        print(lista, 1);
        quickSort(lista);
        print(lista, 1);
    }
}
