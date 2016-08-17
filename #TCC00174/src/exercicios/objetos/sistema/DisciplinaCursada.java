package exercicios.objetos.sistema;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anselmomontenegro
 */
public class DisciplinaCursada {

  Disciplina disciplina;
  float nota;

  DisciplinaCursada() {
  }

  ;

    DisciplinaCursada(Disciplina disciplina, int nota) {
    this.disciplina = disciplina;
    this.nota = nota;
  }

  public Disciplina getDisciplina() {
    return disciplina;
  }

  public void setDisciplina(Disciplina disciplina) {
    this.disciplina = disciplina;
  }

  public float getNota() {
    return nota;
  }

  public void setNota(float nota) {
    this.nota = nota;
  }
}
