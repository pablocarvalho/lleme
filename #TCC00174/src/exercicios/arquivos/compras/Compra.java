package exercicios.arquivos.compras;

public class Compra {

  private int codigo = 0;
  private Item[] itens = new Item[100];
  private int pos = 0;

  public Compra(int codigo) {
    this.codigo = codigo;
  }

  public void incluiItem(Item item) {
    getItens()[pos++] = item;
  }

  /**
   * @return the codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * @param codigo the codigo to set
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * @return the itens
   */
  public Item[] getItens() {
    return itens;
  }

  /**
   * @param itens the itens to set
   */
  public void setItens(Item[] itens) {
    this.itens = itens;
  }
}
