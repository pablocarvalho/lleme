/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Picos de um terreno
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.introducao;

public class PeaksMain {

  /**
   * Calcula os picos de um terreno.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {

    // Descricao do terreno
    double[][] heights = {{1.0, 1.0, 1.0, 4.0, 2.0, 0.0, 0.0, 0.0},
      {1.0, 3.0, 8.0, 4.0, 3.0, 1.0, 0.0, 2.0},
      {1.0, 2.0, 1.0, 4.0, 3.0, 0.0, 1.0, 0.0},
      {2.0, 5.0, 7.0, 3.0, 1.0, 4.0, 4.0, 3.0},
      {2.0, 2.0, 4.0, 5.0, 1.0, 2.0, 7.0, 6.0},
      {3.0, 1.0, 2.0, 2.0, 1.0, 1.0, 3.0, 4.0},
      {9.0, 8.0, 7.0, 5.0, 3.0, 6.0, 1.0, 2.0},
      {1.0, 1.0, 2.0, 4.0, 1.0, 3.0, 5.0, 1.0}};

    PeaksTerrain terrain = new PeaksTerrain(8, 8, heights);
    terrain.findPeaks(3);
    terrain.printPeaks();
  }
}
