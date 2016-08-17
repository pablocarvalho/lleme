package exemplos.listas.backtracking;

import static exemplos.listas.backtracking.Subconjuntos.backtrack;

public class Permutacoes {

  private static boolean finished = false; /* Todas soluções encontradas? */


  public static void main(String[] args) {
    int[] a = {0, 0, 0, 0, 0};
    int[] s = {13, 26, 38, 56, 2};
    backtrack(a, -1, s);
  }

  public static void backtrack(int[] a, int k, int[] set) {
    if (isSolution(a, k))
      processSolution(a, k);
    else {
      k = k + 1;
      int[] c = constructCandidates(a, k, set);

      for (int i = 0; i < c.length; i++) {
        a[k] = c[i];
        backtrack(a, k, set);
        a[k] = 0;

        if (finished)
          return;
      }
    }
  }

  public static boolean isSolution(final int[] a, int k) {
    return ((k + 1) == a.length);
  }

  public static void processSolution(final int[] a, int k) {
    System.out.print("{");
    for (int i = 0; i <= k; i++)
      System.out.print(" " + a[i]);
    System.out.println(" }");
  }

  public static int[] constructCandidates(final int[] a, int k, int[] set) {
    boolean[] inPerm = new boolean[set.length];
    for (int i = 0; i < set.length; i++)
      if (estaEm(a, set[i]))
        inPerm[i] = true;

    int n = 0;
    for (int i = 0; i < inPerm.length; i++)
      if (!inPerm[i])
        n++;

    int[] cand = new int[n];
    for (int i = 0, j = 0; i < inPerm.length; i++)
      if (!inPerm[i])
        cand[j++] = set[i];
    return cand;
  }

  private static boolean estaEm(int[] a, int n) {
    for (int i = 0; i < a.length; i++)
      if (a[i] == n)
        return true;
    return false;
  }
}
