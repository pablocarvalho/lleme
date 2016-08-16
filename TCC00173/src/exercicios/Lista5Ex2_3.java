package exercicios;

import java.util.Scanner;

public class Lista5Ex2_3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n;
    do {
      System.out.println("mensagem");
      n = in.nextInt();
    } while (n <= 2);

    int contador = 0;
    for (int divisor = n - 1; divisor > 1; divisor--)
      if ((n % divisor) == 0) {
        System.out.println(divisor);
        contador++;
      }
    if (contador == 0)
      System.out.println("nenhum divisor");
    else
      System.out.println(contador + " divisores");
  }
}
