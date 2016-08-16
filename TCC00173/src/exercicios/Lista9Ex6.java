package exercicios;

public class Lista9Ex6 {

  public static void main(String[] args) {
    int[] vetor = {2, -4, -5, 3, 1, -67, 10};
    System.out.println(somaPositivos(vetor, 0));
  }

  public static int somaPositivos(int[] vetor, int i) {
    if (i < vetor.length)
      if (vetor[i] > 0)
        return vetor[i] + somaPositivos(vetor, ++i);
      else
        return somaPositivos(vetor, ++i);
    else
      return 0;
  }
}
