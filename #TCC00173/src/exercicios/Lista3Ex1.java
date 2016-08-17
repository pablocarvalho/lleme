package exercicios;

import java.util.Scanner;

public class Lista3Ex1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println(" digite valor ");
    int a = in.nextInt();
    System.out.println(" digite o outro valor");
    int b = in.nextInt();
    float media = media(a, b);
    System.out.println(" media = " + media);
  }

  static float media(int a, int b) {
    float media = (a + b) / 2;
    return media;


  }
}
