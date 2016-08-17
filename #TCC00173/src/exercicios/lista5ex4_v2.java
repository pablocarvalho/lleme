package exercicios;

import java.util.Scanner;

public class lista5ex4_v2 {

  public static void main(String[] args) {
    Scanner n = new Scanner(System.in);
    System.out.println("Entre com os valores");
    float a = n.nextFloat();
    float b = n.nextFloat();
    for (int i = 0; i < 10; i++) {
      float xi = a + i * (b - a) / 10;

      float resultado = f(xi);
      System.out.println(xi + "," + resultado);
    }
  }

  public static float f(float x) {
    float f;
    f = (float) (Math.pow(x, 3) - Math.pow(x, 2) + x - 1);
    return f;
  }
}
