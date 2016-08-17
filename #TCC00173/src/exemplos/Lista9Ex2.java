package exemplos;

/**
 *
 * @author Luiz Leme
 */
public class Lista9Ex2 {

  public static void main(String[] args) {
    System.out.println(produto(5));
  }

  public static int produto(int n) {
    if (n == 1)
      return 1;
    else
      return n * produto(n - 1);
  }
}
