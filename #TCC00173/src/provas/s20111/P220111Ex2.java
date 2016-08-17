package provas.s20111;

public class P220111Ex2 {

  public static void main(String[] args) {
    float[][] A = {{-1, 2, 3, -4}, {4, 2, 0, 0}, {-1, 2, -3, 0}, {2, 5, 3, 1}};
    System.out.println(determinante(A));
  }

  public static float determinante(float[][] A) {
    float determinante = 0;
    if (A.length == 1)
      determinante = A[0][0];
    else
      for (int j = 0; j < A[0].length; j++)
        determinante += A[0][j] * Math.pow(-1, j) * determinante(cofator(A, 0, j));
    return determinante;
  }

  public static float[][] cofator(float[][] A, int i, int j) {
    float[][] cofator = new float[A.length - 1][A.length - 1];
    int m = 0, n = 0;
    for (int k = 0; k < A.length; k++)
      if (k != i) {
        for (int l = 0; l < A.length; l++)
          if (l != j)
            cofator[m][n++] = A[k][l];
        m++;
        n = 0;
      }
    return cofator;
  }
}
