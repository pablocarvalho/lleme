package exercicios.arquivos.histogrambuilder;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Histrogram
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Histogram {

  long[] levels;
  private final int size; //> Tamanho do histograma

  /**
   * Construtor.
   *
   * @param size Tamanho do histograma.
   */
  public Histogram(int size) {
    this.size = size;
    levels = new long[size];
    for (int i = 0; i < size; i++)
      levels[i] = 0;
  }

  /**
   * Adiciona uma entrada ao nível i.
   *
   * @param i índice do nível.
   */
  void incLevel(int i) {
    levels[i]++;
  }

  /**
   * Imprime o histograma.
   */
  void print() {
    for (int i = 0; i < 255; i++) {
      System.out.print("Level " + i + "=" + levels[i] + "-");
      for (int j = 0; j < levels[i] / 20; j++)
        System.out.print('+');
      System.out.println();
    }
  }
}
