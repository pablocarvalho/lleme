
import java.util.Scanner;

public class Newton {

  public static void main(String[] args) {
    double tol = 1E-4;
    Scanner in = new Scanner(System.in);
    double t0 = in.nextDouble();
    System.out.println(newton(t0, tol));
  }

  public static double newton(double ti, double tol) {
    double ti1 = ti;
    do {
      ti = ti1;
      ti1 = ti - f(ti) / derF(ti);
    } while (Math.abs(ti1 - ti) > tol);
    return ti1;
  }

  public static double f(double x) {
    return Math.pow(x, 2) - 10;
  }

  public static double derF(double x) {
    return 2 * x;
  }
}
