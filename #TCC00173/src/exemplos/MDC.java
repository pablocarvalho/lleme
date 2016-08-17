package exemplos;

public class MDC {

  public static void main(String[] args) {

    System.out.println(mdc(3 * 3 * 3 * 5 * 7, 3 * 3 * 5 * 6));
  }

  public static int mdc(int x, int y) {
    int resto = x % y;
    while (resto > 0) {
      x = y;
      y = resto;
      resto = x % y;
    }
    return y;
  }
}
