package exercicios.datastructures.listasGenericas;

public class Pilha<Tipo> {

  private String nome;
  private Lista<Tipo> l;

  Pilha(String nome) {
    this.nome = nome;
    l = new Lista<Tipo>("Lista interna usada na pilha");
  }

  public boolean vazia() {
    return l.vazia();
  }

  public void push(Tipo elem) {
    l.inserirInicio(elem);
  }

  public Tipo pop() {
    return l.removerInicio();
  }
}
