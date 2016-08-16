package exercicios;

public class Lista7Ex5_2 {

  public static void main(String[] args) {
    int vet[] = {2, 10, 18, 26, 34};
    System.out.println(PA(vet));
  }

  public static int PA(int[] vet) {
    int k = vet[1] - vet[0];
    for (int i = 2; i < vet.length; i++)
      if (vet[i] - vet[i - 1] != k)
        return 0;
    return k;

  }
}
