package provas.s20141.p220141;

public class Main {

  public static void main(String[] args) {

    Decodificador decodificador = new Decodificador();

    String msg = "Mensagem original";
    System.out.println(msg);

    for (String palavra : msg.split(" "))
      System.out.print(decodificador.decodificar(palavra) + " ");
    System.out.println("");

  }
}
