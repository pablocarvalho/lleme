package exercicios;

import java.util.Scanner;

public class Lista7Ex8 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, i = 0;
    int pos;
    int vet[][] = new int[50][2];
    do {
      System.out.println("Digite um número:");
      n = in.nextInt();
      if (n != 0 && n != -1) {
        pos = eupidia(vet, n);
        if (pos != -1)
          vet[pos][1]++;
        else {
          vet[i][0] = n;
          vet[i][1] = 1;
          i++;
        }
      }
    } while (n != -1 && i < 50);
    for (int j = 0; j < vet.length && vet[j][0] != 0; j++)
      System.out.println(vet[j][0] + " " + vet[j][1]);
  }

  public static int eupidia(int vet[][], int n) {
    for (int i = 0; i < vet.length; i++)
      if (vet[i][0] == n)
        return i;
    return -1;
  }
}
