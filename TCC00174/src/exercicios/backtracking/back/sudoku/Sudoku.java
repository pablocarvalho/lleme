/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back.sudoku;

import exercicios.backtracking.back.Backtracking;
import exercicios.backtracking.back.ICandidato;
import exercicios.backtracking.back.Posicao;

public class Sudoku extends Backtracking {

  final int nPosicos = 81;

  public Sudoku(int[][] data) {
    a = new TabuleiroSudoku(data);
    terminou = false;
  }

  @Override
  public boolean ehSolucao(int k) {
    if (k + 1 == nPosicos)
      return true;
    return false;
  }

  @Override
  public ICandidato[] constroiCandidatos(int k) {

    Posicao[] aux = new Posicao[9];
    TabuleiroSudoku tab = (TabuleiroSudoku) a;

    int nCandidatos = 0;
    for (int esc = 1; esc < 10; esc++) {
      Posicao currPos = new Posicao(k / 9, k % 9, esc);

      if (tab.testaCandidato(currPos)) {
        aux[esc - 1] = currPos;
        nCandidatos++;
      }
    }

    Posicao[] candidatos = new Posicao[nCandidatos];
    nCandidatos = 0;
    for (int col = 0; col < 9; col++)
      if (aux[col] != null)
        candidatos[nCandidatos++] = aux[col]; //System.out.print(aux[col].toString() +" ");
    //System.out.println("");

    return candidatos;
  }

  @Override
  public void processaSolucao(int k) {
    a.imprimeProblema();
  }
}
