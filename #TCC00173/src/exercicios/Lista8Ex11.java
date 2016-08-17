package exercicios;

public class Lista8Ex11 {

  public static void main(String[] args) {
    int N = 16;
    int[] vetor = new int[N];
    for (int i = 0; i < N; i++)
      vetor[i] = (int) Math.random() * 100;
    int[][] matriz = new int[(int) Math.sqrt(N)][(int) Math.sqrt(N)];

  }

  public static int[][] VetorMatriz(int[] vetor) {
    int[][] matriz = new int[(int) Math.sqrt(vetor.length)][(int) Math.sqrt(vetor.length)];
    int k = 0;
    for (int i = 0; i < matriz.length; i++)
      for (int j = 0; j < matriz[0].length; j++)
        matriz[i][j] = vetor[k++];
    return matriz;
  }

  public static int[][] VetorMatriz2(int[] vetor) {
    int[][] matriz = new int[(int) Math.sqrt(vetor.length)][(int) Math.sqrt(vetor.length)];
    int a = 0, b = 0;
    for (int i = 0; i < vetor.length; i++)
      matriz[i / matriz[0].length][i % matriz[0].length] = vetor[i];
    return matriz;
  }
}
