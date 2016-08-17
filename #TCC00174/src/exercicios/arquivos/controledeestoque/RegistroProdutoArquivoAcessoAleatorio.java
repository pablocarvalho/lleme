package exercicios.arquivos.controledeestoque;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Registro Produto
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class RegistroProdutoArquivoAcessoAleatorio extends Produto {

  public final int TAMANHOREGISTRO = 46;
  public final int TAMANHONOME = 15;

  /**
   * Construtor padrão
   */
  RegistroProdutoArquivoAcessoAleatorio() {
    this("não cadastrado ", 0, 0.0, 0);
  }

  ;
    
    /**
     * Construtor padrão
     * 
     * @param nome Nome do produto
     * @param codigo Código do produto
     * @param preco Preço do produto
     * @param quantidade Quantidade em estoque
     */
    RegistroProdutoArquivoAcessoAleatorio(String nome, int codigo, double preco, int quantidade) {
    super(nome, codigo, preco, quantidade);
  }

  /**
   * Leitura do nome do produto
   *
   * @param file Objeto Random Access File
   * @return o nome do produto
   */
  private String readNome(RandomAccessFile file) {
    char[] name = new char[TAMANHONOME];
    try {
      for (int i = 0; i < TAMANHONOME; i++)
        name[i] = file.readChar();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return String.valueOf(name);
  }

  /**
   * Leitura do nome do produto
   *
   * @param file Objeto Random Access File
   * @param o nome do produto
   */
  private void writeNome(RandomAccessFile file, String nome) {
    try {
      int maxTam = (nome.length() > TAMANHONOME ? TAMANHONOME : nome.length());
      for (int i = 0; i < maxTam; i++)
        file.writeChar(nome.charAt(i));

      for (int i = maxTam; i < TAMANHONOME; i++)
        file.writeChar(' ');

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Leitura de um registro posição pos
   *
   * @param file Objeto Random Access File
   * @param pos posição da leitura
   */
  public void read(RandomAccessFile file, int pos) {
    try {
      // Busca pela posicao de leitura
      file.seek(pos * TAMANHOREGISTRO);
      // Leitura do nome
      String nome = readNome(file);
      setNome(nome);

      // Leitura do código
      int cod = file.readInt();
      setCodigo(cod);

      // Leitura do preço
      double preco = file.readDouble();
      setPreco(preco);

      // Leitura da quantidade em estoque
      int quantidade = file.readInt();
      setQuantidade(quantidade);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Escrita de um registro posição pos
   *
   * @param file Objeto Random Access File
   * @param pos posição da escrita
   */
  public void write(RandomAccessFile file, int pos) {
    try {
      // Busca pela posicao de escrita
      file.seek(pos * TAMANHOREGISTRO);
      // escreve o nome
      writeNome(file, getNome());

      // escreve o código
      int cod = getCodigo();
      file.writeInt(cod);

      // escreve o preço
      double preco = getPreco();
      file.writeDouble(preco);

      // escreve a quantidade em estoque
      int quantidade = getQuantidade();
      file.writeInt(quantidade);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
