package exercicios;

import org.omg.CORBA.UserException;

public class Lista5Ex9 {

  public static void main(String[] args) {

    int n = 3;
    System.out.println(termoFibonacci(n));


  }

  public static int termoFibonacci(int termo) {
    int a = 1, b = 1, c = 0;
    if (termo == 1 || termo == 2)
      return 1;
    else
      for (int i = 3; i <= termo; i++) {
        c = a + b; // terceiro termo
        a = b;
        b = c;
      }
    return c;
  }
}
