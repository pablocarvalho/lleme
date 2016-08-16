/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.datastructures.listasGenericas;

/**
 *
 * @author ananmon
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    Lista<Integer> lista = new Lista("Lista Inteiros");

    for (int i = 0; i < 10; i++)
      lista.inserirInicio(i);

    lista.removerFinal();

    lista.removerInicio();

    lista.imprimir();

    int i = lista.buscar(2);

    System.out.println(i);

    Pilha p = new Pilha<String>("Pilha de Strings");

    p.push("Naomi");
    p.push("Mika");
    p.push("Reika");
    p.push("Hikaru");

    while (!p.vazia())
      System.out.println(p.pop());

    Fila f = new Fila<Double>("Fila de doubles");

    f.insere(4.5);
    f.insere(3.2);
    f.insere(7.3);
    f.remove();
    f.remove();
    f.insere(3.7);

    while (!f.vazia())
      System.out.println(f.remove());


  }
}
