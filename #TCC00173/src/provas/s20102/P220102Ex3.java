package provas.s20102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class P220102Ex3 {

  public static void main(String[] args) throws FileNotFoundException {

    InputStream input = new FileInputStream("entrada.txt");
    Scanner in = new Scanner(input);
    float[][] tempos = new float[80][80];
    String[] estacoes = new String[80];
    int indice = 0, codEst1, codEst2;
    String estacao;

    while (in.hasNext()) {
      estacao = in.next();
      if ((codEst1 = buscaEstacao(estacoes, estacao)) == -1)
        estacoes[codEst1 = indice++] = estacao;

      estacao = in.next();
      if ((codEst2 = buscaEstacao(estacoes, estacao)) == -1)
        estacoes[codEst2 = indice++] = estacao;

      float tempo = in.nextFloat();
      tempos[codEst1][codEst2] = tempo;
      tempos[codEst2][codEst1] = tempo;
    }

    in.close();

    input = new FileInputStream("trajeto.txt");
    in = new Scanner(input);
    float tempoTrajeto = 0;
    String estacaoA, estacaoB;
    if (in.hasNext()) {
      estacaoA = in.next();
      while (in.hasNext()) {
        estacaoB = in.next();
        tempoTrajeto += tempos[buscaEstacao(estacoes, estacaoA)][buscaEstacao(estacoes, estacaoB)];
        estacaoA = estacaoB;
      }
    }
    in.close();
    System.out.println(tempoTrajeto);
  }

  public static int buscaEstacao(String[] estacoes, String estacao) {
    for (int i = 0; i < estacoes.length && estacoes[i] != null; i++)
      if (estacoes[i].equals(estacao))
        return i;
    return -1;
  }
}
