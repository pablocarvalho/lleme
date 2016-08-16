package exercicios;

public class P320071Ex3 {

  public static void main(String[] args) {
    double[][] matriz = {{1, 0}, {0, 2}};
    System.out.println(isDiagonal(matriz));


  }

  public static boolean isDiagonal(double[][] matriz) {
    for (int i = 0; i < matriz.length; i++)
      for (int j = 0; j < matriz[0].length; j++)
        if (i != j && matriz[i][j] != 0)
          return false;
    return true;

  }
}
