package uff.ic.lleme.tic10002.sort.rascunho;

public class BubbleSort {

    private static int[] lista = {3, 6, 10, 1, 34, 13};

    public static void main(String[] args) {
        bubleSort(lista);
        System.out.println("fim");
    }

    private static void bubleSort(int[] lista) {
        boolean houveTrocas = true;
        for (int i = lista.length - 1; i > 0 && houveTrocas; i--)
            houveTrocas = empurrarParaI(lista, i);
    }

    private static boolean empurrarParaI(int[] lista, int i) {
        int trocas = 0;
        for (int j = 0; j < i - 1; j++)
            if (lista[j] > lista[j + 1]) {
                trocar(lista, j, j + 1);
                trocas++;
            }
        return (trocas > 0 ? true : false);
    }

    private static void trocar(int[] lista, int i, int j) {
        int aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

}
