package exercicios;

import java.util.Scanner;

public class Lista1Ex14 {

  public static void main(String[] args) {
    //Scanner in = new Scanner(System.in);
    //int n=in.nextInt();

    int num = 363;
    if (num % 2 == 0)
      num--;
    int qtd = 20;
    int contador = 0;
//        if (num >= 2) {
//            System.out.println(2);
//            contador++;
//        }

    for (int i = num; i >= 3; i -= 2)
      if (primo(i) && contador < qtd) {
        System.out.println(i);
        contador++;
      }


  }

  public static boolean primo(int n) {
    if (n < 2)
      return false;
    for (int div = 2; div <= Math.sqrt(n); div++)
      if (n % div == 0)
        return false;
    return true;
  }
}
