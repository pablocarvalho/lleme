package exemplos.pedido2;

public class Main {

  public static void main(String[] args) {
    Produto prod = new Produto(10, 23.0, "Telefone");
    Produto prod2 = new Produto(11, 30.0, "Celular");
    Item item = new Item(prod, 2, "2222");
    Item item3 = item;
    Item item2 = new Item(prod2, 1);
    Item[] itens = new Item[2];
    itens[0] = item;
    itens[1] = item2;
    Compra compra = new Compra(23, itens);
  }
}
