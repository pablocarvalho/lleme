/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back.cavalo;

import exercicios.backtracking.back.ICandidato;
import exercicios.backtracking.back.IProblema;
import exercicios.backtracking.back.Posicao;

public class TabuleiroCavalo implements IProblema {

  int nl = 8;
  int nc = 8;
  private Posicao lastPos = null;
  private Posicao[] tabuleiro = null;

  public TabuleiroCavalo() {
    tabuleiro = new Posicao[nl * nc];
  }

  public TabuleiroCavalo(int i, int j) {

    tabuleiro = new Posicao[nl * nc];
    for (int k = 0; k < tabuleiro.length; k++)
      tabuleiro[k] = new Posicao(k / nc, k % nc, -1);

    tabuleiro[i * nc + j].setData(0);
    lastPos = new Posicao(i, j);
  }

  @Override
  public boolean testaCandidato(ICandidato p) {
    Posicao pos = (Posicao) p;

    //evita células inválidas
    if (pos.getI() < 0 || pos.getI() >= nl)
      return false;
    if (pos.getJ() < 0 || pos.getJ() >= nc)
      return false;

    return (Integer) tabuleiro[pos.getI() * nc + pos.getJ()].getData() < 0;
  }

  @Override
  public void gravaCandidato(int k, ICandidato opcao) {

    Posicao pos = (Posicao) opcao;
    tabuleiro[pos.getI() * nc + pos.getJ()].setData(k + 1);

    lastPos = pos;
  }

  @Override
  public void apagaCandidato(int k, ICandidato opcao) {

    Posicao pos = (Posicao) opcao;
    tabuleiro[pos.getI() * nc + pos.getJ()].setData(-1);
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

  public Posicao getLastPos() {
    return lastPos;
  }
}
