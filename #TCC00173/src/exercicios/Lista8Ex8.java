package exercicios;

public class Lista8Ex8 {

  public static void main(String[] args) {
  }

  public static boolean tridiagonal(int a[][]) {

    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[0].length; j++)
        if (i != j && i != j - 1 && i != j + 1 && a[i][j] != 0)
          return false;
    return true;
  }
}
