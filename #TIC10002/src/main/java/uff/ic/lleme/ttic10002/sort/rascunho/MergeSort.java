package uff.ic.lleme.ttic10002.sort.rascunho;

public class MergeSort {

    private static int[] lista = {3, 6, 10, 1, 34, 13};

    public static void main(String[] args) {
        mergeSort(lista);
        System.out.println("fim");
    }

    public static void mergeSort(int[] lista) {
        mergeSort(lista, 0, lista.length - 1);
    }

    private static void mergeSort(int[] lista, int e, int d) {
        if (e < d) {
            int m = (e + d) / 2;
            mergeSort(lista, e, m);
            mergeSort(lista, m + 1, d);
            merge(lista, e, m, d);
        }

    }

    private static void merge(int[] lista, int e, int m, int d) {
        int[] aux = new int[d - e + 1];
        int i = e, j = m + 1, k = 0;
        while (i <= m || j <= d)
            if (i <= m && j <= d)
                if (lista[i] <= lista[j])
                    aux[k++] = lista[i++];
                else
                    aux[k++] = lista[j++];
            else if (i <= m)
                aux[k++] = lista[i++];
            else
                aux[k++] = lista[j++];
        i = e;
        for (int l = 0; l < aux.length; l++)
            lista[i++] = aux[l];
    }
}
