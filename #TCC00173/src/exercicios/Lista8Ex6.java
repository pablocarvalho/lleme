package exercicios;

public class Lista8Ex6 {

  public static void main(String[] args) {
  }

  public static float maximo(float[][] matriz) {
    float maximo = matriz[0][0];
    for (int i = 0; i < matriz.length; i++)
      for (int j = 0; j < matriz[0].length; j++)
        if (matriz[i][j] > maximo)
          maximo = matriz[i][j];
    return maximo;
  }
}
