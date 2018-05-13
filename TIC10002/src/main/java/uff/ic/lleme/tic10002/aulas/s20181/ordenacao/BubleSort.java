package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class BubleSort {

    public static Conteudo[] sort(Conteudo[] lista) {
        int trocas = 0;
        for (int i = lista.length - 1; i > 0; i--, trocas = 0) {
            for (int j = 0; j < i; j++)
                if (lista[j].chaveAsNum() > lista[j + 1].chaveAsNum()) {
                    trocar(lista, j, j + 1);
                    trocas++;
                }
            if (trocas == 0) break;
        }
        return lista;
    }

    private static void trocar(Conteudo[] lista, int i, int j) {
        Conteudo aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
}
