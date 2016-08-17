package exercicios;

import java.util.Scanner;

public class Lista2EX9 {

  public static void main(String[] args) {
    int t1 = 0, t2 = 0, t3;

    Scanner leitor = new Scanner(System.in);
    int n = leitor.nextInt();
    t1 = 1;
    int soma = t1;
    if (n > 1) {
      t2 = 1;
      soma = t1 + t2;
    }

    for (int i = 3; i <= n; i++) {
      t3 = t1 + t2;
      soma += t3;
      t1 = t2;
      t2 = t3;
    }
    System.out.println(soma);
  }
}
