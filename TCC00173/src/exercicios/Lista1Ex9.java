package exercicios;

import java.util.Scanner;

public class Lista1Ex9 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double nota1, nota2;
    int peso1, peso2, matricula;
    System.out.println("Insira a matricula do aluno");
    matricula = in.nextInt();
    System.out.println("Insira a primeira nota do aluno");
    nota1 = in.nextDouble();
    System.out.println("Insira a segunda nota do aluno");
    nota2 = in.nextDouble();
    System.out.println("Insira o peso da primeira prova");
    peso1 = in.nextInt();
    System.out.println("Insira o peso da segunda prova");
    peso2 = in.nextInt();
    System.out.println("A média é igual a " + mediaPonderada(nota1, peso1, nota2, peso2));

  }

  public static double mediaPonderada(double nota1, int peso1, double nota2, int peso2) {
    double media;
    media = (nota1 * peso1 + nota2 * peso2) / (peso1 + peso2);
    return media;
  }
}
