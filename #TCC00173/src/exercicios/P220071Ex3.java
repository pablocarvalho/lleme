package exercicios;

public class P220071Ex3 {

  public static void main(String[] args) {
    double x0 = 0;
    double x1 = 1000;

    for (int intervalos = 100; intervalos < 100000; intervalos += 100)
      System.out.println(intervalos + " " + integral(intervalos, 0, 5));


  }

  public static double integral(int intervalos, double x0, double x1) {
    double area = 0;
    double delta = (x1 - x0) / intervalos;
    for (double x = x0; x <= x1 - delta; x += delta)
      area += f(x) * delta;
    return area;
  }

  public static double f(double x) {
    return 2 * x;
  }
}
