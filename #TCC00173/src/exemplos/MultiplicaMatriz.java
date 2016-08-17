package exemplos;

public class MultiplicaMatriz {

  public static void main(String[] args) throws Exception {
    float[][] p = {{1, 2, 5}, {2, 5, 4}};
    float[][] l = {{2, 2}, {1, 1}, {5, 7}};
    imprimeMatriz(multiplica(p, l));
  }

  public static float[][] multiplica(float[][] a, float[][] b) throws Exception {
    float[][] resultado = new float[a.length][b[0].length];
    if (a[0].length != b.length)
      throw new Exception();
    for (int i = 0; i < a.length; i++)
      for (int k = 0; k < b[0].length; k++)
        for (int j = 0; j < a[0].length; j++)
          resultado[i][k] += a[i][j] * b[j][k];
    return resultado;
  }

  public static void imprimeMatriz(float r[][]) {
    for (int i = 0; i < r.length; i++) {
      for (int j = 0; j < r[0].length; j++)
        System.out.print(r[i][j] + "\t");
      System.out.println("");
    }
  }
}
