package exemplos.oo.sobrecarga;

public class Main {

  public static void main(String[] args) {

    Pedido pedido = new Pedido(123, 23052011, 456);
    pedido.itens[0] = new Item();
    Item item = pedido.itens[0];
    Produto produto = new Produto(123, "Produto 1", 100.0f);
    item.produto = produto;

    System.out.println(pedido.numero);
  }
}
