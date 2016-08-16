package exercicios.arquivos.direto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner("");
    String[] seq = new String[5];
    String arquivo2=null;
    boolean encontrou = false;

    while (sc.hasNext() && !encontrou) {
      String palavra = sc.next();
      if (palavra != null && !palavra.equals("")) {
        incluir(palavra, seq);
        if (cinco(seq)) {
          encontrou = busca(seq, arquivo2);
          if (encontrou)
            System.out.println("encontrou");
        }
      }

    }

  }

  private static void incluir(String palavra, String[] seq) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private static boolean cinco(String[] seq) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private static boolean busca(String[] seq, String arquivo2) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
