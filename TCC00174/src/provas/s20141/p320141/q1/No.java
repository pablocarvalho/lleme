package provas.s20141.p320141.q1;

public class No<T> {

    public No<T> anterior;
    public No<T> proximo;
    public T objeto;

    public No(No<T> anterior, No<T> proximo, T objeto) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.objeto = objeto;
    }

}
