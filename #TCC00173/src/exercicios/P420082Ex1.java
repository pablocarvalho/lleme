package exercicios;

public class P420082Ex1 {

  public static void main(String[] args) {
    int n = 15556;
    int n2 = 23232;
    int vet[] = converter(n2);
    for (int i = 0; i < 5; i++)
      System.out.println(vet[i] + " ");
    System.out.println(ePalindromo(vet));
  }

  public static boolean ePalindromo(int vet[]) {
    for (int i = 0; i < vet.length / 2; i++)
      if (vet[i] != vet[vet.length - (i + 1)])
        return false;
    return true;
  }

  public static int[] converter(int n) {
    int vet[] = new int[5];
    for (int i = 0; i < 5; i++) {
      vet[i] = (n % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
      n = n - (vet[i] * (int) Math.pow(10, i));
    }
    return vet;
  }
}
