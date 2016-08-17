package exercicios.p320102ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Disciplina {

  public int qtdAvaliacoes = 0;
  public Avaliacao[] avaliacoes;

  public void initNotasTrabalho(String arqTrablho) throws FileNotFoundException, IOException {
    InputStream is = new FileInputStream("");
    Scanner in = new Scanner(is);
    Avaliacao avaliacao;
    String matricula;
    while (in.hasNext()) {
      matricula = in.next();
      avaliacao = busca(matricula);
      if (avaliacao == null) {
        avaliacao = new Avaliacao();
        avaliacoes[qtdAvaliacoes++] = avaliacao;
        avaliacao.matricula = matricula;
      }
      avaliacao.trabalho = in.nextFloat();
    }
    is.close();
  }

  public void intNotasP3(String arqP3) throws FileNotFoundException, IOException {
    InputStream is = new FileInputStream("");
    Scanner in = new Scanner(is);
    Avaliacao avaliacao;
    String matricula;
    while (in.hasNext()) {
      matricula = in.next();
      avaliacao = busca(matricula);
      if (avaliacao == null) {
        avaliacao = new Avaliacao();
        avaliacoes[qtdAvaliacoes++] = avaliacao;
        avaliacao.matricula = matricula;
      }
      avaliacao.p3 = in.nextFloat();
    }
    is.close();

  }

  private Avaliacao busca(String matricula) {
    for (int i = 0; i < avaliacoes.length && avaliacoes[i] != null; i++)
      if (avaliacoes[i].matricula.equals(matricula))
        return avaliacoes[i];
    return null;
  }

  public void imprimeMedia() {
    for (int i = 0; i < avaliacoes.length && avaliacoes[i] != null; i++)
      System.out.println(avaliacoes[i].media());
  }
}
