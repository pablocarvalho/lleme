package exercicios.p220111ex3;

public class Compra {

  public int codigo;
  public Item[] itens = new Item[10];
  public int cont = 0;

  public Compra(int codigo) {
    this.codigo = codigo;
  }

  public void addItem(Item item) {
    if (cont < itens.length)
      itens[cont++] = item;
  }

  public float valor() {
    float valor = 0;
    for (int i = 0; i < itens.length; i++)
      if (itens[i] != null)
        valor += itens[i].valor();
    return valor;
  }
}
