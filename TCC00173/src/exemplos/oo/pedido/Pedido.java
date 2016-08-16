package exemplos.oo.pedido;

public class Pedido {

  public int numero;
  public int data;
  public Item[] itens = new Item[10];

  public Pedido(int numero, int data) {
    this.numero = numero;
    this.data = data;
  }

  public void addItem(Item item) {
    for (int i = 0; i < itens.length; i++)
      if (itens[i] == null) {
        itens[i] = item;
        return;
      }
    System.out.println("não ha mais espaco");
  }

  public float valor() {
    float valor = 0;
    for (int i = 0; i < itens.length || itens[i] == null; i++)
      valor += itens[i].valor();
    return valor;
  }
}
