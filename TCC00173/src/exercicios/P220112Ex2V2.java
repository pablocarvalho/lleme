package exercicios;

public class P220112Ex2V2 {

  public static void main(String[] args) {

    float[][] matriz = {{1, 1, 0, 3}, {0, 1, 0, -2}, {0, 0, 5, 2}};
    for (int i = 0; i < matriz.length; i++)
      System.out.println("" + solucao(matriz, i));
  }

  private static float solucao(float[][] matriz, int i) {
    float resultado = 0;
    float soma = 0;
    for (int j = i + 1; j < matriz[0].length - 1; j++)
      soma += matriz[i][j] * solucao(matriz, j);
    resultado = (matriz[i][matriz[0].length - 1] - soma) / matriz[i][i];
    return resultado;
  }
}
