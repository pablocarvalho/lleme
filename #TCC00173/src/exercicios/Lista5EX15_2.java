package exercicios;

import java.util.Scanner;

public class Lista5EX15_2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 0, soma = 0;
    do {
      System.out.println("Digite um número");
      n = in.nextInt();
      if (n >= 0)
        soma = n + soma;
    } while (n != 0);
    System.out.println(soma);

  }
}
