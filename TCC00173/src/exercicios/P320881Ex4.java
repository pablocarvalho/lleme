package exercicios;

public class P320881Ex4 {

  public static void main(String[] args) {
    char matriz[][] = escada(12);
    for (int i = 0; i < matriz.length; i++) {
      System.out.println("\n");
      for (int j = 0; j < matriz.length; j++)
        System.out.print(matriz[i][j] + "\t");

    }

  }

  public static char[][] escada(int andares) {
    char[][] matriz = new char[andares][andares];
    int k = 0;
    for (int i = 0; i < andares; i++)
      for (int j = 0; j < andares; j++)
        if (!(i < andares - j - 1)) {
          k = i - andares + j;
          if (k % 2 == 0)
            matriz[i][j] = 'P';
          else
            matriz[i][j] = 'V';
        }
    return matriz;
  }
}
