package exemplos;

public class MultiplicarMatrizes {

  public static void main(String[] args) {
    float[][] m1 = {{2, 5, 6}, {2, 6, 1}, {3, 4, 5}, {10, 1, 8}};
    float[][] m2 = {{5, 1}, {7, 4}, {2, 4}};
    float[][] resultado = multiplicar(m1, m2);
    for (int i = 0; i < resultado.length; i++) {
      for (int j = 0; j < resultado[0].length; j++)
        System.out.print(resultado[i][j] + "\t");
      System.out.println();
    }
  }

  public static float[][] multiplicar(float[][] m1, float m2[][]) {
    float[][] m3 = new float[m1.length][m2[0].length];

    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < m2[0].length; j++)
        for (int k = 0; k < m1[0].length; k++)
          m3[i][j] += m1[i][k] * m2[k][j];
    return m3;
  }
}
