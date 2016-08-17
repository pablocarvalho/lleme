package exercicios;

public class P220102Ex4 {

  public static void main(String[] args) {
  }

  public static int soma(int n) {
    if (n > 0)
      return n + soma(n - 1);
    else
      return 0;
  }
}
