package exemplos;

import java.util.Scanner;

public class Angulo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double radianos, graus_decimais, resto;
    int graus, minutos;
    double segundos;

    System.out.println("Entre com um angulo em radianos: ");
    radianos = in.nextDouble();
    graus_decimais = radianos / (2 * Math.PI) * 360;
    graus = (int) graus_decimais;
    resto = graus_decimais % graus;
    minutos = (int) (resto * 60);
    resto = (resto * 60) % minutos;
    segundos = resto * 60;
    System.out.println("\nValor convertido graus, minutos e segundos: "
            + graus + ":" + minutos + ":" + segundos);
  }
}
