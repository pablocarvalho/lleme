package exercicios;

public class P320081Ex4_2 {

  public static void main(String[] args) {
    int n = 10, novo_j;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        novo_j = n - j;
        if (novo_j <= i)
          if ((i - novo_j) % 2 == 0)
            System.out.print("V ");
          else
            System.out.print("P ");
        else
          System.out.print("  ");
      }
      System.out.println("");
    }
  }
}
