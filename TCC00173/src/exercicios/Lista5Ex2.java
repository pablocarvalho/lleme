package exercicios;

import java.util.Scanner;

public class Lista5Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o numero: ");
    int a;
    a = in.nextInt();
    for (int divisor = 1; divisor <= a; divisor++)
      if ((a % divisor) == 0)
        System.out.println(divisor);


  }
}
