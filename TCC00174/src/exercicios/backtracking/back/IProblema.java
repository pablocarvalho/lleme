/**
 *
 * @author marcoslage
 */
package exercicios.backtracking.back;

public interface IProblema {

  public void gravaCandidato(int k, ICandidato obj);

  public void apagaCandidato(int k, ICandidato obj);

  public boolean testaCandidato(ICandidato obj);

  public void imprimeProblema();
}
