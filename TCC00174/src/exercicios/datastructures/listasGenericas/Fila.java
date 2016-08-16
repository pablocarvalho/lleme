/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.datastructures.listasGenericas;

/**
 *
 * @author ananmon
 */
public class Fila<Tipo> {

  private String nome;
  private Lista<Tipo> l;

  Fila(String nome) {
    this.nome = nome;
    l = new Lista<Tipo>("Lista interna usada na fila");
  }

  public boolean vazia() {
    return l.vazia();
  }

  public void insere(Tipo elem) {
    l.inserirFinal(elem);
  }

  public Tipo remove() {
    return l.removerInicio();
  }
}
