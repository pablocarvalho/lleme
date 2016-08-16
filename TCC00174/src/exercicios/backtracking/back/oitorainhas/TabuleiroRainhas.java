/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back.oitorainhas;

import exercicios.backtracking.back.ICandidato;
import exercicios.backtracking.back.IProblema;
import exercicios.backtracking.back.Posicao;

public class TabuleiroRainhas implements IProblema {

  int nl = 8;
  int nc = 8;
  private Posicao[] tabuleiro = null;

  public TabuleiroRainhas() {
    tabuleiro = new Posicao[nl * nc];
  }

  public TabuleiroRainhas(int i, int j) {

    tabuleiro = new Posicao[nl * nc];
    for (int k = 0; k < tabuleiro.length; k++)
      tabuleiro[k] = new Posicao(k / nc, k % nc, "-");

    tabuleiro[i * nc + j].setData("R");
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
      //testa a posição em relação à coluna.
      if (tabuleiro[delta * nc + pos.getJ()].getData() == "R")
        return false;

      //testa a posição em relaçao à linha.
      if (tabuleiro[pos.getI() * nc + delta].getData() == "R")
        return false;

      Posicao diag = new Posicao(delta, pos.getJ() - pos.getI() + delta);
      //testa a posição em relação à diagonal principal
      if (diag.getI() >= 0 && diag.getI() < nl && diag.getJ() >= 0 && diag.getJ() < nc)
        if (tabuleiro[delta * nc + pos.getJ() - pos.getI() + delta].getData() == "R")
          return false;

      Posicao diag2 = new Posicao(delta, pos.getJ() + pos.getI() - delta);
      //testa a posição em relação à diagonal secundária
      if (diag2.getI() >= 0 && diag2.getI() < nl && diag2.getJ() >= 0 && diag2.getJ() < nc)
        if (tabuleiro[delta * nc + pos.getJ() + pos.getI() - delta].getData() == "R")
          return false;
    }

    return true;
  }

  @Override
  public void gravaCandidato(int k, ICandidato opcao) {

    Posicao pos = (Posicao) opcao;
    tabuleiro[pos.getI() * nc + pos.getJ()].setData("R");
  }

  @Override
  public void apagaCandidato(int k, ICandidato opcao) {

    Posicao pos = (Posicao) opcao;
    tabuleiro[pos.getI() * nc + pos.getJ()].setData("-");
  }

  @Override
  public void imprimeProblema() {

    System.out.println("\nA Solução é: --");
    for (int i = 0; i < nl; i++) {
      for (int j = 0; j < nc; j++) {
        //pega a coordenada linear
        final int k = i * nc + j;
        System.out.print((String) tabuleiro[k].getData() + " ");
      }
      System.out.println("");
    }
  }
}
