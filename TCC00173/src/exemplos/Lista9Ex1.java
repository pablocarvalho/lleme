package exemplos;

public class Lista9Ex1 {

  public static void main(String[] args) {
    System.out.println(soma(5));
  }

  public static int soma(int n) {
    if (n == 1)
      return 1;
    else
      return n + soma(n - 1);
  }
}
