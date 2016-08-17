package exercicios.datastructures.pilhaGenerica;

public class Pilha<Item> {

  private int maxElems;
  private int topo;
  private Item[] elementos;

  Pilha(int maxElems) {
    this.maxElems = maxElems;
    elementos = (Item[]) new Object[maxElems];
    topo = -1;
  }

  public boolean vazia() {
    return (topo == -1);
  }

  public void push(Item elem) {
    try {
      elementos[++topo] = elem;
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Pilha cheia");
    }
  }

  public Item pop() {
    return elementos[topo--];
  }

  public int topo() {
    return topo;
  }
}
