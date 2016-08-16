package exercicios.backtracking.back;

import exercicios.backtracking.back.cavalo.PasseioDoCavalo;
import exercicios.backtracking.back.oitorainhas.OitoRainhas;
import exercicios.backtracking.back.sudoku.Sudoku;

public class MainClass {

  public static PasseioDoCavalo criaPassioDoCavalo(int i, int j) {
    return new PasseioDoCavalo(i, j);
  }

  public static OitoRainhas criaOitoRainhas(int j) {
    return new OitoRainhas(j);
  }

  public static Sudoku criaSudoku(int[][] data) {
    return new Sudoku(data);
  }

  public static void main(String[] args) {

    int[][] dataSudoku = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0, 0}};

    Backtracking bk = MainClass.criaOitoRainhas(3);
    bk.backtrack(-1);

    bk = MainClass.criaPassioDoCavalo(3, 3);
    bk.backtrack(-1);

    bk = MainClass.criaSudoku(dataSudoku);
    bk.backtrack(-1);
  }
}
