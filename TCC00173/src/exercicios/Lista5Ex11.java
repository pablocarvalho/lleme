package exercicios;

import java.util.Scanner;

public class Lista5Ex11 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("digite n");
    int n = in.nextInt();
    System.out.println("digite k");
    int k = in.nextInt();
    System.out.println(fatorial(n) / fatorial(n - k));
  }

  public static int fatorial(int n) {
    int produtorio = 1;
    for (int i = 1; i <= n; i++)
      produtorio *= i;
    return produtorio;


  }
}
