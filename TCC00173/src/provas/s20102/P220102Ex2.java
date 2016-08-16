package provas.s20102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P220102Ex2 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("entrada2.txt");
    Scanner in = new Scanner(input);
    Scanner scanner = new Scanner(System.in);
    float[] histograma = new float[scanner.nextInt()];

    int qtd = 0;
    while (in.hasNext()) {
      histograma[faixa(histograma.length, in.nextInt())]++;
      qtd++;
    }
    for (int i = 0; i < histograma.length; i++)
      System.out.println("[" + i * 1000 / histograma.length + "-" + (i + 1) * 1000 / histograma.length + "] -> " + histograma[i] / qtd * 100 + "%");

    in.close();
  }

  public static int faixa(int n, int numero) {
    for (int i = 0; i < n - 1; i++)
      if (numero >= i * 1000 / n && numero < (i + 1) * 1000 / n)
        return i;
    return n - 1;
  }
}
