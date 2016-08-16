package exercicios.arquivos.SerializacaoAlunos;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Aluno
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.Serializable;

public class Aluno implements Serializable {

  private int mat;     //> Matrícula de um aluno
  private String nome; //> Nome do aluno
  private double cr;   //> Cr do aluno 

  /**
   * Construtor.
   *
   * @param nome Nome do aluno.
   * @param mat Matricula do aluno.
   * @param cr CR do aluno.
   */
  Aluno(String nome, int mat, double cr) {
    this.nome = nome;
    this.mat = mat;
    this.cr = cr;
  }

  /**
   * Acesso ao nome do aluno.
   *
   * @return nome do aluno.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Atribuicao do nome do aluno.
   *
   * @param nome Nome do aluno.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Acesso à matricula do aluno.
   *
   * @return matricula do aluno.
   */
  public int getMat() {
    return mat;
  }

  /**
   * Atribuição da matricula do aluno.
   *
   * @param mat Matricula do aluno.
   */
  public void setMat(int mat) {
    this.mat = mat;
  }

  /**
   * Acesso ao cr do aluno.
   *
   * @return cr do aluno.
   */
  public double getCr() {
    return cr;
  }

  /**
   * Aribuição do cr do aluno.
   *
   * @param cr do aluno.
   */
  public void setCr(int cr) {
    this.cr = cr;
  }

  /**
   * Salva em String os atributos do aluno.
   */
  @Override
  public String toString() {
    return nome + " " + mat + " " + cr;
  }
}
