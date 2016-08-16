package exercicios.datastructures.listasGenericas;

public class Lista<Tipo> {

  String nome;
  private NoLista<Tipo> cabeca;
  private NoLista<Tipo> cauda;

  Lista(String nome) {
    this.nome = nome;
    cabeca = null;
    cauda = null;
  }

  public boolean vazia() {
    return (cabeca == null);
  }

  public void inserirInicio(Tipo elem) {
    if (vazia())
      cauda = cabeca = new NoLista(elem, null);
    else
      cabeca = new NoLista(elem, cabeca);
  }

  public Tipo removerInicio() {

    if (vazia())
      return null;

    Tipo elem = cabeca.elem;
    if (cabeca == cauda)
      cabeca = cauda = null;
    else
      cabeca = cabeca.prox;

    return elem;

  }

  public void inserirFinal(Tipo elem) {
    if (vazia())
      cauda = cabeca = new NoLista(elem, null);
    else
      cauda = cauda.prox = new NoLista(elem, null);
  }

  public Tipo removerFinal() {
    if (vazia())
      return null;

    Tipo elem = cauda.elem;

    if (cabeca == cauda)
      cauda = cabeca = null;
    else {
      NoLista<Tipo> ant, curr;
      ant = null;
      curr = cabeca.prox;
      while (curr != null) {
        ant = curr;
        curr = curr.prox;
      }
      cauda = ant;
      cauda.prox = null;
    }

    return elem;
  }

  public void imprimir() {
    NoLista<Tipo> aux;
    aux = cabeca;

    while (aux != null) {
      System.out.print(aux + " ");
      aux = aux.prox;
    }
    System.out.println();
  }

  public Tipo buscar(Tipo elem) {
    NoLista<Tipo> aux = cabeca;
    while (aux != null)
      if (aux.elem == elem)
        return aux.elem;
      else
        aux = aux.prox;

    return null;
  }
}
