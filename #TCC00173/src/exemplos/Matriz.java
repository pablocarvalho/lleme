package exemplos;

public class Matriz {

  public static void main(String[] args) {
    float[][] m1 = {{2, 3, 5}, {0, 0, 1}, {1, 1, 0}};
    float[][] m2 = {{2, 2, 0}, {0, 1, 1}, {0, 1, 0}};

    float[][] prod = produto(m1, m2);

    for (int i = 0; i < prod.length; i++) {
      for (int j = 0; j < prod[0].length; j++)
        System.out.print(prod[i][j] + "\t");
      System.out.println("");
    }

  }

  public static float[][] produto(float[][] a, float[][] b) {
    float[][] prod = new float[a.length][b.length];

    for (int i = 0; i < a.length; i++)
      for (int k = 0; k < b[0].length; k++)
        for (int j = 0; j < a[0].length; j++)
          prod[i][k] += a[i][j] * b[j][k];

    return prod;
  }
}
