package uff.ic.lleme.tcc00173.exercicios;

import java.util.Scanner;

public class Lista2Ex6 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite a 1� nota");
    float nota1 = in.nextFloat();
    System.out.println("Digite a 2� nota");
    float nota2 = in.nextFloat();
    System.out.println("Digite a 3� nota");
    float nota3 = in.nextFloat();
    System.out.println("Digite a 4� nota");
    float nota4 = in.nextFloat();
    System.out.println("Digite a penalidade");
    float penalidade = in.nextFloat();
    float notaFinal;

    notaFinal = (100 - penalidade) * media(nota1, nota2, nota3, nota4) / 100;

    System.out.println(notaFinal);

  }

  public static float media(float nota1, float nota2, float nota3, float nota4) {
    return (nota1 + nota2 + nota3 + nota4) / 4;
  }
}
