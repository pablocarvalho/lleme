package exemplos.oo.sobrecarga;

public class Pedido {

  public int numero;
  public int data;
  public int cliente;
  public Item[] itens = new Item[10];

  public Pedido() {
  }

  public Pedido(int numero, int data, int cliente) {
    this.numero = numero;
    this.data = data;
    this.cliente = cliente;
  }

  public float valor() {
    float valor = 0;
    for (int i = 0; i < itens.length; i++)
      if (itens[i] != null)
        valor += itens[i].qtd * itens[i].valor();
    return valor;
  }
}
