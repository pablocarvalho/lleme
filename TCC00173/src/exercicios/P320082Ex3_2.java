/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author Luiz Leme
 */
public class P320082Ex3_2 {

  public static void main(String[] args) {
    float[][] mat = {{2.5f, 4.3f, 5.6f}, {4.0f, 2.1f, 1.9f}, {2.3f, 8.3f, 2.0f}};
    int[] vet = maximo_linhas_matriz(mat);
    for (int valor : vet)
      System.out.print(valor + "\t");
  }

  public static int[] maximo_linhas_matriz(float[][] mat) {
    int maior;
    int[] vet = new int[mat.length];
    for (int i = 0; i < mat.length; i++) {
      maior = 0;
      for (int j = 1; j < mat[0].length; j++)
        if (mat[i][maior] < mat[i][j])
          maior = j;
      vet[i] = maior;
    }
    return vet;
  }
}
