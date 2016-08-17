package exercicios;

public class P320102Ex3_2 {

  public static void main(String[] args) {
    int[] vetor = {1, 3, 7, 5, 5, 9};
    System.out.println(somaElementos(vetor, 0));
  }

  public static int somaElementos(int[] vetor, int pos) {
    if (vetor.length == pos + 1)
      return vetor[pos];
    else
      return vetor[pos] + somaElementos(vetor, pos + 1);
  }
}
