package exercicios;

public class Lista9Ex5 {

  public static void main(String[] args) {
    int[] vetor = {1000, 23, 2, 45, 96, 100, 2};
    System.out.println(maximo(vetor, 0));
  }

  public static int maximo(int[] vetor, int n) {
    if (n == vetor.length - 1)
      return vetor[vetor.length - 1];
    int max = maximo(vetor, n + 1);
    if (vetor[n] > max)
      return vetor[n];
    else
      return max;
  }
}
