package uff.ic.lleme.tic10002.ordenacao.rascunho;

public class QuickSort {

    private static int[] lista = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};

    public static void main(String[] args) {
        quickSort(lista);
        System.out.println("fim");
    }

    private static void quickSort(int[] lista) {
        print(lista, 1);
        quickSort(lista, 0, lista.length - 1);
        print(lista, 1);
    }

    private static void quickSort(int[] lista, int p, int r) {
        if (p < r) {
            int q = partition(lista, p, r);
            quickSort(lista, p, q - 1);
            quickSort(lista, q + 1, r);
        }
    }

    private static int partition(int[] lista, int p, int r) {
        int i = p - 1;
        for (int j = p; j < r; j++)
            if (lista[j] < lista[r]) {
                int aux = lista[++i];
                lista[i] = lista[j];
                lista[j] = aux;
                print(lista, 2);
            }
        int aux = lista[++i];
        lista[i] = lista[r];
        lista[r] = aux;
        print(lista, 1);
        return i;
    }

    private static void print(int[] lista, int tipo) {
        String[] listaAux = new String[lista.length];
        for (int i = 0; i < lista.length; i++)
            listaAux[i] = "" + lista[i];

        if (tipo == 1)
            System.out.print("--> {" + String.join(",", listaAux) + "}");
        else
            System.out.print("    {" + String.join(",", listaAux) + "}");
        System.out.println("");
    }

}
