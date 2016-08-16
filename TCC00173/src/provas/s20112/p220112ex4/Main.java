package provas.s20112.p220112ex4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("");
    Scanner in = new Scanner(input);
    Aluno[] alunos = new Aluno[10];
    int i = 0;
    while (in.hasNext() && i < alunos.length)
      alunos[i++] = new Aluno(in.nextInt(), in.nextLine());
    input.close();
  }
}
