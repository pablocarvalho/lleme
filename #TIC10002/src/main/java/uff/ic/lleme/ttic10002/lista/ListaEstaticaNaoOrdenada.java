package uff.ic.lleme.ttic10002.lista;

import java.util.function.Predicate;
import uff.ic.lleme.ttic10002.Entidade;

public class ListaEstaticaNaoOrdenada<K extends Comparable<K>, E extends Entidade<? super K, ?>> implements ListaEstatica<K, E> {

    private final Entidade[] lista = new Entidade[1000];
    private int tamanho = 0;

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void incluir(E elem) {
        if (elem != null && elem.getChave() != null)
            if (tamanho < lista.length) {
                for (int i = 0; i < tamanho; i++)
                    if (lista[i].getChave().equals(elem.getChave()))
                        return;
                lista[tamanho++] = elem;
            } else
                throw new IndexOutOfBoundsException();
        else
            throw new NullPointerException();
    }

    @Override
    public E excluir(K chave) {
        E resultado = null;
        for (int i = 0; i < tamanho; i++) {
            if (resultado == null && lista[i].getChave().equals(chave))
                resultado = (E) lista[i];

            if (resultado != null && i < tamanho - 1)
                lista[i] = lista[i + 1];
        }

        if (resultado != null) {
            lista[tamanho - 1] = null;
            tamanho--;
        }
        return resultado;
    }

    @Override
    public E buscar(K chave) {
        for (int i = 0; i < tamanho; i++)
            if (lista[i].getChave().equals(chave))
                return (E) lista[i];
        return null;
    }

    @Override
    public ListaEstaticaNaoOrdenada<K, E> buscar(Predicate<E> p) {
        ListaEstaticaNaoOrdenada<K, E> resultado = new ListaEstaticaNaoOrdenada<>();
        for (int i = 0; i < tamanho; i++)
            if (p.test((E) lista[i]))
                resultado.incluir((E) lista[i]);
        return resultado;
    }

    @Override
    public E buscar(int posicao) {
        if (tamanho > 0 && posicao >= 0 && posicao < tamanho)
            return (E) lista[posicao];
        return null;
    }

}
