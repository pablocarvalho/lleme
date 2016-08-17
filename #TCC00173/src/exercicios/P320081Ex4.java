package exercicios;

public class P320081Ex4 {

  public static void main(String[] args) {
    escada(6);
  }

  public static void escada(int n) {
    char[][] mat = new char[n][n];
    int novoJ = 0;
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++) {
        novoJ = n - 1 - j;
        if (novoJ > i)
          mat[i][j] = 'B';
        else if ((i - novoJ) % 2 == 0)
          mat[i][j] = 'V';
        else
          mat[i][j] = 'P';
      }
    imprimir(mat);
  }

  public static void imprimir(char[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++)
        System.out.print(mat[i][j] + "\t");
      System.out.println("");
    }
  }
}
