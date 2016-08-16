package provas.s20102.p320102ex2;

import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    Disciplina disciplina = new Disciplina();
    disciplina.initNotasTrabalho("notasT.txt");
    disciplina.initNotasP3("notasP3.txt");
    for (int i = 0; i < disciplina.qtdAvaliacoes; i++)
      System.out.println(disciplina.avaliacoes[i].matricula + ", "
              + disciplina.avaliacoes[i].p3 + ", "
              + disciplina.avaliacoes[i].trabalho + ", "
              + disciplina.avaliacoes[i].getMedia());
  }
}
