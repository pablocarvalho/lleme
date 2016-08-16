package exercicios;

import java.util.Scanner;

public class P120082Ex4 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //int numero = in.nextInt();
    //System.out.println(ePerfeito(numero));
    int qtd = 0;
    int n = 1;
    while (qtd < 5) {
      if (ePerfeito(n)) {
        System.out.println(n);
        qtd++;
      }
      n++;
    }
  }

  public static boolean ePerfeito(int n) {
    int soma = 0;
    for (int i = 1; i <= (n / 2); i++)
      if (n % i == 0)
        soma += i;
    if (soma == n)
      return true;
    return false;
  }
}
