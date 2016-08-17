package exemplos.listas.backtracking;

public class Subconjuntos {

  public static void main(String[] args) {
    boolean[] a = {true, true, true};
    backtrack(a, -1);
  }

  public static void backtrack(boolean[] a, int k) {
    if (isSolution(a, k))
      processSolution(a, k);
    else {
      k = k + 1;
      boolean[] c = constructCandidates(a, k);

      for (int i = 0; i < c.length; i++) {
        a[k] = c[i];
        backtrack(a, k);
      }
    }
  }

  public static boolean isSolution(final boolean[] a, int k) {
    return ((k + 1) == a.length);
  }

  public static void processSolution(final boolean[] a, int k) {
    System.out.print("{");
    for (int i = 0; i <= k; i++)
      if (a[i])
        System.out.print(" " + i);
    System.out.println(" }");
  }

  public static boolean[] constructCandidates(final boolean[] a, int k) {
    boolean[] c = new boolean[2];
    c[0] = false;
    c[1] = true;
    return c;
  }
}
