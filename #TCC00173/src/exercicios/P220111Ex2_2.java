package exercicios;

public class P220111Ex2_2 {

  public static void main(String[] args) {
    float[][] a = {{3, 2, 5}, {1, 1, 2}, {0, 1, 0}};
    System.out.println(determinante(a));
  }

  public static float determinante(float[][] a) {
    float det = 0;
    if (a.length != 0) {
      for (int j = 0; j < a[0].length; j++)
        det += a[0][j] * Math.pow(-1, j) * determinante(cofator(a, 0, j));

      return det;
    } else
      return 1;
  }

  public static float[][] cofator(float[][] a, int i, int j) {
    int m = 0, n;
    float[][] b = new float[a.length - 1][a[0].length - 1];
    for (int k = 0; k < a.length; k++)
      if (k != i) {
        n = 0;
        for (int l = 0; l < a[0].length; l++)
          if (l != j)
            b[m][n++] = a[k][l];
        m++;
      }
    return b;
  }
}
