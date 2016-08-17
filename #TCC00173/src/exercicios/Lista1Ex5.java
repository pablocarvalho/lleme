package exercicios;

import java.util.Scanner;

public class Lista1Ex5 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("digite o raio");
    float raio = in.nextFloat();
    System.out.println("diametro e " + calculoDiametro(raio));

  }

  public static float calculoDiametro(float raio) {
    float diametro = 2 * raio;
    return diametro;
  }

  public static float calculoCircunferencia(float raio) {

    return (float) (2 * Math.PI * raio);
  }
}
