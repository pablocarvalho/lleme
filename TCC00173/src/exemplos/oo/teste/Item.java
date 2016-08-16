package exemplos.oo.teste;

public class Item {

  public int qtd;
  public Produto produto;

  public float valorTotal() {
    return qtd * produto.valor;
  }
}
