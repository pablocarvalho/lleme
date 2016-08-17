package provas.s20141.p320141.q1;

public class Lista<T> {

    private No primeiro;
    private No ultimo;

    public void incluir(T objeto) {
        No<T> no;
        if (ultimo == null) {
            no = new No(null, null, objeto);
            primeiro = no;
            ultimo = no;
        } else {
            no = new No(ultimo, null, objeto);
            ultimo.proximo = no;
            ultimo = no;
        }
    }

    public void intercalarCom(Lista<T> l) {
        if (l != null)
            if (this.estaVazia())
                receber(l);
            else {
                No<T> lCorrente = l.primeiro;
                No<T> lProximo = null;
                No<T> thisCorrente = this.primeiro;
                No<T> thisProximo = null;
                No<T> novoNo = null;
                while (lCorrente != null) {

                    thisProximo = thisCorrente.proximo;
                    lProximo = lCorrente.proximo;

                    novoNo = lCorrente;
                    novoNo.anterior = thisCorrente;
                    novoNo.proximo = thisProximo;

                    thisCorrente.proximo = novoNo;
                    if (thisProximo != null)
                        thisProximo.anterior = novoNo;

                    // andar
                    if (novoNo.proximo != null)
                        thisCorrente = novoNo.proximo;
                    else
                        thisCorrente = novoNo;
                    lCorrente = lProximo;

                }
            }
    }

    public Lista subdividirLista() {
        Lista l = new Lista();
        No<T> corrente = primeiro;
        No<T> proximo = null;
        No<T> pproximo = null;

        while (corrente != null) {
            proximo = corrente.proximo;
            pproximo = null;
            if (proximo != null)
                pproximo = proximo.proximo;

            if (l.primeiro == null && proximo != null) {
                // armazena o no na nova lista
                l.primeiro = proximo;
                l.ultimo = proximo;
                // desconecta o novo no
                proximo.proximo = null;
                proximo.anterior = null;
                // repontera a lista original
                corrente.proximo = pproximo;
                if (pproximo != null)
                    pproximo.anterior = corrente;
            } else if (proximo != null) {
                // transfere o novo no para l
                proximo.proximo = null;
                proximo.anterior = l.ultimo;
                l.ultimo.proximo = proximo;
                l.ultimo = proximo;
                // repontera lista original
                corrente.proximo = pproximo;
                if (pproximo != null)
                    pproximo.anterior = corrente;
            }
            corrente = pproximo;
        }
        return l;
    }

    public void receber(Lista<T> l) {
        if (l != null) {
            primeiro = l.primeiro;
            ultimo = l.ultimo;
        }
    }

    public boolean estaVazia() {
        return ultimo == null;
    }

    void imprimir() {
        No<T> thisCorrente = this.primeiro;
        System.out.print("{");
        while (thisCorrente != null) {
            if (thisCorrente.proximo != null)
                System.out.print(thisCorrente.objeto + ",");
            else
                System.out.print(thisCorrente.objeto + "");
            thisCorrente = thisCorrente.proximo;
        }
        System.out.println("}");
    }

}
