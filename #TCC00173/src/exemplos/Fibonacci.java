package exemplos;

public class Fibonacci {

  public static void main(String[] args) throws Exception {
    System.out.println(fibonacci(7));
  }

  public static int fibonacci(int n) throws IllegalAccessException {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else if (n > 1)
      return fibonacci(n - 1) + fibonacci(n - 2);
    else
      throw new IllegalAccessException("A funcao fibonacci não é definida "
              + "para números negativos");
  }
}
