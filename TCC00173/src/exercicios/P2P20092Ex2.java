/*
 * Escreva um programa que decomponha um número inteiro positivo em produtos de
 * seus fatores primos. Por exemplo, quando informado o número 756, o programa
 * deverá escrever 756 = 2^2 * 3^3 * 7. Para isso, defina as seguintes funções:
 *
 * //Retorma 1 se n for primo e 0 se não for
 * public static int ePrimo(int n);
 *
 * //Dado um número n e um fator primo, retorna o expoente do fator primo.
 * //Por exemplo, dados o número 756 e o fator primo 2 a função deverá retornar
 * //2.
 * public static int expoente(int n,int fator);
 */
package exercicios;

import java.util.Scanner;

public class P2P20092Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, e = 0;
    System.out.println("Digite um Numero");
    n = in.nextInt();

    for (int i = 2; i <= n; i++)
      if (ePrimo(i)) {
        e = expoente(n, i);
        if (e != 0) {
          System.out.print(i + "^" + e + "*");
          n = n / (int) Math.pow(i, e);
        }
      }
  }

  public static int expoente(int n, int fator) {
    int e = 0;
    while ((n % fator) == 0) {
      e++;
      n = n / fator;
    }
    return e;
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
