package exercicios;

public class Lista7Ex1_2 {

  public static void main(String[] args) {
    int[] vet = {2, -4, -5, -1, 2};
    System.out.println(negativos(5, vet));
  }

  public static int negativos(int n, int[] vet) {
    int qtd = 0;
    for (int i = 0; i < n; i++)
      if (vet[i] < 0)
        qtd++;

    return qtd;
  }
}
