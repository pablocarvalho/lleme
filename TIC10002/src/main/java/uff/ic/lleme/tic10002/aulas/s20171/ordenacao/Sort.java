package uff.ic.lleme.tic10002.aulas.s20171.ordenacao;

import java.util.Random;
import uff.ic.lleme.tic10002.aulas.s20171.Entidade;
import uff.ic.lleme.tic10002.aulas.s20171.lista.ListaNaoOrdenada;

public class Sort {

    public static <E extends ListaNaoOrdenada<?, ?>> E selectSort(E lista) {
        for (int i = 0; i < lista.tamanho() - 1; i++)
            for (int j = i + 1; j < lista.tamanho(); j++)
                if (((Entidade) lista.buscar(j)).compareTo((Entidade) lista.buscar(i)) < 0)
                    lista.trocar(i, j);
        return lista;
    }

    public static <E extends ListaNaoOrdenada<?, ?>> E bubbleSort(E lista) {
        int trocas;
        for (int i = lista.tamanho() - 1; i > 0; i--) {
            trocas = 0;
            for (int j = 0; j < i; j++)
                if (((Entidade) lista.buscar(j)).compareTo((Entidade) lista.buscar(j + 1)) > 0) {
                    lista.trocar(i, j);
                    trocas++;
                }
            if (trocas == 0)
                break;
        }
        return lista;
    }

    public static <E extends ListaNaoOrdenada<?, ?>> E mergeSort(E lista) {
        return mergeSort(lista, 0, lista.tamanho() - 1);
    }

    private static <E extends ListaNaoOrdenada<?, ?>> E mergeSort(E lista, int e, int d) {
        if (e < d) {
            int meio = (e + d) / 2;
            mergeSort(lista, e, meio);
            mergeSort(lista, meio + 1, d);
            lista.merge(e, meio, d);
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
