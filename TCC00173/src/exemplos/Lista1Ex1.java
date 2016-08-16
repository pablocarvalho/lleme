package exemplos;

import java.util.Scanner;

public class Lista1Ex1 {

  public static void main(String[] args) {
    int numero1, numero2;
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o primeiro numero: ");
    numero1 = in.nextInt();
    System.out.println("Digite o segundo numero: ");
    numero2 = in.nextInt();
    System.out.println("A soma é: " + (numero1 + numero2));
    System.out.println("A diferença é: " + (numero1 - numero2));
    System.out.println("O produto é: " + numero1 * numero2);
    if (numero2 == 0)
      System.out.println("A divisão nao pode ser feita");
    else {
      System.out.println("O quociente é: " + numero1 / numero2);
      System.out.println("O resto é: " + numero1 % numero2);
    }
  }
}