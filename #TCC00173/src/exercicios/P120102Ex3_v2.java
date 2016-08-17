package exercicios;

import java.util.Scanner;

public class P120102Ex3_v2 {

  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    System.out.println("n1");
    int n1 = leitor.nextInt();
    System.out.println("n2");
    int n2 = leitor.nextInt();

    System.out.println(somaDivisiveis(n1, n2));
  }

  public static int somaDivisiveis(int n1, int n2) {
    int soma = 0;
    for (int num = n1; num <= n2; num++)
      if (num % 5 == 0 || num % 7 == 0)
        soma += num;
    return soma;
  }
}
