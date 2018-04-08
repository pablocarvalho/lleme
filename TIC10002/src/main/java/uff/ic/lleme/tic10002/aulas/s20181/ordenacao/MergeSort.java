package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class MergeSort {

    Objeto[] merge;

    public static Objeto[] sort(Objeto[] lista) {
        return sort(lista, 0, lista.length - 1);
    }

    private static Objeto[] sort(Objeto[] lista, int e, int d) {
        if (e < d) {
            int meio = (e + d) / 2;
            sort(lista, e, meio);
            sort(lista, meio + 1, d);
            merge(lista, e, meio, d);
        }
        return lista;
    }

    public static void merge(Objeto[] lista, int p, int q, int r) {
        if (0 <= p && p <= q && q < r && r < lista.length) {
            Objeto[] merge = new Objeto[r - p + 1];
            int i = p, j = q + 1, k = 0;
            while (i <= q || j <= r)
                if (i <= q && j <= r)
                    if (lista[i].chave < lista[j].chave)
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
    }
}
