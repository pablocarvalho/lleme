package exercicios;

public class P320072_ex2 {

  public static void main(String[] args) {
    System.out.println(raiz(-10, -20, 1E-4));
  }

  public static double raiz(double x0, double x1, double tol) {
    double x2 = 0;
    do {
      x2 = x1 - (x1 - x0) / (f(x1) - f(x0)) * f(x1);
      x0 = x1;
      x1 = x2;
    } while (Math.abs(x1 - x0) > tol);
    return x1;
  }

  private static double f(double x) {
    return 3 * x * x + x + 4;
  }
}
