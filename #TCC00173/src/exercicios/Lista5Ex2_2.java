package exercicios;

import java.util.Scanner;

public class Lista5Ex2_2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numero;
    System.out.println("Digite um Numero: ");
    numero = in.nextInt();

    while (numero <= 0) {
      System.out.println("ERRO");
      System.out.println("Digite um Numero: ");
      numero = in.nextInt();
    }

    for (int x = 1; x <= numero; x++)
      if ((numero % x) == 0)
        System.out.println(x);

  }
}
