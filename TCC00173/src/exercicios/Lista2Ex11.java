package exercicios;

import java.util.Scanner;

public class Lista2Ex11 {

  public static void main(String[] args) {
    Scanner ler = new Scanner(System.in);
    System.out.println("Digite n");
    int n = ler.nextInt();
    System.out.println("Digit k");
    int k = ler.nextInt();
    System.out.println(fat(n) / fat(n - k));
  }

  public static int fat(int n) {
    int fat = 1;
    for (int i = n; i > 1; i--)
      fat *= i;
    return fat;
  }
}
