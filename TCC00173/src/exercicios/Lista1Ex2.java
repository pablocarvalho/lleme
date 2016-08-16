package exercicios;

import java.util.Scanner;

public class Lista1Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    float num1, num2;
    System.out.println("Por favor, insira o primeiro número: ");
    num1 = in.nextFloat();
    System.out.println("Por favor, insira o segundo número: ");
    num2 = in.nextFloat();
    if (num1 > num2)
      System.out.println(num1 + " é maior que " + num2);
    else if (num1 == num2)
      System.out.println(num1 + " é igual a " + num2);
    else
      System.out.println(num1 + " é menor que " + num2);


  }
}
