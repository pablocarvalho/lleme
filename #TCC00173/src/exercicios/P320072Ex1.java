package exercicios;

public class P320072Ex1 {

  public static void main(String[] args) {
    System.out.println(trapezio(-1, 1, 100));
  }

  public static float f(float x) {
    return x * x;
  }

  public static float trapezio(float a, float b, int n) {
    float xi, xi1;
    float soma = 0;
    float h = (b - a) / n;
    for (int i = 0; i < n; i++) {

      xi = a + i * h;
      xi1 = a + (i + 1) * h;
      soma += (f(xi) + f(xi1)) * h / 2;
    }





    return soma;
  }
}
