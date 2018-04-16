package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_e_Uchoa;

public class ListaEncadeada<T extends Elemento<?, ?>> {

    int tamanho = 0;
    protected No<T> lista = null;

    public static class No<T extends Elemento<?, ?>> {

        public T objeto;
        public No<T> proximo = null;

        public No(T objeto) {
            this.objeto = objeto;
        }
    }

    public boolean vazia() {
        return this.lista == null;
    }

    public T busca(T obj) {
        No<T> aux = lista;

        while (aux != null) {
            if (aux.objeto.getChave().equals(obj.getChave()))
                return aux.objeto;
            aux = aux.proximo;
        }

        return null;
    }

    public void insere(T e) {

        if (this.lista == null)
            this.lista = new No<T>(e);
        else {
            No<T> aux = this.lista;
            while (aux.proximo != null)
                aux = aux.proximo;
            aux.proximo = new No<T>(e);
        }
        tamanho++;
    }

    public T remove(int index) {

        No<T> aux = this.lista;

        boolean indexValido = (index >= 0 && index < tamanho);

        if (!vazia() && indexValido) {
            for (int i = 0; i < index - 1; i++)
                aux = aux.proximo;
            No<T> retorno = aux.proximo;
            aux.proximo = aux.proximo.proximo;
            tamanho--;

            return retorno.objeto;
        }

        return null;
    }

}
