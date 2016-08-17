package exercicios;

public class Lista2Ex12 {

  public static void main(String[] args) {
    int a = 2;
    int b = 5;

    for (int i = a; i <= b; i++)
      System.out.println(fatorial(i));

  }

  public static int fatorial(int n) {
    if (n == 0)
      return 1;
    else
      return n * fatorial(n - 1);
  }
}
