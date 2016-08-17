package oo;

public class Pilha<T> {

    private Object[] elementos = new Object[100];
    private int topo = -1;

    public void push(T elemento) {
        elementos[++topo] = elemento;
    }

    public void pop() {
        topo--;
    }

    public T top() {
        return (T) elementos[topo];
    }

    public boolean isEmpty() {
        return topo < 0;
    }
}
