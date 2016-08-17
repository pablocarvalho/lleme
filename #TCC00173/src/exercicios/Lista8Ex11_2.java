package exercicios;

public class Lista8Ex11_2 {

  public static void main(String[] args) {
    double v[] = {2, 4, 5, 3, 1, 1, 1, 1, 1};
    double m[][] = vetor_matriz(v);
    for (double[] linha : m) {
      for (double elem : linha)
        System.out.print(elem + "\t");
      System.out.println("");
    }
  }

  public static double[][] vetor_matriz(double[] vet) {
    int linhas = menor_divisor(vet.length);
    int colunas = vet.length / linhas;
    double[][] mat = new double[linhas][colunas];
    for (int i = 0; i < vet.length; i++)
      mat[i / linhas][i % linhas] = vet[i];
    return mat;
  }

  public static int menor_divisor(int tamanho) {
    for (int div = 2; div < tamanho; div++)
      if (tamanho % div == 0)
        return div;
    return 1;
  }
}
