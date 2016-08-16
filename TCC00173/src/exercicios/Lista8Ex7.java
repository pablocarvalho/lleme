package exercicios;

public class Lista8Ex7 {

  public static void main(String[] args) {
    float[][] m1 = {{2, 3}, {4, 5}};
    float[][] m2 = {{2, 0}, {0, 1}};
    float[][] soma = soma(m1, m2);

    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[0].length; j++)
        System.out.print(soma[i][j] + "\t");
      System.out.println("");
    }


  }

  public static float[][] soma(float[][] m1, float[][] m2) {
    float[][] soma = new float[m1.length][m1[0].length];
    for (int i = 0; i < m1.length; i++)
      for (int j = 0; j < m1[0].length; j++)
        soma[i][j] = m1[i][j] + m2[i][j];
    return soma;
  }
}
