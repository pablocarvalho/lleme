package exercicios.oo.p420092Ex3_2;

public class Pedido {

  public Produto produto;
  public int numero;
  public int qtd;

  public float calcValor() {
    return qtd * produto.preco;
  }
}
