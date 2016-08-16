package exercicios;

public class Lista8_Ex4 {

  public static void main(String[] args) {
    //double[][] m = new double[3][2];
    double[][] m = {{2, 4, 5}, {1, 1, 1}};
    m = new double[3][2];
    System.out.println(maatriz_nula(m));

  }

  public static boolean maatriz_nula(double[][] mat) {
    for (int i = 0; i < mat.length; i++)
      for (int j = 0; j < mat[0].length; j++)
        if (mat[i][j] != 0)
          return false;
    return true;
  }
}
