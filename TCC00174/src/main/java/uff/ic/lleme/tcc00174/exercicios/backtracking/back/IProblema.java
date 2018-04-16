/**
 *
 * @author marcoslage
 */
package uff.ic.lleme.tcc00174.exercicios.backtracking.back;

public interface IProblema {

  public void gravaCandidato(int k, ICandidato obj);

  public void apagaCandidato(int k, ICandidato obj);

  public boolean testaCandidato(ICandidato obj);

  public void imprimeProblema();
}
