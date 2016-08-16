package exemplos.oo.aluno2;

import exemplos.oo.aluno2.Aluno;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class MainAluno {

  public static void main(String[] args) throws FileNotFoundException {
    Aluno[] alunos = read("entrada.txt");
  }

  public static Aluno[] read(String path) throws FileNotFoundException {
    InputStream f = new FileInputStream(path);
    Scanner in = new Scanner(f);

    int loop = 0;
    Aluno[] alunos = new Aluno[10];
    Aluno a;

    while (in.hasNext()) {
      a = new Aluno();
      a.matricula = in.nextLong();
      a.p1 = in.nextDouble();
      a.p2 = in.nextDouble();
      a.nome = in.nextLine();

      alunos[loop++] = a;

    }

    return alunos;
  }
}
