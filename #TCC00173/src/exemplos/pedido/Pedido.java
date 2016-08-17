package exemplos.pedido;

public class Pedido {

  public int id;
  public Produto produto = null;
  public int qtd;
  public Produto[] produtos;

  public Pedido() {
  }

  public float valor() {
    return qtd * produto.preco;
  }
}
