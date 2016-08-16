package exercicios.arquivos.controledeestoque;

/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Produto
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Produto {

  private String nome;   //> Nome do produto
  private int codigo;    //> Código do produto
  private double preco;  //> Preço do produto
  private int quantidade;//> Quantidade no estoque 

  /**
   * Construtor padrão
   */
  Produto() {
  }

  ;

    /**
     * Construtor 
     * 
     * @param nome Nome do produto 
     * @param codigo Código do produto
     * @param preco Preço do produto
     * @param quantidade Quantidade no estoque
     */
    Produto(String nome, int codigo, double preco, int quantidade) {
    this.nome = nome;
    this.codigo = codigo;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  /**
   * Acesso ao nome do produto.
   *
   * @return o nome do produto
   */
  public String getNome() {
    return nome;
  }

  /**
   * Atribuição do nome do produto.
   *
   * @return nome O nome do produto
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Acesso ao código do produto.
   *
   * @return o código do produto
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Atribuição do código do produto.
   *
   * @param codigo O código do produto
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Acesso ao preço do produto.
   *
   * @return o preço do produto
   */
  public double getPreco() {
    return preco;
  }

  /**
   * Atribuição do preço do produto.
   *
   * @param preco O preço do produto
   */
  public void setPreco(double preco) {
    this.preco = preco;
  }

  /**
   * Acesso à quantidade do produto no estoque.
   *
   * @return o quantidade do produto
   */
  public int getQuantidade() {
    return quantidade;
  }

  /**
   * Atribuiçao da quantidade do produto no estoque.
   *
   * @param quantidade A quantidade do produto
   */
  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}
