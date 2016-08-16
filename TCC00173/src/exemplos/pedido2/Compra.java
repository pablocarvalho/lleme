package exemplos.pedido2;

public class Compra {

  public int codigo;
  public Item[] itens;

  public Compra(int codigo, Item[] itens) {
    this.codigo = codigo;
    this.itens = itens;
  }

  public double valor() {
    double valor = 0;
    for (int i = 0; i < itens.length; i++)
      valor += itens[i].valor();

    for (Item item : itens)
      valor += item.valor();
    return valor;
  }
}
