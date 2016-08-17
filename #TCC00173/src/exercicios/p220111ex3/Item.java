package exercicios.p220111ex3;

public class Item {

  public int qtd;
  public float valorUnitario;

  public Item(int qtd, float valorUnitario) {
    this.qtd = qtd;
    this.valorUnitario = valorUnitario;
  }

  public float valor() {
    return qtd * valorUnitario;
  }
}
