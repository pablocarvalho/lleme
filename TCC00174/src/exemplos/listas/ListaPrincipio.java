package exemplos.listas;

public class ListaPrincipio<T> {

  private No<T> primeiro;
  private No<T> corrente;
  private int tamanho;

  public void inserir(T dado) {
    No<T> novoNo = new No();
    novoNo.setDado(dado);
    if (primeiro == null)
      primeiro = novoNo;
    else {
      novoNo.setProximo(primeiro);
      primeiro = novoNo;
    }
    tamanho++;
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