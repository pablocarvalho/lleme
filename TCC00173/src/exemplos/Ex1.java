package exemplos;

import java.util.Scanner;

public class Ex1 {

  public static void main(String[] args) {
    int numero1, numero2;
    int mm;
    Scanner in = new Scanner(System.in);
    System.out.println("nhhgf");
    numero1 = in.nextInt();
    System.out.println("nhhgf");
    numero2 = in.nextInt();
    mm = media(numero1, numero2);
    System.out.println("media=" + mm);
  }

  public static int media(int a, int b) {
    int m;
    m = (a + b) / 2;
    return m;
  }
}
