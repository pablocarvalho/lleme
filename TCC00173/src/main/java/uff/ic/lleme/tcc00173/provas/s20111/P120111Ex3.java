package uff.ic.lleme.tcc00173.provas.s20111;

import java.util.Scanner;

public class P120111Ex3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite um n�mero inteiro");
    int dias = in.nextInt();

    System.out.println(dias / 7 + " semanas");
    System.out.println(dias % 7 + " dias");
  }
}
