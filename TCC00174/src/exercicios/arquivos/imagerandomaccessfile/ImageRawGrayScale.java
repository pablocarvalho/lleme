package exercicios.arquivos.imagerandomaccessfile;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe ImageRawGrayScale
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageRawGrayScale {

  private int width, height; //> Comprimento e largura da imagem
  private int[] data;       //> Array com o tom de cinza em cada pixel

  /**
   * Construtor.
   *
   * @param width Largura da imagem.
   * @param height Altura da imagem.
   */
  public ImageRawGrayScale(int width, int height) {
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
        else if (grayLevel >= 128)
          System.out.print("++");
        else
          System.out.print("oo");
      }
      System.out.println();
    }
  }
}
