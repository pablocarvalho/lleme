package exemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Vetores {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    int qtd;
    float media, var, notas[];

    notas = new float[50];
    qtd = ler("entrada.txt", 50, notas);
    media = media(qtd, notas);
    var = variancia(qtd, notas, media);
    System.out.println("media=" + media);
    System.out.println("variancia=" + var);
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

  public static float media(int qtd, float[] notas) {
    float media = 0;
    for (int i = 0; i < qtd; i++)
      media = media + notas[i];
    media = media / qtd;
    return media;
  }

  public static float variancia(int qtd, float[] notas, float media) {
    float var = 0;
    for (int i = 0; i < qtd; i++)
      var = var + ((float) Math.pow(notas[i] - media, 2));
    var = var / qtd;
    return var;
  }
}
