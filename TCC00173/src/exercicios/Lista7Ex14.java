package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lista7Ex14 {

  public static void main(String[] args) {
    int[] dados = leDados("./dat/dados.txt");
    int[] hist = histograma(dados);
    imprime(hist);
  }

  public static int[] leDados(String arquivo) {
    int cont = 0;
    int valor = 0;
    int[] dados = new int[200];
    try (InputStream input = new FileInputStream(arquivo);) {
      Scanner in = new Scanner(input);
      while (in.hasNext() && cont < 200)
        dados[cont++] = in.nextInt();
      if (cont < 200)
        dados[cont] = -1;

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Lista7Ex14.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Lista7Ex14.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dados;
  }

  public static int[] histograma(int[] dados) {
    int[] hist = new int[7];
    int i = 0;
    while (dados[i] != -1)
      hist[dados[i++]]++;
    return hist;
  }

  private static void imprime(int[] hist) {
    for (int i = 0; i < hist.length; i++)
      System.out.println(decodificarGrau(i) + ":\t" + criarBarra(hist[i]));
  }

  private static String decodificarGrau(int codigo) {
    String[] nome = {"Analfabeto", "Primeiro grau",
      "Segundo grau", "Superior", "Mestrado", "Doutorado",
      "Outros     "};
    return nome[codigo];
  }

  private static String criarBarra(int qtd) {
    String barra = "";
    for (int i = 0; i < qtd; i++)
      barra += "*";
    return barra;
  }
}
