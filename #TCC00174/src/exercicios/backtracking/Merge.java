package exercicios.backtracking;

import java.util.Random;
import javax.swing.*;

public class Merge {

  public static void sort(Comparable[] a) {
    sort(a, 0, a.length);
  }

  // Sort a[lo, hi). 
  public static void sort(Comparable[] a, int lo, int hi) {
    int N = hi - lo;        // number of elements to sort

    // 0- or 1-element file, so we're done
    if (N <= 1)
      return;

    // recursively sort left and right halves
    int mid = lo + N / 2;
    sort(a, lo, mid);
    sort(a, mid, hi);

    // merge two sorted subarrays
    Comparable[] aux = new Comparable[N];
    int i = lo, j = mid;
    for (int k = 0; k < N; k++)
      if (i == mid)
        aux[k] = a[j++];
      else if (j == hi)
        aux[k] = a[i++];
      else if (a[j].compareTo(a[i]) < 0)
        aux[k] = a[j++];
      else
        aux[k] = a[i++];

    // copy back
    for (int k = 0; k < N; k++)
      a[lo + k] = aux[k];
  }

  /**
   * *********************************************************************
   * Check if array is sorted - useful for debugging
   * *********************************************************************
   */
  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++)
      if (a[i].compareTo(a[i - 1]) < 0)
        return false;
    return true;
  }

  /**
   * *********************************************************************
   * Show results
   * *********************************************************************
   */
  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++)
      System.out.println(a[i]);
  }

  // test client
  public static void main(String[] args) {
    int N;
    String input;
    input = JOptionPane.showInputDialog("Size of array?");
    N = Integer.parseInt(input);

    // generate N random real numbers between 0 and 1
    long start = System.currentTimeMillis();
    Double[] a = new Double[N];
    for (int i = 0; i < N; i++)
      a[i] = Math.random();
    long stop = System.currentTimeMillis();
    double elapsed = (stop - start) / 1000.0;
    System.out.println("Generating input:  " + elapsed + " seconds");

    // sort them
    start = System.currentTimeMillis();
    sort(a);
    stop = System.currentTimeMillis();
    elapsed = (stop - start) / 1000.0;
    System.out.println("Mergesort: " + elapsed + " seconds");
    System.out.println(isSorted(a));

    if (N < 100)
      show(a);
  }
}
