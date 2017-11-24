package uff.ic.lleme.tic10002.trabalhos.s20171.Wagner_Oliveira;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEncadeada<K, Entidade extends TemChave> implements Iterable<Entidade> {

    private class Node {

        public Entidade conteudo = null;
        public Node proximo = null;

        public Node(Entidade conteudo) {
            this.conteudo = conteudo;
        }
    }

    private Node primeiro = null;
    private Node ultimo = null;
    private Integer tam = 0;

    public void incluir(Entidade ent) {
        Node novo = new Node(ent);
        tam++;
        if (ultimo != null) {
            ultimo.proximo = novo;
            ultimo = novo;
        } else {
            primeiro = new Node(ent);
            ultimo = primeiro;
        }
    }

    public void incluir(ListaEncadeada lista) {
        tam = tam + lista.tam;
        if (ultimo != null) {
            ultimo.proximo = lista.primeiro;
            ultimo = lista.ultimo;
        } else {
            primeiro = lista.primeiro;
            ultimo = lista.ultimo;
        }
    }

    public Entidade removover(K chave) {
        Node atual = primeiro;
        Node anterior = null;
        while (atual.proximo != null && (atual.conteudo.getChave().equals(chave))) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual.conteudo.getChave().equals(chave)) {
            //se esta na primeira posicao
            if (anterior == null)
                primeiro = atual.proximo; //se esta numa posicao do meio
            else
                anterior.proximo = atual.proximo;
            return atual.conteudo;
        }
        //não achou
        return null;
    }

    public Entidade buscar(K chave) {
        Node atual = primeiro;
        while (atual.proximo != null && (!atual.conteudo.getChave().equals(chave)))
            atual = atual.proximo;
        if (atual.conteudo.getChave().equals(chave))
            return atual.conteudo;
        return null;
    }

    public Integer tamanho() {
        return tam;
    }

    public void print() {
        System.out.println("*****LISTA************");
        Node atual = primeiro;
        System.out.println(atual.conteudo);
        while (atual.proximo != null) {
            atual = atual.proximo;
            System.out.println(atual.conteudo);
        }
    }

    @Override
    public Iterator<Entidade> iterator() {
        return new ListaEncadeadaIterator(this.primeiro);
    }

    class ListaEncadeadaIterator implements Iterator<Entidade> {

        Node corrente;

        public ListaEncadeadaIterator(Node current) {
            this.corrente = current;
        }

        public boolean hasNext() {
            if (this.corrente != null)
                return true;
            else
                return false;
        }

        public Entidade next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Entidade conteudo = this.corrente.conteudo;
            this.corrente = this.corrente.proximo;
            return conteudo;
        }
    }
}
