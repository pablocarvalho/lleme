package provas.s20111.p220111ex2;

public class Item {

  public int qtd;
  public float valorUnit;

  public Item(int qtd, float valorUnit) {
    this.qtd = qtd;
    this.valorUnit = valorUnit;
  }

  public float getValor() {
    return qtd * valorUnit;
  }
}
