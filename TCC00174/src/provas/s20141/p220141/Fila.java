package provas.s20141.p220141;

public class Fila {

  private int inicio = -1;
  private int fim = -1;
  private Vetor vetor = new Vetor();

  public void enfilera(Venda venda) {
    if (inicio < 0)
      inicio++;
    vetor.atualizar(++fim, venda);
  }

  public Venda desenfilera() {
    Venda venda = null;
    if (inicio >= 0) {
      venda = vetor.obter(inicio);
      if (venda != null)
        vetor.atualizar(inicio++, null);
    }
    return venda;
  }
}
