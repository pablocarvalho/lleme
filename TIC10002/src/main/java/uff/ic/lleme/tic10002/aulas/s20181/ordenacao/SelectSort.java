package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

public class SelectSort {

    public static Objeto[] sort(Objeto[] lista) {
        for (int i = 0; i < lista.length - 1; i++)
            for (int j = i + 1; j < lista.length; j++)
                if (lista[j].chave < lista[i].chave)
                    trocar(lista, i, j);
        return lista;
    }

    private static void trocar(Objeto[] lista, int i, int j) {
        Objeto aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
}
