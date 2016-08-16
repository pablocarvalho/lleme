package exercicios;

public class P120112Ex3 {

  public static void main(String[] args) {
  }

  public static boolean eSubMatriz(int[][] a, int[][] b) {
    boolean encontrou = false;
    boolean iguais;
    for (int i = 0; i < a.length - b.length + 1; i++)
      for (int j = 0; j < a[0].length - b[0].length + 1; j++) {
        iguais = existeB(a, b, i, j);
        if (iguais)
          return true;
      }
    return encontrou;
  }

  public static boolean existeB(int[][] a, int[][] b, int i, int j) {
    boolean existe = true;
    for (int k = 0; k < b.length; k++)
      for (int l = 0; l < b[0].length; l++)
        if (b[k][l] != a[i + k][j + l])
          return false;
    return existe;
  }
}
