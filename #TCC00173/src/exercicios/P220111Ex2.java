package exercicios;

public class P220111Ex2 {

  public static void main(String[] args) {

    float[][] matriz = {{-1, 2, 3, -4}, {4, 2, 0, 0},
      {-1, 2, -3, 0}, {2, 5, 3, 1}};

    System.out.println(determinante(matriz));

  }

  public static float determinante(float[][] matriz) {

    float somatorio = 0;
    if (matriz.length == 1)
      return matriz[0][0];
    else
      for (int j = 0; j < matriz.length; j++)
        somatorio += matriz[0][j] * Math.pow(-1, 0 + j)
                * determinante(submatriz(matriz, 0, j));
    return somatorio;
  }

  public static float[][] submatriz(float[][] matriz, int i, int j) {
    float[][] mat = new float[matriz.length - 1][matriz.length - 1];

    for (int k = 0; k < matriz.length; k++)
      for (int l = 0; k != i && l < matriz.length; l++)
        if (l != j)
          mat[k < i ? k : k - 1][l < j ? l : l - 1] = matriz[k][l];

    return mat;
  }
}
