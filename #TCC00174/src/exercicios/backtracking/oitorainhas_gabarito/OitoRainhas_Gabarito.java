/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.backtracking.oitorainhas_gabarito;

/**
 *
 * @author mlage
 */
public class OitoRainhas_Gabarito {

  static boolean finished = false;

  public static void main(String[] args) {
    backtrack(new int[8], -1);
  }

  static void backtrack(final int[] a, int k) {
    if (isSolution(a, k)) {
      processSolution(a, k);
      finished = true;
    } else {
      k = k + 1;

      int[] c = constructCandidates(a, k);

      for (int i = 0; i < c.length; i++) {
        if (c[i] == -1)
          break;

        a[k] = c[i];
        backtrack(a, k);

        if (finished)
          return;
      }
    }
  }

  static boolean isSolution(final int[] a, int k) {
    return ((k + 1) == a.length);
  }

  static int[] constructCandidates(final int[] a, int k) {

    int[] c = new int[64];
    for (int i = 0; i < c.length; i++)
      c[i] = -1;

    int cont = 0;
    for (int l = 0; l < 64; l++) {
      int t = l / 8;
      int s = l % 8;
      boolean passou = true;

      for (int i = 0; i < k; i++) {
        int ta = a[i] / 8;
        int sa = a[i] % 8;
        int td, sd;
        td = Math.abs(ta - t);
        sd = Math.abs(sa - s);
        if (ta == t || sa == s || td == sd) {
          passou = false;
          break;
        }


      }
      if (passou)
        c[cont++] = l;
    }


    return c;
  }

  static void processSolution(final int[] a, int k) {
    System.out.print("{");
    for (int i = 0; i <= k; i++)
      System.out.print(" (" + a[i] / 8 + "," + a[i] % 8 + ")");
    System.out.println(" }");
  }
}
