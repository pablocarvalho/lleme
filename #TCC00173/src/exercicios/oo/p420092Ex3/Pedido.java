package exercicios.oo.p420092Ex3;

public class Pedido {

  public int numero;
  public Produto produto;
  public int qtd;

  public float calcPreco() {
    return produto.preco * qtd;
  }
}
