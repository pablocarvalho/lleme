package uff.ic.lleme.tic10002.provas.s20171.revisoes;

public class QuickSortKid {

    private static int v = 0;
    private static int lisPiv[] = {14, 43, 52, 31, 4, 7, 3};
    private static int p = 0;

    public static int partition(int arr[], int left, int right) {
        System.out.println("--------------------------------------");
        System.out.println("limites izq: " + left + " der: " + right);
        int i = left, j = right;
        int indxPivo = getIndexPivo(lisPiv[p++], arr);
        int numGire = arr[indxPivo];
        System.out.println("Pivo: numero: [" + numGire + "] indice (" + indxPivo + ")");
        int idxBlanco = indxPivo; //
        arr[idxBlanco] = 0; // só se considero o zero para a representação do espaço em branco
        imprimir(arr);
        int pivot = numGire;
        boolean iz = false;
        while (i <= j) {
            if (!iz) {
                while (arr[j] > pivot)
                    j--;
                iz = true;
            } else {
                while (arr[i] < pivot)
                    i++;
                iz = false;
            }
            if (i <= j)
                if (iz) {
                    arr[idxBlanco] = arr[j];
                    idxBlanco = j;
                    arr[j] = 0; // solo visual
                    j--;
                } else {
                    arr[idxBlanco] = arr[i];
                    idxBlanco = i;
                    arr[i] = 0; // solo visual
                    i++;
                }
            imprimir(arr);
        }
        arr[idxBlanco] = numGire;
        imprimir(arr);
        return i;
    }

    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (index < right)
            quickSort(arr, index, right);
        if (left < index - 1)
            quickSort(arr, left, index - 2);
    }

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static int getIndexPivo(int num, int arr[]) {
        int idx = -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num) {
                idx = i;
                break;
            }
        return idx;
    }

    public static void imprimir(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int i;
        int array[] = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};
        System.out.println("VALORES INICIALES:");
        for (i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
        quickSort(array);
        System.out.print("LISTA ORDENADA:\n");
        for (i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();

    }
}
