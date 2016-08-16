package exercicios;

public class P220071ex3_v2 {

  public static void main(String[] args) {
    for (int i = 1; i < 11; i++)
      System.out.println(i + "\t" + integral(2, 10, (int) Math.pow(10, i)));
  }

  public static double f(double x) {
    return x * x + 3 * x;

  }

  public static double integral(double xa, double xb, int n) {
    double dx = (xb - xa) / n;
    double area = 0;
    for (int i = 0; xa + i * dx < xb; i++)
      area += f(xa + i * dx) * dx;
    return area;

  }
}
