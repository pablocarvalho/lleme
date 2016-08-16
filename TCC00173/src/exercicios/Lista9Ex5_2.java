package exercicios;

public class Lista9Ex5_2 {

  public static void main(String[] args) {

    int[] vetor = {2, 50, 50, 7, 1, 10, 1,};
    System.out.println(maximo(vetor, 0));

  }

  public static int maximo(int[] vetor, int pos) {
    if (pos == vetor.length - 1)
      return pos;
    int posMax = maximo(vetor, pos + 1);
    if (vetor[pos] >= vetor[posMax])
      return pos;
    return posMax;
  }
}
