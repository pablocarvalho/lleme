package exercicios.arquivos.histogrambuilder;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe HistrogramBuilder
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class HistogramBuilder {

  /**
   * Programa que lê um arquivo binário representando onde os byte representam
   * os tons de cinza de uma imagem, monta e imprime o seu histograma, isto é,
   * o grafico das frequências de ocorrência de cada tom na imagem.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    // Cria um novo objeto GrayScaleRawImage
    GrayScaleRawImage image = new GrayScaleRawImage(400, 500);
    // Lê a imagem
    image.load("co-bao.raw");
    // Constroi o histograma
    Histogram histogram = image.BuildHistogram();
    // Imprime o histrograma
    histogram.print();
    // Imprime a imagem
    // image.print();
  }
}
