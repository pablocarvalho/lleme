package exercicios;

import java.util.Scanner;

public class Lista1EX12 {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    float s0, v0, a, t, v, s;

    System.out.println("Entre com o valor do s0: ");
    s0 = in.nextFloat();
    System.out.println("Entre com o valor do v0: ");
    v0 = in.nextFloat();
    System.out.println("Entre com o valor de t: ");
    t = in.nextFloat();
    System.out.println("Entre com o valor de a: ");
    a = in.nextFloat();

    s = s(s0, v0, t, a);
    System.out.println("A posiçao final foi: " + s);

    v = v(v0, a, t);
    System.out.println("A velocidade final foi: " + v);
  }

  public static float s(float s0, float v0, float t, float a) {

    return s0 + v0 * t + a * t * t / 2;
  }

  public static float v(float v0, float a, float t) {

    return v0 + a * t;
  }
}
