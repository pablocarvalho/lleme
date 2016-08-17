/*
 * Escreva uma func~ao que receba como par^ametro um numero inteiro n, com
 * n > 1, e retorne seu maior divisor d, onde d < n.
 */
package exercicios;

public class P120071Ex4 {

  public static void main(String[] args) {
    int d, n = 75;
    d = n - 1;
    while (n % d != 0)
      d--;
    System.out.println(d);
  }
}
