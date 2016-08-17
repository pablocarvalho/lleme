package exemplos.oo.metro;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Metro {

  private float[][] tempos;
  public String[] estacoes;

  public Metro(String arquivo) throws FileNotFoundException {
    InputStream input = new FileInputStream(arquivo);
    Scanner in = new Scanner(input);
    tempos = new float[80][80];
    estacoes = new String[80];
    int indice = 0, estacao1, estacao2;
    String estacao;

    while (in.hasNext()) {
      estacao = in.next();
      if ((estacao1 = buscaEstacao(estacao)) == -1)
        estacoes[estacao1 = indice++] = estacao;

      estacao = in.next();
      if ((estacao2 = buscaEstacao(estacao)) == -1)
        estacoes[estacao2 = indice++] = estacao;

      tempos[estacao1][estacao2] = in.nextFloat();
    }

    in.close();
  }

  public float tempoTrajeto(String[] trajeto) {
    float tempo = 0;
    String estacaoA, estacaoB;
    if (trajeto[0] != null) {
      estacaoA = trajeto[0];
      for (int i = 1; i < trajeto.length && trajeto[i] != null; i++) {
        estacaoB = trajeto[i];
        tempo = tempo + tempos[buscaEstacao(estacaoA)][buscaEstacao(estacaoB)];
        estacaoA = estacaoB;
      }
    }
    return tempo;
  }

  private int buscaEstacao(String estacao) {
    for (int i = 0; i < estacoes.length && estacoes[i] != null; i++)
      if (estacoes[i].equals(estacao))
        return i;
    return -1;
  }
}
