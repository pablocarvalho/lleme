package uff.ic.lleme.tcc00173.exemplos;

import java.util.Scanner;

public class Punicao {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    float a, b, c, d, P, Media, mediaFinal;
    System.out.println("Insira a primeira nota");
    a = in.nextFloat();
    System.out.println("Insira a segunda nota");
    b = in.nextFloat();
    System.out.println("Insira a terceira nota");
    c = in.nextFloat();
    System.out.println("Insira a quarta nota");
    d = in.nextFloat();
    Media = (a + b + c + d) / 4;
    System.out.println("Insira a % da puni��o");
    P = in.nextFloat();
    mediaFinal = (100 - P) * Media / 100;
    if (P < 80)
      System.out.println("Media final �" + mediaFinal);
    else
      System.out.println("o programa n�o pode ser executado corretamente");
  }
}
