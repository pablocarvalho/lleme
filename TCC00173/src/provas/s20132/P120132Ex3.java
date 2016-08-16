package provas.s20132;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P120132Ex3 {

  public static void main(String[] args) {
    int soma, cont, num, n;
    Scanner in = new Scanner(System.in);
    System.out.println("Digite um numero");
    n = in.nextInt();
    try (OutputStream output = new FileOutputStream("saida.txt", true);
         OutputStreamWriter writer = new OutputStreamWriter(output);
         BufferedWriter arq2 = new BufferedWriter(writer);
         InputStream input = new FileInputStream("entrada.txt");
         Scanner arq1 = new Scanner(input);) {
      soma = 0;
      cont = 0;
      while (arq1.hasNext()) {
        num = arq1.nextInt();
        if (num % n == 0) {
          arq2.write("" + num);
          soma = soma + num;
          cont = cont + 1;
        }
      }
      System.out.println(soma / cont);
    } catch (Throwable ex) {
      Logger.getLogger(P120132Ex3.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
