package exercicios;

import java.util.Scanner;

public class Lista5Ex4_2 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Entre com o primeiro valor para o intervalo:");
    float a = input.nextFloat();
    System.out.println("Entre com o segundo valor para o intervalo:");
    float b = input.nextFloat();
    float xi;

    for (int i = 0; i < 10; i++) {
      xi = a + i * (b - a) / 10;
      System.out.println("O resultado de fx e" + fx(xi));
    }
  }

  public static float fx(float xi) {
    float fxi = xi * xi + xi - 1;
    return fxi;
  }
}
