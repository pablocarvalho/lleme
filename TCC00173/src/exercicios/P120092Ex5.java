package exercicios;

import java.util.Scanner;

public class P120092Ex5 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite o volume de A");
    int va = (int) in.nextFloat();
    System.out.println("Digite o volume de B");
    float vb = in.nextFloat();
    System.out.println("Digite o volume desejado");
    float v = in.nextFloat();
    float vamax = va * 0.8f;
    float vbmax = vb * 0.9f;
    float var = 0, vbr = 0;
    if (v >= vamax)
      var = vamax;
    else
      var = v;
    if (v > var) {
      float v2 = v - var;
      if (v2 >= vbmax)
        vbr = vbmax;
      else
        vbr = v2;


    }

  }
}
