package uff.ic.lleme.tic10002.provas.s20171.revisoes;

public class QuickSortKid {

    private static int iter = 0;
    private static int[] pivotIndexes = {2, 3};

    public static int partition(int arr[], int left, int right) {

        int i = left, j = right;
        int tmp;

        //Random rnd = new Random();
        //int pivot = arr[left + rnd.nextInt(right - left)]; // pivots aleatorio
        int pivot = arr[getPivotIndex(iter++)];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
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

    private static int getPivotIndex(int iter) {
        if (iter < pivotIndexes.length)
            return pivotIndexes[iter];
        else
            return 0;
    }
}
