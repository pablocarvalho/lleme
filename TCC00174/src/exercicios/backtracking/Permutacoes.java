package exercicios.backtracking;

public class Permutacoes {

  public static void main(String[] args) {
    backtrack(new int[5], -1);
  }

  static void backtrack(final int[] a, int k) {
    if (isSolution(a, k))
      processSolution(a, k);
    else {
      k = k + 1;

      int[] c = constructCandidates(a, k);

      for (int i = 0; i < c.length; i++) {
        a[k] = c[i];
        backtrack(a, k);
      }
    }
  }

  static boolean isSolution(final int[] a, int k) {
    return ((k + 1) == a.length);
  }

  static int[] constructCandidates(final int[] a, int k) {
    boolean[] inPerm = new boolean[a.length];
    for (int i = 0; i < k; i++)
      inPerm[a[i]] = true;

    int n = a.length - k;

    int[] c = new int[n];
    for (int i = 0, j = 0; i < inPerm.length; i++)
      if (!inPerm[i])
        c[j++] = i;

    return c;
  }

  static void processSolution(final int[] a, int k) {
    System.out.print("{");
    for (int i = 0; i <= k; i++)
      System.out.print(" " + a[i]);
    System.out.println(" }");
  }
}
