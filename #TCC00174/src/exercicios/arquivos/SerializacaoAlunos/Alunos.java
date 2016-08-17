package exercicios.arquivos.SerializacaoAlunos;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Alunos
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.Serializable;

public class Alunos implements Serializable {
  //transient private Aluno[] list;

  private Aluno[] list;
  //int numAlunos;
  transient int numAlunos;

  /**
   * Construtor.
   *
   * @param tam Tamanho da lista de alunos.
   */
  Alunos(int tam) {
    list = new Aluno[tam];
  }

  /**
   * Adiciona um aluno à lista.
   *
   * @param aluno Alunos que será adicionado a lista.
   */
  public void add(Aluno aluno) {
    list[numAlunos++] = aluno;
  }

  /**
   * Acesso a um aluno da lista.
   *
   * @param index �?ndice do aluno
   * @return Aluno da lista.
   */
  public Aluno getAluno(int index) {
    Aluno aluno = null;
    try {
      aluno = list[index];
    } catch (ArrayIndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }

    return aluno;
  }

  /**
   * Imprime a lista de alunos.
   */
  public void print() {
    System.out.println(numAlunos);
    for (int i = 0; i < list.length; i++)
      if (list != null)
        if (list[i] != null)
          System.out.println(list[i].toString());
  }
}
