package exercicios;

import java.util.Scanner;

public class Lista7Ex8_3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num;
    int[] vetor = new int[50];
    do {
      num = in.nextInt();

      if (num != -1)
        armazena(num, vetor);
    } while (num != -1);

    for (int i = 0; i < vetor.length && vetor[i] != 0; i++)
      System.out.print(vetor[i] + "\t");
  }

  private static void armazena(int num, int[] vetor) {

    for (int i = 0; i < vetor.length; i++) {
      if (vetor[i] == num)
        return;
      if (vetor[i] == 0) {
        vetor[i] = num;
        return;
      }
    }


  }
}
