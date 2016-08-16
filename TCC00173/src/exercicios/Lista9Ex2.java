package exercicios;

public class Lista9Ex2 {

  public static void main(String[] args) {
    System.out.println(prodN(6));
    System.out.println(6 * 5 * 4 * 3 * 2);
  }

  public static int prodN(int n) {
    if (n == 1)
      return 1;
    return n * prodN(n - 1);
  }
}
