package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P220102Ex2_2 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    int[] vet = leArquivo("./dat/dados.txt");
    float[] histograma;
    histograma = histograma(vet, 20);
    for (int i = 0; i < histograma.length; i++)
      System.out.println(histograma[i]);
  }

  public static int[] leArquivo(String nomeArq) throws FileNotFoundException, IOException {
    int[] vet;
    try (InputStream is = new FileInputStream(nomeArq)) {
      Scanner in = new Scanner(is);
      vet = new int[10000];
      int i = 0;
      while (in.hasNext())
        vet[i++] = in.nextInt();
    }
    return vet;
  }

  public static float[] histograma(int[] vet, int faixas) {
    float[] histograma = new float[faixas];
    float delta = 1000 / faixas;

    int faixa = 0;
    for (int i = 0; i < vet.length; i++) {
      faixa = (int) (vet[i] / delta);
      if (faixa == faixas)
        faixa--;
      histograma[faixa]++;
    }

    for (int i = 0; i < histograma.length; i++)
      histograma[i] /= vet.length;
    return histograma;
  }
}
