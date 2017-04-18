package uff.ic.lleme.tic10002.sort.rascunho;

public class QuickSort {

    private static int[] lista = {3, 6, 10, 1, 34, 13};

    public static void main(String[] args) {
        quickSort(lista);
        System.out.println("fim");
    }

    private static void quickSort(int[] lista) {
        quickSort(lista, 0, lista.length - 1);
    }

    private static void quickSort(int[] lista, int p, int r) {
        if (p < r) {
            int q = partition(lista, p, r);
            quickSort(lista, p, q - 1);
            quickSort(lista, q + 1, r);
        }
    }

    private static int partition(int[] lista, int p, int r) {
        int i = p - 1;
        for (int j = p; j < r; j++)
            if (lista[j] < lista[r]) {
                int aux = lista[++i];
                lista[i] = lista[j];
                lista[j] = aux;
            }
        int aux = lista[++i];
        lista[i] = lista[r];
        lista[r] = aux;
        return i;
    }

}
