package uff.ic.lleme.tic10002.provas.s20171;

import java.util.Arrays;

public class QuickSortLuisHenrique {

    private static void trocar(int[] lista, int x, int y) {
        int aux = lista[x];
        lista[x] = lista[y];
        lista[y] = aux;
    }

    private static int partition(int[] lista, int inicio, int fim) {
        int pivo = lista[inicio];
        int i = inicio + 1;
        int j = fim;
        while (i < j) {
            while ((i < fim) && (lista[i] < pivo))
                i++;

            while ((j > inicio) && (lista[j] >= pivo))
                j--;

            if (i < j) {
                trocar(lista, i, j);
                print(lista, 2);
            }
        }

        if (pivo > lista[j]) {
            trocar(lista, inicio, j);
            print(lista, 2);
        }

        return j;
    }

    private static void quickSort(int[] lista, int inicio, int fim) {
        if (inicio < fim) {
            int meio = partition(lista, inicio, fim);
            quickSort(lista, inicio, meio - 1);
            quickSort(lista, meio + 1, fim);
        }
    }

    public static void sort(int[] lista) {
        int inicio = 0;
        int fim = lista.length - 1;
        print(lista, 1);
        quickSort(lista, inicio, fim);
        print(lista, 1);
    }

    public static void main(String[] args) {
        int[] data = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};
        sort(data);
    }

    private static void print(int[] lista, int tipo) {
        if (tipo == 1)
            System.out.print("--> " + Arrays.toString(lista));
        else
            System.out.print("    " + Arrays.toString(lista));
        System.out.println("");
    }
}
