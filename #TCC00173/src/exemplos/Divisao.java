package exemplos;

import java.util.Scanner;

public class Divisao {

  public static void main(String[] args) {
    Scanner variavel = new Scanner(System.in);
    float altura, sobra = 0;
    int pes = 0;

    System.out.println("Entre com sua altura");
    altura = variavel.nextFloat();
    pes = (int) (altura * 100 / 30.48);
    sobra = (altura * 100) - (pes * 30.48f);
    System.out.print(pes + " pés ");
    System.out.println((sobra / 2.54) + " polegadas");
  }
}
