package provas.s20111.p220111ex2;

public class Compra {

  public int codigo;
  public Item[] itens = new Item[10];
  private int pos = 0;

  public Compra(int codigo) {
    this.codigo = codigo;
  }

  public void addItem(Item item) {
    itens[pos++] = item;
  }

  public float getValor() {
    float valor = 0;
    for (int i = 0; i < itens.length && itens[i] != null; i++)
      valor += itens[i].getValor();
    return valor;
  }
}
