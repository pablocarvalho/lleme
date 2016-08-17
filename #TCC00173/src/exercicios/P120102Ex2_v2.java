package exercicios;

import java.util.Scanner;

public class P120102Ex2_v2 {

  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    System.out.println("Entre os dados");
    float saldo1 = leitor.nextFloat();
    float juros1 = leitor.nextFloat();
    float saldo2 = leitor.nextFloat();
    float juros2 = leitor.nextFloat();

    int meses = 0;
    while (saldo1 <= saldo2) {
      saldo1 = novoSaldo(saldo1, juros1);
      saldo2 = novoSaldo(saldo2, juros2);
      meses++;
    }
    System.out.println(meses);
  }

  public static float novoSaldo(float saldo, float juros) {
    return saldo * (1 + juros);
  }
}
