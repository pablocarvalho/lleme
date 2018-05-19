package uff.ic.lleme.tic10002.aulas.s20171.lista;

import java.util.function.Predicate;
import uff.ic.lleme.tic10002.utils.Entidade;

public class ListaEstaticaNaoOrdenada<K extends Comparable<K>, E extends Entidade<? super K, E>> implements ListaEstatica<K, E>, ListaNaoOrdenada<K, E> {

    private final Entidade[] lista = new Entidade[1000];
    private int tamanho = 0;

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void incluir(E elem) {
        if (elem != null && elem.chave() != null)
            if (tamanho < lista.length) {
                for (int i = 0; i < tamanho; i++)
                    if (lista[i].chave().equals(elem.chave()))
                        return;
                lista[tamanho++] = elem;
            } else
                throw new IndexOutOfBoundsException();
        else
            throw new NullPointerException();
    }

    @Override
    public void trocar(int i, int j) {
        Entidade aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    @Override
    public void alterar(int pos, E elem) {
        if (elem != null && elem.chave() != null)
            if (pos < lista.length)
                lista[pos] = elem;
            else
                throw new IndexOutOfBoundsException();
        else
            throw new NullPointerException();
    }

    @Override
    public E excluir(K chave) {
        E resultado = null;
        for (int i = 0; i < tamanho; i++) {
            if (resultado == null && lista[i].chave().equals(chave))
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
            if (lista[i].chave().equals(chave))
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

    @Override
    public void merge(int p, int q, int r) {
        if (0 <= p && p <= q && q < r && r < tamanho) {
            Entidade[] merge = new Entidade[r - p + 1];
            int i = p, j = q + 1, k = 0;
            while (i <= q || j <= r)
                if (i <= q && j <= r)
                    if (lista[i].compareTo(lista[j]) <= 0)
                        merge[k++] = lista[i++];
                    else
                        merge[k++] = lista[j++];
                else if (i <= q)
                    merge[k++] = lista[i++];
                else if (j <= r)
                    merge[k++] = lista[j++];

            i = p;
            for (k = 0; k < merge.length; k++)
                lista[i++] = merge[k];
        }
    }

}
