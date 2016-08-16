package exercicios.arquivos.compras;

public class Item {

  private int qtd = 0;
  private Produto produto = null;

  public Item(int qtd , Produto produto) {
    this.qtd=qtd;
    this.produto=produto;
  }

  public int getQtd() {
    return qtd;
  }

  public void setQtd(int qtd) {
    this.qtd = qtd;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }
}
