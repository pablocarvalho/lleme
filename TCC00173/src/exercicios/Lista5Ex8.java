package exercicios;

import java.util.Scanner;

public class Lista5Ex8 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o s0");
    float s0 = in.nextFloat();
    System.out.println("Digite o v0");
    float v0 = in.nextFloat();
    System.out.println("Digite a a");
    float a = in.nextFloat();
    for (int t = 0; t < 10; t++)
      System.out.println("Tempo: " + t + " Posição:" + espacoFinal(s0, v0, a, t));

  }

  public static float espacoFinal(float s0, float v0, float a, float t) {
    float s;
    s = s0 + v0 * t + (a * t * t) / 2;
    return s;
  }
}
