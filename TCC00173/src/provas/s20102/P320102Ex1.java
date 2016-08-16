package provas.s20102;

import java.util.Scanner;

public class P320102Ex1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero, soma = 0;
    do {
      numero = scanner.nextInt();
      if (numero >= 0) {
        if (ePrimo(numero))
          soma += numero;
      } else if (numero != -1)
        System.out.println("numero negativo");
    } while (numero != -1);
    if (soma != 0)
      System.out.println("soma=" + soma);
    else
      System.out.println("Nenhum primo informado");
  }

  public static boolean ePrimo(int n) {
    if ((n % 2 == 0 && n > 2) || n == 1)
      return false;
    for (int i = 2; i <= Math.sqrt(n); i++)
      if ((n % i) == 0)
        return false;
    return true;
  }
}
