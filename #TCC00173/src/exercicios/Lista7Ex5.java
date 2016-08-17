package exercicios;

public class Lista7Ex5 {

  public static void main(String[] args) {
  }

  public static int testePA(int vetor[]) {
    int k = vetor[1] - vetor[0];
    for (int i = 2; i < vetor.length; i++)
      if (vetor[i] != vetor[i - 1] + k)
        return 0;
    return k;
  }
}
