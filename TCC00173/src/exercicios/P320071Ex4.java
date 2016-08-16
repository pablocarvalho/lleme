package exercicios;

public class P320071Ex4 {

  public static void main(String[] args) {
    double A[][] = {{2, 3}, {1, 4}};
    double V[] = {1, 2}, W[] = new double[A.length];
    multVetorMatriz(V, A, W);
    escreve(W);
  }

  public static void escreve(double[] v) {
    for (int i = 0; i < v.length; i++)
      System.out.print(v[i] + " ");
  }

  public static void multVetorMatriz(double v[], double A[][], double w[]) {
    for (int j = 0; j < A[0].length; j++)
      for (int i = 0; i < A.length; i++)
        w[j] = w[j] + v[i] * A[i][j];
  }
}
