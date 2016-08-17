/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author Luiz Leme
 */
public class P320082Ex3 {

  public static void main(String[] args) {
    float[][] mat = {{2.3f, 3.2f, 4.2f}, {1.3f, 5.4f, 2.3f}, {5.3f, 7.6f, 8.9f}};
    int[] vet = vetor(mat);
    for (int i = 0; i < vet.length; i++)
      System.out.print(vet[i] + ",");
  }

  public static int[] vetor(float matriz[][]) {
    int aux;
    int vet[] = new int[matriz.length];
    for (int i = 0; i < matriz.length; i++) {
      aux = 0;
      for (int j = 1; j < matriz.length; j++)
        if (matriz[i][aux] < matriz[i][j])
          aux = j;
      vet[i] = aux;
    }
    return vet;
  }
}
