package exercicios;

import java.util.Scanner;

public class Lista7Ex8_2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] numeros = new int[1000];
    int contador = 0, numero;
    do {
      System.out.println("mensagem");
      numero = in.nextInt();
      if (numero >= 0) {
        numeros[contador] = numero;
        contador++;
      }
    } while (numero != -1);

    for (int i = 0; i < contador; i++)
      if (naoFoiImpressoAntes(numeros, i))
        System.out.println(numeros[i]);

  }

  private static boolean naoFoiImpressoAntes(int[] numeros, int posicaoAtual) {
    for (int i = 0; i < posicaoAtual; i++)
      if (numeros[i] == numeros[posicaoAtual])
        return false;
    return true;
  }
}
