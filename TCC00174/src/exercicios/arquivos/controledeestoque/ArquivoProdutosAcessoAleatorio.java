package exercicios.arquivos.controledeestoque;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Arquivo de Produtos
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArquivoProdutosAcessoAleatorio {

  private RandomAccessFile file;
  final int TAMARQUIVO = 100;

  /**
   * Construtor padrão
   */
  ArquivoProdutosAcessoAleatorio() {
  }

  /**
   * Acesso ao objeto RandomAccessFile
   *
   * @return o objeto
   */
  public RandomAccessFile getFile() {
    return file;
  }

  /**
   * Abre um arquivo
   *
   * @param nomeArquivo Nome do arquivo a ser aberto
   * @param paramIO Modo de abertura
   */
  public void open(String nomeArquivo, String paramIO) {
    try {
      file = new RandomAccessFile(nomeArquivo, paramIO);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Criação de um registro vazio
   */
  public void criar() {
    RegistroProdutoArquivoAcessoAleatorio registro =
            new RegistroProdutoArquivoAcessoAleatorio();
    for (int i = 0; i < TAMARQUIVO; i++)
      registro.write(file, i);
  }

  /**
   * Escreve um registro
   *
   * @param registro Registro que será escrito no arquivo
   * @param pos Posição do registro
   */
  public void write(RegistroProdutoArquivoAcessoAleatorio registro, int pos) {
    registro.write(file, pos);
  }

  /**
   * Leitura de um registro
   *
   * @param registro Registro que será lido do arquivo
   * @param pos Posição do registro
   */
  public void read(RegistroProdutoArquivoAcessoAleatorio registro, int pos) {
    registro.read(file, pos);
  }

  /**
   * Fecha um arquivo \
   */
  public void close() {
    if (file != null)
      try {
        file.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}
