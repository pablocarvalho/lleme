package provas.s20121;

import java.util.Scanner;

public class P120121Ex3 {

  public static void main(String[] args) {
    float n1, n2;
    String operacao;
    Scanner in = new Scanner(System.in);
    System.out.println("Deseja calcular?");
    String continua = in.next();
    while (continua.equals("Sim")) {
      System.out.println("Informe o primeiro operando.");
      n1 = in.nextFloat();
      do {
        System.out.println("Informe a operação.");
        operacao = in.next();
      } while (!operacao.equals("+") && !operacao.equals("-") && !operacao.equals("*") && !operacao.equals("/"));
      System.out.println("Informe o segundo operando.");
      n2 = in.nextFloat();
      switch (operacao) {
        case "+":
          System.out.println("Resultado = " + (n1 + n2));
          break;
        case "-":
          System.out.println("Resultado = " + (n1 - n2));
          break;
        case "*":
          System.out.println("Resultado = " + (n1 * n2));
          break;
        case "/":
          System.out.println("Resultado = " + (n1 / n2));
          break;
      }

      System.out.println("Deseja calcular?");
      continua = in.next();
    }
    System.out.println("O programa terminou!");
  }
}
