package exercicios;

public class P320071EX4_2 {

  public static void main(String[] args) {
    int[] vetor = {2, 4};
    int[][] matriz = {{3, 1, 6}, {6, 8, 2}};
    int[] produto = produtoVetor(vetor, matriz);
    for (int i = 0; i < produto.length; i++)
      System.out.print(produto[i] + " ");

  }

  public static int[] produtoVetor(int[] vetor, int[][] matriz) {
    int[] produto = new int[matriz[0].length];
    for (int j = 0; j < matriz[0].length; j++)
      for (int i = 0; i < vetor.length; i++)
        produto[j] += vetor[i] * matriz[i][j];
    return produto;

  }
}
