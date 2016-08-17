
import java.util.Scanner;

public class EscreveMatriz {

  public static void main(String[] args) {
    char[][] m;
    int n;

    Scanner in = new Scanner(System.in);
    System.out.println("Entre um numero");
    n = in.nextInt();
    m = new char[n][n];
    for (int i = 0; i < m.length; i++)
      for (int j = 0; j < m[0].length; j++)
        if (i % j == 0 || j % i == 0)
          m[i][j] = '*';
        else
          m[i][j] = ' ';
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++)
        System.out.print(m[i][j] + "\t");
      System.out.println("");
    }
  }
}
