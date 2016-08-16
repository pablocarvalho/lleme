package provas.s20102.p320102ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Disciplina {

  public Avaliacao[] avaliacoes;
  public int qtdAvaliacoes = 0;

  public Disciplina() {
    avaliacoes = new Avaliacao[10];
  }

  public void initNotasTrabalho(String arqTrabalho) throws FileNotFoundException {
    InputStream input = new FileInputStream(arqTrabalho);
    Scanner in = new Scanner(input);
    Avaliacao avaliacao;
    String matricula;
    while (in.hasNext()) {
      matricula = in.next();
      avaliacao = getAvaliacao(matricula);
      if (avaliacao == null) {
        avaliacao = new Avaliacao(matricula);
        avaliacoes[qtdAvaliacoes++] = avaliacao;
      }
      avaliacao.trabalho = in.nextFloat();
    }
    in.close();
  }

  public void initNotasP3(String arqTrabalho) throws FileNotFoundException {
    InputStream input = new FileInputStream(arqTrabalho);
    Scanner in = new Scanner(input);
    Avaliacao avaliacao;
    String matricula;
    while (in.hasNext()) {
      matricula = in.next();
      avaliacao = getAvaliacao(matricula);
      if (avaliacao == null) {
        avaliacao = new Avaliacao(matricula);
        avaliacoes[qtdAvaliacoes++] = avaliacao;
      }
      avaliacao.p3 = in.nextFloat();
    }
    in.close();
  }

  private Avaliacao getAvaliacao(String matricula) {
    for (int i = 0; i < qtdAvaliacoes; i++)
      if (avaliacoes[i].matricula.equals(matricula))
        return avaliacoes[i];
    return null;
  }

  private void addAvaliacao(Avaliacao avaliacao) {
    avaliacoes[qtdAvaliacoes++] = avaliacao;
  }
}
