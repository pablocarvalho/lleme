package exemplos.oo.teste;

public class Compra {

  public int id;
  public Item[] itens = new Item[10];

  public Item incluirItem(Item item) {
    for (int i = 0; i < itens.length; i++)
      if (itens[i] == null)
        return itens[i] = item;
    return null;
  }

  public float valorTotal() {
    float total = 0;
    for (int i = 0; i < itens.length && itens[i] != null; i++)
      total += itens[i].valorTotal();
    return total;
  }
}
