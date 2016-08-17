package exercicios;

public class Lista9Ex4 {

  public static void main(String[] args) {
    for (int n = 0; n < 10; n++)
      System.out.println(padovana(n));
  }

  public static int padovana(int n) {
    if (n == 2 || n == 1 || n == 0)
      return 1;
    return padovana(n - 1) + padovana(n - 2);
  }
}
