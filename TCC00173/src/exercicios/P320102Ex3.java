package exercicios;

public class P320102Ex3 {

  public static void main(String[] args) {
    int[] v = {2, 3, -4, -5, 6};
    System.out.println(somaPositivos(v));
  }

  public static int somaPositivos(int[] vetor) {
    return somaPositivos(vetor, 0);
  }

  private static int somaPositivos(int[] vetor, int pos) {
    if (pos < 0 || pos > vetor.length - 1)
      return 0;
    else if (pos == vetor.length - 1)
      return vetor[pos] > 0 ? vetor[pos] : 0;
    else
      return (vetor[pos] > 0 ? vetor[pos] : 0) + somaPositivos(vetor,
              pos + 1);

  }
}
