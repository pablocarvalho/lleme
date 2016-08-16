package exemplos.listas;

public class No2<T> {

  private T dado = null;
  private No2<T> proximo = null;
  private No2<T> anterior = null;

  public T getDado() {
    return dado;
  }

  public void setDado(T dado) {
    this.dado = dado;
  }

  public No2<T> getProximo() {
    return proximo;
  }

  public void setProximo(No2<T> proximo) {
    this.proximo = proximo;
  }
  
  public No2<T> getAnterior() {
    return anterior;
  }

  public void setAnterior(No2<T> anterior) {
    this.anterior = anterior;
  }

  public void imprimir() {
    if (dado != null) {
      System.out.println(dado.toString());
      proximo.imprimir();
    }
  }
}
