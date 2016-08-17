package exemplos;

public class Lista9Ex6_2 {

  public static void main(String[] args) {
    int[] a = {-1, 2, 3, 4, -6, -3, 1};
    System.out.println(somaP(a, 0));
  }

  public static int somaP(int[] vet, int i) {
    if (i >= vet.length)
      return 0;
    else if (vet[i] > 0)
      return vet[i] + somaP(vet, i + 1);
    else
      return somaP(vet, i + 1);
  }
}
