/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back;

public abstract class Backtracking {

  protected IProblema a = null;
  protected boolean terminou = false;

  public void backtrack(int k) {
    if (ehSolucao(k)) {
      processaSolucao(k);
      terminou = true;
    } else {
      k = k + 1;

      ICandidato[] c = constroiCandidatos(k);

      for (int i = 0; i < c.length; i++) {
        a.gravaCandidato(k, c[i]);
        backtrack(k);

        if (terminou)
          return;
        else
          a.apagaCandidato(k, c[i]);
      }
    }
  }

  public abstract boolean ehSolucao(int k);

  public abstract ICandidato[] constroiCandidatos(int k);

  public abstract void processaSolucao(int k);
}
