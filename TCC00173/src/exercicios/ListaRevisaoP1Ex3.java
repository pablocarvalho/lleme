package exercicios;

import exemplos.oo.ponto.Aluno;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ListaRevisaoP1Ex3 {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream("alunos.txt");
    Scanner in = new Scanner(input);
    Aluno[] alunos = new Aluno[15];
    int i = 0;
    while (in.hasNext() && i < alunos.length)
      alunos[i++] = new Aluno(in.nextInt(), in.nextLine());

    input = new FileInputStream("notas.txt");
    in = new Scanner(input);
    while (in.hasNext()) {
      int matricula = in.nextInt();
      float p1 = in.nextFloat();
      float p2 = in.nextFloat();
      float p3 = in.nextFloat();
      int pos = buscaAluno(alunos, matricula);
      if (pos != -1)
        alunos[pos].addNotas(p1, p2, p3);
    }

    for (int j = 0; j < alunos.length; j++)
      if (alunos[j].notaFinal() >= 5.0
              && alunos[j].getP1() >= 3.0
              && alunos[j].getP2() >= 3.0)
        System.out.println("Aluno " + alunos[j].matricula + " aprovado");
      else if ((alunos[j].maiorNota() + alunos[j].getP3()) / 2 >= 5.0)
        System.out.println("Aluno "
                + alunos[j].matricula + " aprovado");
      else
        System.out.println("Aluno "
                + alunos[j].matricula + " reprovado");
  }

  public static int buscaAluno(Aluno[] alunos, int matricula) {

    return -1;


  }
}
