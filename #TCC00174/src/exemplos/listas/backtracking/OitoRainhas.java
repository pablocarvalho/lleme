package exemplos.listas.backtracking;

import java.util.Stack;

public class OitoRainhas {

  private int[][] tabuleiro = {{0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0}};

  public static void main(String[] args) {

    Stack<Posicao> solution = new Stack();


  }

  public static boolean isSolution(Stack<Posicao> sol) {
    int[][] tabAux = preencheTab(sol);
    if (repetidoLinha(tabAux) || repetidoColuna(tabAux) || repetidoDiagonal(tabAux))
      return true;
    return false;

  }

  private static int[][] preencheTab(Stack<Posicao> sol) {

    int[][] tabAux = new int[8][8];
    for (Posicao p : sol)
      tabAux[p.linha][p.coluna] = 1;
    return tabAux;


  }

  private static boolean repetidoLinha(int[][] tabAux) {

    int cont = 0;
    for (int i = 0; i < tabAux.length; i++) {
      for (int j = 0; j < tabAux.length; j++)
        if (tabAux[i][j] == 1) {
          cont++;
          if (cont == 2)
            return true;
        }
      cont = 0;
    }
    return false;
  }

  private static boolean repetidoColuna(int[][] tabAux) {

    int cont = 0;
    for (int j = 0; j < tabAux.length; j++)
      for (int i = 0; i < tabAux.length; i++) {
        if (tabAux[i][j] == 1) {
          cont++;
          if (cont == 2)
            return true;
        }
        cont = 0;
      }
    return false;
  }

  private static boolean repetidoDiagonal(int[][] tabAux) {

    return true;
  }
}
