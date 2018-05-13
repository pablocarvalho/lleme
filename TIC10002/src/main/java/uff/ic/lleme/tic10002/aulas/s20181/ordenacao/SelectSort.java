package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class SelectSort {

    public static Conteudo[] sort(Conteudo[] lista) {
        for (int i = 0; i < lista.length - 1; i++)
            for (int j = i + 1; j < lista.length; j++)
                if (lista[j].chaveAsNum() < lista[i].chaveAsNum())
                    trocar(lista, i, j);
        return lista;
    }

    private static void trocar(Conteudo[] lista, int i, int j) {
        Conteudo aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
}
