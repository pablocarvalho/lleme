package exemplos;

import java.util.Scanner;

public class Ex {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    float a, b, xi;
    int i = 0;
    i = 2;
    System.out.println("Insira o valor de a");
    a = in.nextFloat();
    System.out.println("Insira o valor de b");
    b = in.nextFloat();
    if (!(a == b))
      for (xi = a + i * (b - a) / 10; (a + i * (b - a) / 10) <= b; i++)
        System.out.println("x" + i + "=" + (a + i * (b - a) / 10));
  }
}
