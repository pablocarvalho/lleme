package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class MergeSort {

    Conteudo[] merge;

    public static Conteudo[] sort(Conteudo[] lista) {
        return sort(lista, 0, lista.length - 1);
    }

    private static Conteudo[] sort(Conteudo[] lista, int e, int d) {
        if (e < d) {
            int meio = (e + d) / 2;
            sort(lista, e, meio);
            sort(lista, meio + 1, d);
            merge(lista, e, meio, d);
        }
        return lista;
    }

    public static void merge(Conteudo[] lista, int p, int q, int r) {
        if (0 <= p && p <= q && q < r && r < lista.length) {
            Conteudo[] merge = new Conteudo[r - p + 1];
            int i = p, j = q + 1, k = 0;
            while (i <= q || j <= r)
                if (i <= q && j <= r)
                    if (lista[i].chaveAsNum() < lista[j].chaveAsNum())
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
