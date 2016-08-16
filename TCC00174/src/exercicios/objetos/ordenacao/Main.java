package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Ordenacao
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Main {

  /**
   * Testa as classes do programa de Ordenacao
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {

    // Array de alunos
    Aluno[] alunos = new Aluno[6];

    // Diferentes instancias da classe Aluno 
    alunos[0] = new Aluno("Anselmo", 4.0);
    alunos[1] = new Aluno("Andreia", 6.0);
    alunos[2] = new Aluno("Carlos", 3.5);
    alunos[3] = new Aluno("Pedro", 2.0);
    alunos[4] = new Aluno("Luis", 1.0);
    alunos[5] = new Aluno("Jose", 3.0);

    // Ordenacao dos alunos
    //InsertionSort.ordenar(alunos,6);
    SelectionSort.ordenar(alunos, 6);
    //BubbleSort.ordenar(alunos,6);

    // Saida
    for (int i = 0; i < alunos.length; i++)
      alunos[i].imprimir();
    System.out.println();

    // Leitura dos parametros dos automoveis
    Automoveis automoveis = Automoveis.lerTeclado();

    // Ordenacao dos automoveis
    SelectionSort.ordenar(automoveis.getColecao(), automoveis.getNumAutomoveis());
    //InsertionSort.ordenar(automoveis.getColecao(), automoveis.getNumAutomoveis());
    //BubbleSort.ordenar(automoveis.getColecao(), automoveis.getNumAutomoveis());

    // Saida
    automoveis.imprimir();
  }
}
