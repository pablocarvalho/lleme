package exemplos.listas;

public class No<T> {

  private T dado = null;
  private No<T> proximo = null;

  public T getDado() {
    return dado;
  }

  public void setDado(T dado) {
    this.dado = dado;
  }

  public No<T> getProximo() {
    return proximo;
  }

  public void setProximo(No<T> proximo) {
    this.proximo = proximo;
  }

  public void imprimir() {
    if (dado != null) {
      System.out.println(dado.toString());
      proximo.imprimir();
    }
  }
}
