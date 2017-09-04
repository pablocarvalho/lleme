package uff.ic.lleme.tic10002.aulas.s20171.ordenacao.rascunho;

public class SortSelecao {

    private static int[] lista = {3, 6, 10, 1, 34, 13};

    public static void main(String[] args) {
        sortSelecao(lista);
        System.out.println("fim");
    }

    public static void sortSelecao(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int pos = procurarMinimo(lista, i);
            trocar(lista, i, pos);
        }
    }

    private static int procurarMinimo(int[] lista, int i) {
        int min = lista[i];
        int posMin = i;
        for (int j = i + 1; j < lista.length; j++)
            if (lista[j] < min) {
                min = lista[j];
                posMin = j;
            }
        return posMin;
    }

    private static void trocar(int[] lista, int i, int j) {
        int aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

}
