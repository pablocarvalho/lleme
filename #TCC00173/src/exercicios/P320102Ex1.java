package exercicios;

import java.util.Scanner;

public class P320102Ex1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, soma = 0, cont = 0;
    do {
      n = in.nextInt();
      if (n < 0 && n != -1)
        System.out.println("numero negativo");
      else if (primo(n)) {
        soma += n;
        cont++;
      }
    } while (n != -1);
    System.out.println((float) soma / cont);
  }

  public static boolean primo(int n) {
    if (n == 2)
      return true;
    else if (n % 2 == 0)
      return false;
    else
      for (int i = 3; i < Math.sqrt(n); i += 2)
        if (n % i == 0)
          return false;
    return true;
  }
}
