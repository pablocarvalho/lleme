package exercicios;

import java.util.Scanner;

public class P120102Ex1_v2 {

  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    System.out.println("Digite a qtd de agua em A");
    float va = leitor.nextFloat();
    System.out.println("Digite a qtd de agua em B");
    float vb = leitor.nextFloat();
    System.out.println("Digite a qtd de agua em Q");
    float q = leitor.nextFloat();
    float na = va * 0.8f;
    float nb = vb * 0.9f;
    float ra;
    if (q <= na)
      ra = q;
    else
      ra = na;
    float q2 = q - ra;
    float rb;
    if (q2 <= nb)
      rb = q2;
    else
      rb = nb;
    System.out.println("O que foi retirado de A: " + ra);
    System.out.println("O que foi retirado de B: " + rb);
    if (q > (ra + rb))
      System.out.println("Faltou retirar: " + (q - (ra + rb)));

  }
}
