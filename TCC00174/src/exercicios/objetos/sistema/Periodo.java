package exercicios.objetos.sistema;

import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anselmomontenegro
 */
public class Periodo {

  DisciplinaCursada[] disciplinasCursadas;
  float mediaPeriodo;
  Date data;

  Periodo(Date data, int numDisciplinas) {
    this.data = (Date) data.clone();

    disciplinasCursadas = new DisciplinaCursada[numDisciplinas];
  }

  ;

    public DisciplinaCursada getDisciplinaCursada(int index) {
    return disciplinasCursadas[index];
  }

  public void setDisciplinaCursada(int index, DisciplinaCursada disciplinaCursada) {
    this.disciplinasCursadas[index] = disciplinaCursada;
  }
}
