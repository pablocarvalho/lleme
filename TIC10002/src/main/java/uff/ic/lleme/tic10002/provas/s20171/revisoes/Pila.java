package uff.ic.lleme.tic10002.provas.s20171.revisoes;

/**
 *
 * @author jim_k
 */
public class Pila<E> {

    private class No<E> {

        No<E> siguiente;
        E dato;

        public No(E data) {
            dato = data;
            siguiente = null;
        }

    }
    No<E> ultimo;
    int tam;

    public Pila() {
        ultimo = null;
        tam = 0;
    }

    void push(E dat) {
        No nuevo = new No(dat);
        if (ultimo == null) {
            ultimo = nuevo;
        } else {
            nuevo.siguiente = ultimo;
            ultimo = nuevo;
        }
        tam++;
    }

    E pop() {
        No<E> tmp = ultimo;
        if (ultimo != null) {
            ultimo = ultimo.siguiente;
            return tmp.dato;
        } else {
            System.out.println("a Pilha esta vazia.");
            return null;
        }
    }

    int size() {
        return tam;
    }

}
