package uff.ic.lleme.tcc00173.exemplos;

import java.util.Scanner;

public class Lista1Ex1 {

  public static void main(String[] args) {
    int numero1, numero2;
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o primeiro numero: ");
    numero1 = in.nextInt();
    System.out.println("Digite o segundo numero: ");
    numero2 = in.nextInt();
    System.out.println("A soma �: " + (numero1 + numero2));
    System.out.println("A diferen�a �: " + (numero1 - numero2));
    System.out.println("O produto �: " + numero1 * numero2);
    if (numero2 == 0)
      System.out.println("A divis�o nao pode ser feita");
    else {
      System.out.println("O quociente �: " + numero1 / numero2);
      System.out.println("O resto �: " + numero1 % numero2);
    }
  }
}