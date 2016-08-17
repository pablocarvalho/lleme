/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Aluno
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.arquivos.LeArquivoTexto;

public class Aluno {

  static int numAlunos = 0; //> Número atual de alunos
  private int matricula;     //> Matrícula de um aluno
  private String nome;       //> Nome do aluno
  private int nota;          //> Nota do aluno 

  /**
   * Construtor.
   *
   * @param matricula Matricula do aluno.
   * @param nome Nome do aluno.
   * @param nota Nota do aluno.
   */
  public Aluno(int matricula, String nome, int nota) {
    this.matricula = matricula;
    this.nome = nome;
    this.nota = nota;
    numAlunos++;
  }

  /**
   * Acesso à matricula do aluno.
   *
   * @return matricula do aluno.
   */
  public int getMatricula() {
    return matricula;
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
   * Acesso a nota do aluno.
   *
   * @return nota do aluno.
   */
  public int getNota() {
    return nota;
  }

  /**
   * Imprime os atributos do aluno.
   */
  void print() {
    System.out.println(matricula + " " + nome + " " + nota);
  }
}
