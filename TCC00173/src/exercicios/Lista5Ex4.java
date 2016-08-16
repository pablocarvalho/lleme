package exercicios;

public class Lista5Ex4 {

  public static void main(String[] args) {
    float a = 2.0f, b = 7.0f, xi;

    for (int i = 0; i <= 10; i++) {
      xi = a + (b - a) / 10 * i;
      System.out.println(f(xi));
    }
  }

  public static float f(float x) {
    int a = 3;
    return (float) Math.pow(x, 3) - x * x + x - 1;
  }
}
