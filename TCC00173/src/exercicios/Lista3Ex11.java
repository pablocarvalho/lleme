package exercicios;

import java.util.Scanner;

public class Lista3Ex11 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    float gasto = 0, total = 0;
    System.out.println("Digite o gasto:");
    gasto = in.nextFloat();
    while (gasto > 0) {
      total += gasto;
      System.out.println("Digite o gasto:");
      gasto = in.nextFloat();
    }
    float valor = conta(total);
    System.out.println("Conta:" + valor);
  }

  public static float conta(float valor) {
    float resultado = valor * 1.1f;
    return resultado;
  }
}
