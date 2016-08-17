package exercicios;

public class Lista9Ex1 {

  public static void main(String[] args) {
    System.out.println(somaN(5));
  }

  public static int somaN(int n) {
    if (n == 1)
      return 1;
    return n + somaN(n - 1);
  }
}
