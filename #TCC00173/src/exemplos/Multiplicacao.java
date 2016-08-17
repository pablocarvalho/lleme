package exemplos;

import java.util.Scanner;

public class Multiplicacao {

  public static void main(String[] args) {
    int[] v = {3, 2, 3, 5, 7};
    float x = 2.3f;
    float resultado = 0;

    for (int i = 0; i < v.length; i++)
      resultado += Math.pow(x, i) * v[i];

    Scanner in = new Scanner(System.in);
    float[][] notas = new float[3][3];
    for (int i = 0; i < 10; i++)
      for (int j = 0; j < 10; j++)
        notas[i][j] = in.nextFloat();

  }

  public static int multiplica(int x, int y, int[] v) {
    x = 34;
    y = 56;
    v = new int[3];
    v[2] = 100;
    return 4;
  }
}
