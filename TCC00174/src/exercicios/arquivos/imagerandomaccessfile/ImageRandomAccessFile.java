package exercicios.arquivos.imagerandomaccessfile;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Image Random Access File
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class ImageRandomAccessFile {

  /**
   * Le um arquivo binario com um imagem em preto e branco e corrompe com ruido
   * usando acesso direto. No arquivo binario, preto é representado pelo byte 0
   * e branco pelo byte 255. O ruido é introduzido em posicoes aleatórias e
   * especificado pelo valor 128.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    // Cria uma imagem em tons de cinza
    ImageRawGrayScale image = new ImageRawGrayScale(64, 64);
    // Carrega do arquivo
    image.load("pic.raw");
    // Imprime no console
    image.print();
    // Salva em arquivo
    image.save("picnoise.raw");

    // Cria um arquivo de acesso randômico
    RandomAccessFileIO randomAccessFile = new RandomAccessFileIO();
    // Abre o arquivo
    randomAccessFile.open("picnoise.raw", "rw");
    // Inclui ruído ao arquivo
    randomAccessFile.addNoise(0.1);
    // Fecha o arquivo
    randomAccessFile.close();

    // Cria uma nova imagem em tons de cinza
    ImageRawGrayScale image2 = new ImageRawGrayScale(64, 64);
    // Lê a imagem
    image2.load("picnoise.raw");
    // Imprime a imagem
    image2.print();
  }
}
