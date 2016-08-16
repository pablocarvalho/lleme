package exercicios;

public class P120071Ex5 {

  public static void main(String[] args) {

    double tol = 0.3;
    double sum = 0;
    int n = 1;
    while (harmonica(n) > tol) {
      sum += harmonica(n);
      n++;
    }
    System.out.println(sum);
  }

  public static double harmonica(int n) {

    return 1.0 / n;
  }
}
