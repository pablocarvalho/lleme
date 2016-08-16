/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back.cavalo;

import exercicios.backtracking.back.Backtracking;
import exercicios.backtracking.back.ICandidato;
import exercicios.backtracking.back.Posicao;

public class PasseioDoCavalo extends Backtracking {

  int nPassos = 63;

  public PasseioDoCavalo(int i, int j) {

    a = new TabuleiroCavalo(i, j);
    terminou = false;
  }

  @Override
  public boolean ehSolucao(int k) {
    if (k + 1 == nPassos)
      return true;
    return false;
  }

  @Override
  public ICandidato[] constroiCandidatos(int k) {

    Posicao[] aux = new Posicao[8];
    TabuleiroCavalo tab = (TabuleiroCavalo) a;

    int nCandidatos = 0;
    for (int pos = 0; pos < 8; pos++) {
      Posicao currPos = posicaoPorID(pos, tab.getLastPos());

      if (tab.testaCandidato(currPos)) {
        aux[pos] = currPos;
        nCandidatos++;
      }
    }

    Posicao[] candidatos = new Posicao[nCandidatos];
    nCandidatos = 0;
    for (int col = 0; col < 8; col++)
      if (aux[col] != null)
        candidatos[nCandidatos++] = aux[col]; //System.out.print(aux[col].toString() +" ");
    //System.out.println("");

    return candidatos;
  }

  private Posicao posicaoPorID(int pos, Posicao p) {
    switch (pos) {
      case 0:
        return new Posicao(p.getI() + 1, p.getJ() + 2);
      case 1:
        return new Posicao(p.getI() + 1, p.getJ() - 2);
      case 2:
        return new Posicao(p.getI() - 1, p.getJ() + 2);
      case 3:
        return new Posicao(p.getI() - 1, p.getJ() - 2);
      case 4:
        return new Posicao(p.getI() + 2, p.getJ() + 1);
      case 5:
        return new Posicao(p.getI() + 2, p.getJ() - 1);
      case 6:
        return new Posicao(p.getI() - 2, p.getJ() + 1);
      case 7:
        return new Posicao(p.getI() - 2, p.getJ() - 1);
    }

    return null;
  }

  @Override
  public void processaSolucao(int k) {
    a.imprimeProblema();
  }
}
