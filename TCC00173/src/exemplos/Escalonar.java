package exemplos;

public class Escalonar {

  public static void main(String[] args) {
    float[][] matriz = {{4, 3, 4, 5}, {-2, 1, 2, 6}, {4, 5, 1, 7}};
    imprimeMatriz(escalonar(matriz));
  }

  public static float[][] escalonar(float[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
      pivoteamento(matriz, i);
      float pivot = matriz[i][i];
      for (int j = i + 1; j < matriz.length; j++) {
        float coef = matriz[j][i] / pivot;
        for (int k = 0; k < matriz.length; k++)
          matriz[j][k] = matriz[j][k] - matriz[i][k] * coef;
      }
    }
    return matriz;
  }

  public static void pivoteamento(float[][] matriz, int coluna) {
    int linha = coluna;
    for (int i = coluna + 1; i < matriz.length; i++)
      if (matriz[i][coluna] >= matriz[coluna][coluna])
        linha = i;
    if (linha != coluna)
      for (int i = 0; i < matriz[0].length; i++) {
        float aux = matriz[linha][i];
        matriz[linha][i] = matriz[coluna][i];
        matriz[coluna][i] = aux;
      }
  }

  public static float[][] pivotear(float[][] matriz, int diagonal) {
    int linha = diagonal;
    int coluna = diagonal;

    for (int i = diagonal; i < matriz.length; i++)
      for (int j = diagonal; j < matriz[0].length; j++)
        if (matriz[i][diagonal] >= matriz[diagonal][diagonal]) {
          linha = i;
          coluna = j;
        }
    if (linha != diagonal)
      for (int j = 0; j < matriz[0].length; j++) {
        float aux = matriz[linha][j];
        matriz[linha][j] = matriz[diagonal][j];
        matriz[diagonal][j] = aux;
      }
    if (coluna != diagonal)
      for (int i = 0; i < matriz.length; i++) {
        float aux = matriz[i][coluna];
        matriz[i][coluna] = matriz[i][diagonal];
        matriz[i][diagonal] = aux;
      }
    return matriz;
  }

  public static void imprimeMatriz(float[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++)
        System.out.print(matriz[i][j] + "\t");
      System.out.println("");
    }
  }
}
