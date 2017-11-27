package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_Uchoa;

public class TabelaDeDispersao<E extends Elemento<?, ?>> {

    ListaEstatica<ListaEncadeada<E>> lista;

    //... construtor.
    public TabelaDeDispersao(int tamanho) {
        lista = new ListaEstatica<ListaEncadeada<E>>(tamanho);

        for (int i = 0; i < tamanho; i++)
            lista.insere(new ListaEncadeada<E>());
    }

    private int hash(E obj) {
        int chave = obj.getHashCode();
        return chave % (lista.tamanho());
    }

    public E busca(E obj) {
        return lista.get(hash(obj)).busca(obj);
    }

    public void insere(E obj) {
        lista.get(hash(obj)).insere(obj);
    }

}
