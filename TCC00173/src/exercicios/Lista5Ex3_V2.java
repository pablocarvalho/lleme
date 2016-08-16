package exercicios;

import java.util.Scanner;

public class Lista5Ex3_V2 {

  public static void main(String[] args) {

    Scanner tecl = new Scanner(System.in);
    System.out.println("Quantas valores?");
    int n = 0;
    float media = 0;
    n = tecl.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println("Digite um valor");
      media += tecl.nextFloat();
    }
    media /= n;
    System.out.println(media);
  }
}
