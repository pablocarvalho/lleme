package exercicios;

import java.util.Scanner;

public class Lista2Ex10 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(hn(n));
  }

  private static float hn(int n) {
    float hn = 0;
    for (int i = 1; i <= n; i++)
      hn += 1 / i;
    return hn;
  }
}
