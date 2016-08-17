package exercicios;

public class P320072Ex2 {

  public static void main(String[] args) {
    System.out.println(secante(1, 2, 1E-6f));
  }

  public static float f(float x) {
    return x * x;
  }

  public static float secante(float x0, float x1, float tol) {
    float x2 = x1 - ((x1 - x0) / (f(x1) - f(x0)) * f(x1));
    while (f(x2) > tol) {
      x2 = x1 - ((x1 - x0) / (f(x1) - f(x0)) * f(x1));
      x0 = x1;
      x1 = x2;
    }
    return x2;
  }
}
