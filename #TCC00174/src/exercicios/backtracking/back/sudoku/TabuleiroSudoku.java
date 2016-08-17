/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back.sudoku;

import exercicios.backtracking.back.ICandidato;
import exercicios.backtracking.back.IProblema;
import exercicios.backtracking.back.Posicao;

public class TabuleiroSudoku implements IProblema {

  int nl = 9;
  int nc = 9;
  private Posicao[] tabuleiro = null;

  public TabuleiroSudoku() {
    tabuleiro = new Posicao[nl * nc];
  }

  public TabuleiroSudoku(int[][] data) {
    tabuleiro = new Posicao[nl * nc];
    for (int k = 0; k < tabuleiro.length; k++)
      tabuleiro[k] = new Posicao(k / nc, k % nc, data[k / nc][k % nc]);
  }

  @Override
  public boolean testaCandidato(ICandidato p) {
    Posicao pos = (Posicao) p;

    //evita células inválidas
    if (pos.getI() < 0 || pos.getI() >= nl)
      return false;
    if (pos.getJ() < 0 || pos.getJ() >= nc)
      return false;

    for (int delta = 0; delta < nl; delta++) {
      //testa a jogada em relação à coluna.
      if (tabuleiro[delta * nc + pos.getJ()].getData() == pos.getData())
        return false;

      //testa a jogada em relaçao à linha.
      if (tabuleiro[pos.getI() * nc + delta].getData() == pos.getData())
        return false;
    }

    for (int delta = 0; delta < 3; delta++) {
      int baseI = (pos.getI() / 3) * 3 + delta;

      for (int gamma = 0; gamma < 3; gamma++) {
        int baseJ = (pos.getJ() / 3) * 3 + gamma;

        //testa a jogada em relaçao ao quadradao
        if (tabuleiro[baseI * nc + baseJ].getData() == pos.getData())
          return false;
      }
    }

    return true;
  }

  @Override
  public void gravaCandidato(int k, ICandidato opcao) {

    Posicao pos = (Posicao) opcao;
    tabuleiro[pos.getI() * nc + pos.getJ()].setData(pos.getData());

  }

  @Override
  public void apagaCandidato(int k, ICandidato opcao) {

    Posicao pos = (Posicao) opcao;
    tabuleiro[pos.getI() * nc + pos.getJ()].setData(0);
  }

  @Override
  public void imprimeProblema() {

    System.out.println("\nA Solução é: --");
    for (int i = 0; i < nl; i++) {
      for (int j = 0; j < nc; j++) {

        final int k = i * nc + j;

        String twoDigit = String.format("%2d", (Integer) tabuleiro[k].getData());
        System.out.print(twoDigit + " ");
      }
      System.out.println("");
    }
  }
}
