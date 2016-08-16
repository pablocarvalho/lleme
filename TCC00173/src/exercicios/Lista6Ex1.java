/*
 * Escreva um programa em C que le um numero n do teclado e gera um arquivo com
 * os n primeiros numeros primos.
 */
package exercicios;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Lista6Ex1 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    OutputStream output = new FileOutputStream("saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);
    Scanner in = new Scanner(System.in);
    System.out.println("Diga a quantidade de numeros primos");
    int n = in.nextInt();
    int contador = 0;
    int numero = 2;
    while (contador < n) {
      if (P2P20092Ex2.ePrimo(numero)) {
        contador++;
        bw.write("" + numero + "\n");
      }
      numero++;
    }
    bw.close();
  }
}
