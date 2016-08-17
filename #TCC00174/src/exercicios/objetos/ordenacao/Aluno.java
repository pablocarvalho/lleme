package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Aluno
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Aluno implements IComparavel {

  private String nome; //> Nome do aluno
  private double nota; //> Nota do aluno

  /**
   * Construtor.
   *
   * @param nome Nome do aluno.
   * @param nota Nota do aluno.
   */
  public Aluno(String nome, double nota) {
    this.nome = nome;
    this.nota = nota;
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
  public double getNota() {
    return nota;
  }

  /**
   * Metodo que compara alunos.
   *
   * @param comparavel Objeto a ser comparado.
   */
  public int compararCom(IComparavel comparavel) {

    /* Polimorfismo:     
     * Cria uma referência da classe Aluno para o objeto do tipo comparavel
     */
    Aluno aluno = (Aluno) comparavel;

    // Compara a nota dos alunos
    if (this.nota < aluno.nota)
      return -1;
    if (this.nota > aluno.nota)
      return 1;

    return 0;
  }

  /**
   * Imprime os atributos do aluno.
   */
  public void imprimir() {
    System.out.println("Nome:" + getNome() + ", Nota:" + getNota());
  }
}
