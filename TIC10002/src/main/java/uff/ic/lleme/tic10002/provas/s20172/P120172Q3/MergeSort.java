package uff.ic.lleme.tic10002.provas.s20172.P120172Q3;

public class MergeSort {

    public static void merge(int[] lista, int p, int q, int r) {
        if (0 <= p && p <= q && q < r && r < lista.length) {
            int[] merge = new int[r - p + 1];
            int i = p, j = q + 1, k = 0;
            while (i <= q || j <= r)
                if (i <= q && j <= r)
                    if (lista[i] <= lista[j])
                        merge[k++] = lista[i++];
                    else
                        merge[k++] = lista[j++];
                else if (i <= q)
                    merge[k++] = lista[i++];
                else if (j <= r)
                    merge[k++] = lista[j++];

            i = p;
            for (k = 0; k < merge.length; k++)
                lista[i++] = merge[k];
        }
        print(lista);
    }

    private static int[] mergeSort(int[] lista, int e, int d) {
        if (e < d) {
            int meio = (e + d) / 2;
            mergeSort(lista, e, meio);
            mergeSort(lista, meio + 1, d);
            merge(lista, e, meio, d);
        }
        return lista;
    }

    public static int[] mergeSort(int[] lista) {
        return mergeSort(lista, 0, lista.length - 1);
    }

    public static void print(int[] lista) {
        System.out.print("[");
        for (int i = 0; i < lista.length; i++)
            System.out.print(lista[i] + ", ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] lista = {2, 9, 5, 3, 88, 83, 4, 1};
        mergeSort(lista);
    }
}
