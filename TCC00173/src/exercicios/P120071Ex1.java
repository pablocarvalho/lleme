package exercicios;

import java.util.Scanner;

public class P120071Ex1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o número de dias");
    int dias = in.nextInt();
    int semana = dias / 7;
    int dias2 = dias % 7;

    System.out.println(semana + " semanas ");


  }
}
