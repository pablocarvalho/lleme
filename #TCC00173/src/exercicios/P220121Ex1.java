package exercicios;

public class P220121Ex1 {

  public static void main(String[] args) {
    int n = converte(12, 0);
    System.out.println(n);
  }

  private static int converte(int n, int i) {
    if (n < 2)
      return n;
    else
      return (n % 2) * ((int) Math.pow(10, i)) + converte(n / 2, i++);
  }
}
