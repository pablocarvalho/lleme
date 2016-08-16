package exercicios;

public class P320072Ex2_2 {

  public static void main(String[] args) {
    double x0 = 0, x1 = 1, xn, tol = 1e-6;
    do {
      xn = x1 - (x1 - x0) / (f(x1) - f(x0)) * f(x1);
      x0 = x1;
      x1 = xn;
    } while (Math.abs(x1 - x0) >= tol);
    System.out.println(x1);
  }

  public static double f(double x) {
    return 0;
  }
}
