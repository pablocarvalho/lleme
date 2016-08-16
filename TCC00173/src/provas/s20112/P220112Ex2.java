package provas.s20112;

public class P220112Ex2 {

  public static void main(String[] args) {
    float[][] matriz = {{1, 1, 0, 3}, {0, 2, 0, -2}, {0, 0, 5, 2}};
    System.out.println(x(0, matriz));
  }

  public static float x(int v, float[][] coef) {
    float resultado = coef[v][coef[0].length - 1];
    for (int j = v + 1; j < coef.length; j++)
      resultado -= coef[v][j] * x(j, coef);
    resultado /= coef[v][v];
    return resultado;
  }
}