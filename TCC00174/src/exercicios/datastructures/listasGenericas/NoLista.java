/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.datastructures.listasGenericas;

/**
 *
 * @author ananmon
 */
public class NoLista<Tipo> {

  Tipo elem;
  NoLista<Tipo> prox;

  NoLista(Tipo elem, NoLista prox) {
    this.elem = elem;
    this.prox = prox;
  }

  @Override
  public String toString() {
    return "" + elem;
  }
}
