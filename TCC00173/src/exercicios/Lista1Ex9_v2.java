package exercicios;

import java.util.Scanner;

public class Lista1Ex9_v2 {

  public static void main(String[] args) {

    Scanner leitor = new Scanner(System.in);
    System.out.println("Digite nota P1");
    float p1 = leitor.nextFloat();
    System.out.println("Digite nota P2");
    float p2 = leitor.nextFloat();
    System.out.println("Digite nota P3");
    float p3 = leitor.nextFloat();


    float media = (p1 + p2 + p3) / 3;
    if (media >= 5.0)
      System.out.println("Aluno aprovado");
    else {
      System.out.println("Digite nota P4");
      float p4 = leitor.nextFloat();
      media = (media + p4) / 2;
      if (media >= 5)
        System.out.println("Aluno aprovado");
      else
        System.out.println("Aluno reprovado");
    }


  }
}
