package exemplos.listas;

public class ListaFim<T> {

  private No2<T> primeiro;
  private No2<T> ultimo;
  private No2<T> corrente;
  private No2<T> ponteiro;
  private int tamanho;

  public void inserir(T dado) {
    No2<T> novoNo = new No2();
    novoNo.setDado(dado);
    novoNo.setAnterior(ultimo);

    ultimo.setProximo(novoNo);
    ultimo = novoNo;
    ponteiro = ultimo;
    tamanho++;
  }

  void inserir2(T dado) {
    No2<T> novoNo = new No2();
    novoNo.setDado(dado);
    novoNo.setAnterior(ponteiro.getAnterior());
    novoNo.setProximo(ponteiro.getProximo());

    No2<T> anterior = ponteiro.getAnterior();
    No2<T> proximo = ponteiro.getProximo();
    if (anterior != null)
      anterior.setProximo(novoNo);
    if (proximo != null)
      proximo.setAnterior(novoNo);

    ponteiro = anterior;
  }

  public T remover() {
    T dado = primeiro.getDado();
    if (primeiro != null)
      primeiro = primeiro.getProximo();
    return dado;
  }

  public void limpar() {
    primeiro = null;
  }

  public void imprimir() {
    primeiro.imprimir();
  }

  public void reset() {
    corrente = primeiro;
  }

  public T proximo() {
    if (corrente == null)
      return null;
    T dado = corrente.getDado();
    corrente = corrente.getProximo();
    return dado;
  }

  public int getTamanho() {
    return tamanho;
  }
}