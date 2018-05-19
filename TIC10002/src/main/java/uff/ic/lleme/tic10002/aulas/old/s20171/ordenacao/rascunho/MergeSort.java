package uff.ic.lleme.tic10002.aulas.old.s20171.ordenacao.rascunho;

public class MergeSort {

    private static int[] lista = {3, 6, 10, 1, 34, 13};

    public static void main(String[] args) {
        mergeSort(lista);
        System.out.println("fim");
    }

    public static void mergeSort(int[] lista) {
        dividir(lista, 0, lista.length - 1);
    }

    private static void dividir(int[] lista, int e, int d) {
        if (e < d) {
            int m = (e + d) / 2;
            dividir(lista, e, m);
            dividir(lista, m + 1, d);
            merge(lista, e, m, d);
        }
    }

    private static void merge(int[] lista, int e, int m, int d) {
        int[] result = new int[d - e + 1];
        int i = e, j = m + 1, k = 0;
        while (i <= m || j <= d)
            if (i <= m && j <= d)
                if (lista[i] <= lista[j])
                    result[k++] = lista[i++];
                else
                    result[k++] = lista[j++];
            else if (i <= m)
                result[k++] = lista[i++];
            else
                result[k++] = lista[j++];
        i = e;
        for (int l = 0; l < result.length; l++)
            lista[i++] = result[l];
    }
}
