package exercicios;

import java.util.Scanner;

public class Lista2Ex4 {

  public static void main(String[] args) {
    System.out.println("digite a: ");
    Scanner in = new Scanner(System.in);
    float a = in.nextFloat();
    System.out.println("digite b");
    float b = in.nextFloat();
    float xi = 0;

    for (int i = 0; i < 10; i++) {
      xi = a + i * (b - a) / 10;
      System.out.println(funcao(xi));
    }
  }

  public static float funcao(float xi) {
    return (float) (Math.pow(xi, 3) - Math.pow(xi, 2) + xi - 1);
  }
}