package uff.ic.lleme.tcc00173.exercicios;

import java.util.Scanner;

public class Lista5Ex3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Quantidade de n�meros");
    int n = in.nextInt();
    double num;
    double media = 0;
    for (int x = 0; x < n; x++) {
      System.out.println("Digite um dos n�meros");
      num = in.nextDouble();
      media = media + num;
    }
    System.out.println("M�dia: " + media / n);
  }
}
