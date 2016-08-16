package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P220102Ex3 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("");
    Scanner in = new Scanner(input);
    String inicio = null, fim = null;
    float tempoPercurso = 0;
    float[][] tempos = null;
    String[] estacoes = null;
    if (in.hasNext())
      inicio = in.next();
    while (in.hasNext()) {
      fim = in.next();
      tempoPercurso += tempo_percurso(inicio, fim, tempos, estacoes);
      inicio = fim;
    }
    input.close();
  }

  public static float tempo_percurso(String inicio, String fim, float[][] mat, String[] vet) {
    int posicao1, posicao2;
    posicao1 = busca_estacao(inicio, vet);
    posicao2 = busca_estacao(fim, vet);
    return mat[posicao1][posicao2];
  }

  public static int busca_estacao(String estacao, String[] vet) {
    for (int i = 0; i < vet.length; i++)
      if (vet[i].equals(estacao))
        return i;
    return -1;

  }

  public static int guarda_estacao(String[] vet, String estacao) {
    int i;
    for (i = 0; i < vet.length && vet[i] != null; i++)
      if (vet[i].equals(estacao))
        return i;
    if (i < vet.length) {
      vet[i] = estacao;
      return i;
    } else
      return -1;
  }
}
