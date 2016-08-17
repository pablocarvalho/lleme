/*
 * Usando o comando do-while, escreva um programa em C que receba uma sequencia
 * de numeros inteiros. Seu programa deve parar de receber uma entrada no
 * momento que o usuario entrar com o valor 0. A saida do seu programa deve
 * ser o somatorio dos valores fornecidos na entrada.
 *
 */
package exercicios;

import java.util.Scanner;

public class Lista5Ex15 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = 0, soma = 0;
    do {
      System.out.print("Digite um número");
      x = in.nextInt();
      soma = x + soma;
    } while (x != 0);
    System.out.println("A soma dos numeros digitados é " + soma);
  }
}
