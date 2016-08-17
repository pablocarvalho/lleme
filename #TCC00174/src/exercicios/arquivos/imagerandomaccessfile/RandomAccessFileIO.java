package exercicios.arquivos.imagerandomaccessfile;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe RandomAccessFileIO
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.*;

public class RandomAccessFileIO {

  /**
   * Objeto Random Access File.
   */
  private RandomAccessFile raf = null;

  /**
   * Contruturo padrao
   */
  public RandomAccessFileIO() {
  }

  /**
   * Abre um arquivo de acesso randômico.
   *
   * @param filename Nome do arquivo
   * @param ioArgs Parâmetros de abertura
   */
  public void open(String fileName, String ioArgs) {
    if (raf == null)
      try {
        raf = new RandomAccessFile(fileName, ioArgs);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
  }

  /**
   * Fecha um arquivo de acesso randômico.
   */
  public void close() {
    if (raf != null)
      try {
        raf.close();
        raf = null;
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  /**
   * Escreve em um arquivo de acesso randômico.
   *
   * @param pos Posição de início da escrita
   * @param value Valor a ser escrito
   */
  public void write(int pos, int value) {
    try {
      raf.seek(pos);
      raf.write(value);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Leitura de um arquivo de acesso randômico.
   *
   * @param pos Posição de início da leitura
   * @return Valor lido
   */
  public int read(int pos) {
    int val = -1;
    try {
      raf.seek(pos);
      val = raf.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return val;
  }

  /**
   * Adiciona ruido a imagem
   *
   * @param percentage Quantidade de pixels afetados
   */
  public void addNoise(double percentage) {
    try {
      for (int i = 0; i < raf.length() * percentage; i++) {
        int pos = (int) (Math.random() * (double) raf.length());
        raf.seek(pos);
        raf.writeByte(128);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
