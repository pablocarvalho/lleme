package exemplos.oo.metro;

import java.io.FileNotFoundException;

public class MetroMain {

  public static void main(String[] args) throws FileNotFoundException {
    Metro metro = new Metro("entrada.txt");
    String[] trajeto = {"A", "B", "D", "F"};
    System.out.println(metro.tempoTrajeto(trajeto));
  }
}
