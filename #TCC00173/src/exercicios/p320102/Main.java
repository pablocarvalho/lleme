package exercicios.p320102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream("notasT.txt");
    Scanner in = new Scanner(input);
    String matricula;
    float trabalho;
    Disciplina disc = new Disciplina();
    disc.nomeDisciplina = "prog1";
    int cont = 0;
    Avaliacao avali;
    while (in.hasNext()) {
      matricula = in.next();
      trabalho = in.nextFloat();
      avali = new Avaliacao(matricula);
      avali.trab = trabalho;
      disc.avaliacoes[cont] = avali;
      cont++;
    }
    in.close();

    input = new FileInputStream("notasP3.txt");
    in = new Scanner(input);
    float notasP3;
    while (in.hasNext()) {
      matricula = in.next();
      notasP3 = in.nextFloat();
      avali = disc.recuperarAvaliacao(matricula);
      avali.p3 = notasP3;
      System.out.println(avali.calcularMedia());
    }
    in.close();
  }
}
