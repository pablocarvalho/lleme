package provas.s20111.p220111ex2v2;

public class Compra {

  public int codigo = 0;
  public Item[] itens = new Item[10];

  public Compra() {
  }

  public Compra(int codigo) {
    this.codigo = codigo;
  }

  public float valor() {
    float valor = 0;
    for (Item item : itens)
      if (item != null)
        valor += item.qtd * item.valor;
    return valor;
  }
}
