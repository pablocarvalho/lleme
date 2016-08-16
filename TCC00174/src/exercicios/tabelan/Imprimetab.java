/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.tabelan;

import java.util.Scanner;

/**
 *
 * @author Luiz Leme
 */
public class Imprimetab {

  Imprimetab() {
  }
  static Scanner teclado = new Scanner(System.in);

  public static void main() {
    int i, j;
    int n = teclado.nextInt();
    char[][] nen = new char[n][n];
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        if ((i == 0 || j == 0) && j != i)
          nen[i][j] = '*';
        else if (i % j == 0 || j % i == 0)
          nen[i][j] = '*';
        else
          nen[i][j] = ' ';
  }
}
