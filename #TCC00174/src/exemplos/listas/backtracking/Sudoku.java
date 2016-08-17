package exemplos.listas.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sudoku {

  private static int[][] tabuleiro = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}};

  public static void main(String[] args) {
    Stack<Preenchimento> sol = new Stack();
    Stack<Posicao> zeros = listarZeros(tabuleiro);

    backtrack(sol, zeros);
  }

  public static void backtrack(Stack<Preenchimento> solution, Stack<Posicao> zeros) {
    if (isSolution(solution))
      processSolution(solution);
    else
      try {
        Posicao pos = zeros.pop();
        List<Preenchimento> candidates = constructCandidates(solution, pos);
        for (Preenchimento p : candidates) {
          solution.push(p);
          backtrack(solution, zeros);
          solution.pop();
        }
        zeros.push(pos);
      } catch (Exception e) {
      }
  }

  public static boolean isSolution(Stack<Preenchimento> sol) {
    int[][] novoTabuleiro = aplicar(sol, tabuleiro);
    if (eValido(novoTabuleiro))
      return true;
    return false;
  }

  public static void processSolution(Stack<Preenchimento> sol) {
    int[][] novoTabuleiro = aplicar(sol, tabuleiro);
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro.length; j++)
        System.out.print(novoTabuleiro[i][j] + " ");
      System.out.println("");
    }
  }

  public static List<Preenchimento> constructCandidates(Stack<Preenchimento> sol, Posicao pos) {
    Stack<Preenchimento> cand = new Stack();
    Stack<Preenchimento> temp;
    for (int i = 1; i < 10; i++) {
      cand.push(new Preenchimento(pos, i));
      temp = new Stack<>();
      temp.addAll(sol);
      temp.add(cand.peek());
      int[][] novoTabuleiro = aplicar(temp, tabuleiro);
      if (!eValido2(pos.linha, pos.coluna, novoTabuleiro))
        cand.pop();
    }
    return cand;
  }

  private static int[][] aplicar(Stack<Preenchimento> sol, int[][] tabuleiro) {
    int[][] novoTabuleiro = new int[tabuleiro.length][tabuleiro[0].length];
    for (int i = 0; i < novoTabuleiro.length; i++)
      for (int j = 0; j < novoTabuleiro[0].length; j++)
        novoTabuleiro[i][j] = tabuleiro[i][j];
    for (Preenchimento p : sol)
      novoTabuleiro[p.pos.linha][p.pos.coluna] = p.valor;
    return novoTabuleiro;
  }

  private static boolean eValido(int[][] novoTabuleiro) {
    for (int i = 0; i < novoTabuleiro.length; i++)
      if (possuiRepetidosLinha(i, novoTabuleiro)
              || possuiZerosLinha(i, novoTabuleiro))
        return false;
    for (int j = 0; j < novoTabuleiro.length; j++)
      if (possuiRepetidosColuna(j, novoTabuleiro))
        return false;
    for (int i = 0; i < novoTabuleiro.length; i = i + 3)
      for (int j = 0; j < novoTabuleiro[0].length; j = j + 3)
        if (possuiRepetidosSubmatriz(i, j, 3, novoTabuleiro))
          return false;
    return true;
  }

  private static boolean eValido2(int i, int j, int[][] novoTabuleiro) {
    if (possuiRepetidosLinha(i, novoTabuleiro))
      return false;
    if (possuiRepetidosColuna(j, novoTabuleiro))
      return false;
    if (possuiRepetidosSubmatriz((i / 3) * 3, (j / 3) * 3, 3, novoTabuleiro))
      return false;
    return true;
  }

  private static boolean possuiRepetidosLinha(int i, int[][] novoTabuleiro) {
    int[] cont = new int[10];
    for (int j = 0; j < novoTabuleiro[0].length; j++)
      cont[novoTabuleiro[i][j]]++;
    for (int j = 1; j < 10; j++)
      if (cont[j] > 1)
        return true;
    return false;
  }

  private static boolean possuiRepetidosColuna(int j, int[][] novoTabuleiro) {
    int[] cont = new int[10];
    for (int i = 0; i < novoTabuleiro[0].length; i++)
      cont[novoTabuleiro[i][j]]++;
    for (int i = 1; i < 10; i++)
      if (cont[i] > 1)
        return true;
    return false;
  }

  private static boolean possuiZerosLinha(int i, int[][] novoTabuleiro) {
    for (int j = 0; j < novoTabuleiro[0].length; j++)
      if (novoTabuleiro[i][j] == 0)
        return true;
    return false;
  }

  private static boolean possuiRepetidosSubmatriz(int k, int l, int t, int[][] novoTabuleiro) {
    int[] cont = new int[10];
    for (int i = k; i - k < t; i++)
      for (int j = l; j - l < t; j++)
        cont[novoTabuleiro[i][j]]++;
    for (int j = 1; j < 10; j++)
      if (cont[j] > 1)
        return true;
    return false;
  }

  private static Stack<Posicao> listarZeros(int[][] tabuleiro) {
    Stack<Posicao> zeros = new Stack<>();
    for (int i = tabuleiro.length - 1; i >= 0; i--)
      for (int j = tabuleiro[0].length - 1; j >= 0; j--)
        if (tabuleiro[i][j] == 0)
          zeros.push(new Posicao(i, j));
    return zeros;
  }
}
