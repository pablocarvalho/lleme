package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class BubleSort {

    public static Objeto[] sort(Objeto[] lista) {
        int trocas = 0;
        for (int i = lista.length - 1; i > 0; i--, trocas = 0) {
            for (int j = 0; j < i; j++)
                if (lista[j].chave > lista[j + 1].chave) {
                    trocar(lista, j, j + 1);
                    trocas++;
                }
            if (trocas == 0) break;
        }
        return lista;
    }

    private static void trocar(Objeto[] lista, int i, int j) {
        Objeto aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
}
