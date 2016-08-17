package exercicios.p320102ex2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class P320102Ex2 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    Disciplina disc = new Disciplina();
    disc.initNotasTrabalho("");
    disc.intNotasP3("");
    disc.imprimeMedia();
  }
}
