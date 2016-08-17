package exemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Histograma {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    int n;
    float hist[] = new float[5];
    float notas[] = new float[50];

    n = ler("entrada.txt", 50, notas);
    histograma(n, notas, 0.0f, 10.0f, 5, hist);

    System.out.println("Histograma calculado:");
    for (int i = 0; i < 5; i++)
      System.out.println(hist[i]);
  }

  public static void histograma(int n, float notas[], float min, float max, int ni, float h[]) {
    int i, j;
    float delta = (max - min) / ni;
    /* inicializa vetor de histograma */
    for (i = 0; i < ni; i++)
      h[i] = 0;
    /* calcula número de ocorrências em cada intervalo */
    for (j = 0; j < n; j++) {
      i = (int) ((notas[j] - min) / delta);
      if (i == ni)
        i = ni - 1;
      h[i]++;
    }
    /* calcula freqüência */
    for (i = 0; i < ni; i++)
      h[i] = h[i] / n;
  }

  public static int ler(String arquivo, int max, float[] notas) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream(arquivo);
    Scanner in = new Scanner(input);
    int qtd = 0;
    while (in.hasNext() && qtd < max) {
      notas[qtd] = in.nextFloat();
      qtd++;
    }
    input.close();
    return qtd;
  }
}
