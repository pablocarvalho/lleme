package provas.s20111;

import java.util.Scanner;

public class P120111Ex3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite um número inteiro");
    int dias = in.nextInt();

    System.out.println(dias / 7 + " semanas");
    System.out.println(dias % 7 + " dias");
  }
}
