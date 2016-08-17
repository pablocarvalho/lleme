package exercicios;

public class P220111Ex2v2 {

  public static void main(String[] args) {
    float[][] mat = {{1, 2, 3}, {4, 1, 2}, {1, 8, 1}};
    System.out.println(determinante(mat));
  }

  public static float determinante(float[][] a) {
    int i = 0;
    float soma = (a.length == 0 ? 1 : 0);
    for (int j = 0; j < a.length; j++)
      soma += a[i][j] * Math.pow(-1, i + j) * determinante(cofator(a, i, j));
    return soma;
  }

  public static float[][] cofator(float[][] a, int i, int j) {
    float[][] cof = new float[a.length - 1][a.length - 1];
    int linha;
    int coluna;
    for (int k = 0; k < a.length; k++)
      if (k != i)
        for (int l = 0; l < a.length; l++)
          if (l != j) {
            linha = (k > i ? k - 1 : k);
            coluna = (l > j ? l - 1 : l);
            cof[linha][coluna] = a[k][l];
          }
    return cof;
  }
}
