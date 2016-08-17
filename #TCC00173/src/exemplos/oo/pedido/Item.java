package exemplos.oo.pedido;

public class Item {

  public int qtd;
  public Produto produto;

  public Item(int qtd, Produto produto) {
    this.qtd = qtd;
    this.produto = produto;
  }

  public float valor() {
    return produto.preco * qtd;
  }
}
