package exercicios;

import java.util.Scanner;

public class Lista5Ex10 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Hello world");
    System.out.println("Digite um numero:");
    int n = in.nextInt();
    System.out.println(harmonica(n));
  }

  public static float harmonica(int n) {
    float somatorio = 0;
    for (int i = 1; i <= n; i++)
      somatorio += 1.0 / i;
    return somatorio;
  }
}
