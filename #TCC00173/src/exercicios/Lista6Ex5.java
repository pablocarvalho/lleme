/*
 * Escreva um programa em C que l^e um arquivo com numeros reais (um numero
 * por linha)e grava outro arquivo onde cada linha mostra o valor do respectivo
 * numero aplicado a funcao f(x) = ax3 + bx2 + cx + d, onde a, b, c e d sao
 * lidos do teclado.
 */
package exercicios;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Lista6Ex5 {

  public static void main(String args[]) throws FileNotFoundException, IOException {
    OutputStream output = new FileOutputStream("saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    Scanner in = new Scanner(System.in);
    System.out.println("Digite o valor de a");
    double a = in.nextDouble();
    System.out.println("Digite o valor de b");
    double b = in.nextDouble();
    System.out.println("Digite o valor de c");
    double c = in.nextDouble();
    System.out.println("Digite o valor de d");
    double d = in.nextDouble();
    InputStream input = new FileInputStream("entrada.txt");
    Scanner on = new Scanner(input);
    while (on.hasNext())
      bw.write("" + f(a, b, c, d, on.nextDouble()) + "\n");
    bw.close();
    on.close();
  }

  public static double f(double a, double b, double c, double d, double x) {
    return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * Math.pow(x, 1) + d;
  }
}
