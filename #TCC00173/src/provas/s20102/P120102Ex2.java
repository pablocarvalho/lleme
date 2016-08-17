package provas.s20102;

import java.util.Scanner;

public class P120102Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double capital1, taxa1, capital2, taxa2;
    int meses;
    System.out.println("Entre com os valores valores");

    capital1 = in.nextDouble();
    taxa1 = in.nextDouble();
    capital2 = in.nextDouble();
    taxa2 = in.nextDouble();

    if (taxa1 > taxa2) {
      meses = 0;
      while (capital1 < capital2) {
        capital1 = novoSaldo(capital1, taxa1);
        capital2 = novoSaldo(capital2, taxa2);
        meses++;
      }
      if (meses == 0)
        System.out.println("Os capitais ja sao iguais");
      else
        System.out.println("Sao necessarios " + meses + " mes(es)");
    } else
      System.out.println("Nao e possivel a aproximacao");
  }

  public static double novoSaldo(double saldo, double juros) {
    return saldo * (1 + juros / 100);
  }
}
