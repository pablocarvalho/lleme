package exemplos.oo.sobrecarga;

public class Item {

  public Produto produto;
  public int qtd;

  public float valor() {
    return produto.preco;
  }
}
