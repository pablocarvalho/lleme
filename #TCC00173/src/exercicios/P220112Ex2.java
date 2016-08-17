package exercicios;

public class P220112Ex2 {

  public static void main(String[] args) {
  }

  public static float[] solucao(float[][] matriz, int variavel) {
    float[] solucoes = new float[matriz[0].length - 1];
    for (int i = matriz.length - 2; i >= 0; i--) {
      float soma = 0;
      for (int j = solucoes.length - 1; j > i; j--)
        soma += matriz[i][j] * solucoes[j];
      solucoes[i] = (matriz[i][matriz[0].length - 1] - soma) / matriz[i][i];
    }
    return solucoes;
  }
}
