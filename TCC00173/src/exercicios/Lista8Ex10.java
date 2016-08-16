package exercicios;

public class Lista8Ex10 {

  public static void main(String[] args) {
    double m[][] = {{2, 4, 5}, {3, 1, 1}, {1, 1, 1}};
    double vet[] = matriz_vetor(m);
    for (double n : vet)
      System.out.print(n + "\t");
  }

  public static double[] matriz_vetor(double[][] mat) {
    double vet[] = new double[mat.length * mat[0].length];
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        vet[i * mat[0].length + j] = mat[i][j];
    return vet;
  }
}
