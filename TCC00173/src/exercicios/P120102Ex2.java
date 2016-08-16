package exercicios;

import java.util.Scanner;

public class P120102Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o valor do primeiro investimento: ");
    double invest1 = in.nextDouble();
    System.out.println("Digite a primeira taxa de juros: ");
    double juros1 = in.nextDouble();
    System.out.println("Digite o valor do segundo investimento: ");
    double invest2 = in.nextDouble();
    System.out.println("Digite a segunda taxa de juros: ");
    double juros2 = in.nextDouble();


    if (juros1 > juros2) {
      int m = 0;
      while (invest1 <= invest2) {
        invest1 = novoSaldo(invest1, juros1);
        invest2 = novoSaldo(invest2, juros2);
        m++;
        //m=m+1;
      }
      System.out.println("Demoram " + m + " meses para que invest1 > invest2");
    } else
      System.out.println("O primeiro juros deve ser maior!");

  }

  public static double novoSaldo(double saldo, double juros) {
    // saldo=invest1; no momento da invocaçao.
    // juros=juros1; no momento da invocaçao.
    return saldo * (1 + juros);
  }
}
