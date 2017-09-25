package uff.ic.lleme.tic10002.prova.s20171.revisoes;

import java.util.Arrays;

public class QuickSortPaulo {

    private void quicksort(int[] list, int low, int high) {
        if (low >= high)
            return;
        int index = partition(list, low, high);
        quicksort(list, low, index - 1);
        quicksort(list, index + 1, high);
    }

    ;

  private int partition(int[] list, int low, int high) {
        int left = low;
        int right = high;
        int posPivot = (low + high) / 2;
        int pivot = list[posPivot];
        while (left < right) {
            while ((list[left] <= pivot) && (left < right))
                left++;
            while ((list[right] >= pivot) && (left < right))
                right--;
            if ((left < right)) {
                swap(list, left, right);
                System.out.println(Arrays.toString(list));
            }
            left++;
            right--;
        }

        left--;
        right++;
        if (left > posPivot) {
            if (pivot > list[left]) {
                swap(list, posPivot, left);
                posPivot = left;
                System.out.println(Arrays.toString(list));
            }
        } else if (right < posPivot)
            if (pivot < list[right]) {
                swap(list, posPivot, right);
                posPivot = right;
                System.out.println(Arrays.toString(list));
            }
        return posPivot;

    }

    private void swap(int[] list, int left, int right) {
        int aux = list[left];
        list[left] = list[right];
        list[right] = aux;
    }

    public static void main(String[] args) {
        int[] list = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};
        System.out.println("INÍCIO");
        System.out.println(Arrays.toString(list));
        QuickSortPaulo sort = new QuickSortPaulo();
        sort.quicksort(list, 0, list.length - 1);
        System.out.println("FIM");
    }
;
}
