package exercicios;

public class Lista8Ex2_2 {

  public static void main(String[] args) {
  }

  public static double traco(double mat[][]) {
    double soma = 0;
    for (int i = 0; i < mat.length; i++)
      soma += mat[i][i];
    return soma;

  }
}
