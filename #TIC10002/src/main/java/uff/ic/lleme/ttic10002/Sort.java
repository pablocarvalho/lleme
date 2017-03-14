package uff.ic.lleme.ttic10002;

public class Sort {

    public static <T extends Comparable> T[] quickSort(T[] array) {
        return quickSort(array, 0, array.length - 1);

    }

    private static <T extends Comparable> T[] quickSort(T[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
        return array;
    }

    private static <T extends Comparable> int partition(T[] array, int p, int r) {
        T aux;
        T x = array[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++)
            if (array[j].compareTo(x) < 0) {
                i++;
                exchange(array, i, j);
            }
        exchange(array, i + 1, r);
        return i + 1;
    }

    private static <T> void exchange(T[] array, int i, int j) {
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
