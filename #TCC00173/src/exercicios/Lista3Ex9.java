package exercicios;

import java.util.Scanner;

public class Lista3Ex9 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o primeiro peso:");
    int peso1 = in.nextInt();
    System.out.println("Digite o segundo peso:");
    int peso2 = in.nextInt();
    System.out.println("digite a primeira nota");
    float nota1 = in.nextFloat();
    System.out.println("digite a segunda nota:");
    float nota2 = in.nextFloat();
    System.out.println("sua média ponderada é:" + mediaPonderada(peso1, peso2, nota1, nota2));
  }

  static float mediaPonderada(int peso1, int peso2, float nota1, float nota2) {
    return (peso1 * nota1 + peso2 * nota2) / (peso1 + peso2);

  }
}
