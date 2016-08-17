package exercicios.arquivos.histogrambuilder;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe GrayScaleRawImage
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class GrayScaleRawImage {

  private int width, height; //> Comprimento e largura da imagem
  private int[] data;       //> Array com o tom de cinza em cada pixel

  /**
   * Construtor.
   *
   * @param width Largura da imagem.
   * @param height Altura da imagem.
   */
  public GrayScaleRawImage(int width, int height) {
    this.width = width;
    this.height = height;
    this.data = new int[width * height];
  }

  /**
   * Acesso à Largura da imagem.
   *
   * @return Largura da imagem.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Acesso à Altura da imagem.
   *
   * @return Altura da imagem.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Acesso ao tom de cinza do pixel.
   *
   * @param i linha do pixel.
   * @param j coluna do pixel.
   * @return tom de cinza
   */
  public int getGrayLevel(int i, int j) {
    return data[i * width + j];
  }

  /**
   * Atribui um tom de cinza do pixel.
   *
   * @param i linha do pixel.
   * @param j coluna do pixel.
   * @param tom de cinza
   */
  public void setGrayLevel(int i, int j, int level) {
    data[i * width + j] = level;
  }

  /**
   * Carrega a imagem.
   *
   * @param filename Nome do arquivo
   */
  public void load(String fileName) {
    try {
      FileInputStream file = new FileInputStream(fileName);
      for (int i = 0; i < data.length; i++)
        data[i] = file.read();
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Salva a imagem.
   *
   * @param filename Nome do arquivo
   */
  public void save(String fileName) {
    try {
      FileOutputStream file = new FileOutputStream(fileName);
      for (int i = 0; i < data.length; i++)
        file.write(data[i]);
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Imprime os valores dos pixels da imagem.
   */
  public void print() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int grayLevel = getGrayLevel(i, j);
        if (grayLevel == 255)
          System.out.print("  ");
        else if (grayLevel > 0)
          System.out.print("++");
        else
          System.out.print("oo");
      }
      System.out.println();
    }
  }

  /**
   * Cria um histograma.
   *
   * @return retorna o histograma
   */
  public Histogram BuildHistogram() {

    Histogram histogram = new Histogram(256);
    for (int i = 0; i < width; i++)
      for (int j = 0; j < height; j++)
        histogram.incLevel(getGrayLevel(i, j));
    return histogram;
  }
}
