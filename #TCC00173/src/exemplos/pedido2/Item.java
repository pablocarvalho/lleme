package exemplos.pedido2;

public class Item {

  public Produto produto;
  public int qtd;
  public String hora;

  public Item(Produto produto, int qtd) {
    this.produto = produto;
    this.qtd = qtd;
  }

  public Item(Produto produto, int qtd, String hora) {
    this.produto = produto;
    this.qtd = qtd;
    this.hora = hora;
  }

  public double valor() {
    return produto.preco * qtd;
  }
}
