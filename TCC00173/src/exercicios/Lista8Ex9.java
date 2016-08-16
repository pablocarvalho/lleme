package exercicios;

public class Lista8Ex9 {

  public static void troca_linha(double a[][], int u, int v) {
    double n;

    for (int i = 0; i < a[0].length; i++) {
      n = a[u][i];
      a[u][i] = a[v][i];
      a[v][i] = n;
    }

  }
}
