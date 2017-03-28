package uff.ic.lleme.ttic10002.sort;

import java.util.Random;
import uff.ic.lleme.ttic10002.Entidade;
import uff.ic.lleme.ttic10002.lista.ListaNaoOrdenada;

public class Sort {

    public static <E extends ListaNaoOrdenada<?, ?>> E selecao(E lista) {
        int t, i, j, min;
        for (i = 0; i < lista.tamanho() - 1; i++) {
            min = i;
            for (j = i + 1; j < lista.tamanho(); j++)
                if (((Entidade) lista.buscar(j)).compareTo((Entidade) lista.buscar(min)) < 0) {
                    min = j;
                    lista.trocar(min, i);
                }
        }
        return lista;
    }

    public static <E extends ListaNaoOrdenada<?, ?>> E quickSort(E lista) {
        return quickSort(lista, 0, lista.tamanho() - 1);

    }

    private static <E extends ListaNaoOrdenada<?, ?>> E quickSort(E lista, int p, int r) {
        if (p < r) {
            int q = partition(lista, p, r);
            quickSort(lista, p, q - 1);
            quickSort(lista, q + 1, r);
        }
        return lista;
    }

    private static <E extends ListaNaoOrdenada<?, ?>> int partition(E lista, int e, int d) {
        lista.trocar(d, (new Random()).nextInt(d - e + 1) + e);

        Entidade pivot = lista.buscar(d);
        int i = e - 1;
        for (int j = e; j < d; j++)
            if (((Entidade) lista.buscar(j)).compareTo(pivot) <= 0)
                lista.trocar(++i, j);
        lista.trocar(i + 1, d);
        return i + 1;
    }

}
