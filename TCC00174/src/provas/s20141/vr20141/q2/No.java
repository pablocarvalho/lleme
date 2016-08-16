package provas.s20141.vr20141.q2;

public class No<T extends Comparavel> {

    public No<T> anterior;
    public No<T> proximo;
    public T objeto;

    public No(No<T> anterior, No<T> proximo, T objeto) {
        this.anterior = anterior;
        this.proximo = proximo;
        this.objeto = objeto;
    }

}
