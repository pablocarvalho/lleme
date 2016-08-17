package exercicios.objetos.sistema;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anselmomontenegro
 */
public class Disciplina {

  String nome;
  int codigo;
  int numCreditos;


  /* Metodos de acesso */
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getNumCreditos() {
    return numCreditos;
  }

  public void setNumCreditos(int numCreditos) {
    this.numCreditos = numCreditos;
  }

  public String toString() {
    return "Nome: " + nome + ", Codigo: " + codigo + "Número de créditos: "
            + numCreditos;
  }
}
