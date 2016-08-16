package exercicios;

import java.util.Scanner;

public class Lista5Ex6 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    float nota1, nota2, nota3, nota4, penalidade, media;
    int flag = 0;

    System.out.println("existem mais notas");
    flag = in.nextInt();
    while (flag != -1) {
      System.out.println("n1");
      nota1 = in.nextFloat();
      System.out.println("n2");
      nota2 = in.nextFloat();
      System.out.println("n3");
      nota3 = in.nextFloat();
      System.out.println("n4");
      nota4 = in.nextFloat();
      System.out.println("penalidade");
      penalidade = in.nextFloat();

      media = (100 - penalidade) / 100 * (nota1 + nota2 + nota3 + nota4) / 4;
      System.out.println(media);
      System.out.println("existem mais notas");
      flag = in.nextInt();
    }


  }
}
