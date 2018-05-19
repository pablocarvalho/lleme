package uff.ic.lleme.tic10002.aulas.s20171.lista;

import java.util.function.Predicate;
import uff.ic.lleme.tic10002.utils.Entidade;

public class ListaEstaticaOrdenada<K extends Comparable<K>, E extends Entidade<? super K, E>> implements ListaEstatica<K, E> {

    private final Entidade[] lista = new Entidade[1000];
    private int tamanho = 0;

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void incluir(E elem) {
        if (elem != null && elem.chave() != null)
            if (tamanho < lista.length)

                if (tamanho == 0)
                    lista[tamanho++] = elem;
                else {
                    int e = 0, d = tamanho - 1, m = 0;
                    do {
                        m = (e + d) / 2;
                        if (elem.chave().compareTo((K) lista[m].chave()) < 0)
                            d = m - 1;
                        else
                            e = m + 1;
                    } while (e <= d && !elem.chave().equals(lista[m].chave()));

                    int inicio = tamanho + 1;
                    if (elem.chave().compareTo((K) lista[m].chave()) < 0)
                        inicio = m;
                    else if (elem.chave().compareTo((K) lista[m].chave()) >= 0)
                        inicio = m + 1;

                    Entidade elem_ = elem, li_1;
                    for (int i = inicio; i < tamanho + 1; i++) {
                        li_1 = lista[i];
                        lista[i] = elem_;
                        elem_ = li_1;
                    }
                    tamanho++;
                }

            else
                throw new IndexOutOfBoundsException();
        else
            throw new NullPointerException();
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
        if (chave != null) {

            if (tamanho > 0) {
                int e = 0, d = tamanho - 1, m = 0;
                do {
                    m = (e + d) / 2;
                    if (chave.compareTo((K) lista[m].chave()) < 0)
                        d = m - 1;
                    else
                        e = m + 1;
                } while (e <= d && !chave.equals(lista[m].chave()));

                int inicio = tamanho;
                if (chave.equals(lista[m].chave())) {
                    resultado = (E) lista[m];
                    inicio = m;
                }

                for (int i = inicio; i < tamanho; i++) {
                    lista[i] = lista[i + 1];
                    lista[i + 1] = null;
                }
                tamanho--;
            }

        } else
            throw new NullPointerException();
        return resultado;
    }

    @Override
    public E buscar(K chave) {
        return buscarBinarioRecursivo(chave, 0, tamanho - 1);
        //return buscarSequencial(chave);
    }

    private E buscarBinarioNaoRecursivo(K chave) {
        E resultado = null;
        if (tamanho > 0) {
            int e = 0, d = tamanho - 1, m = 0;
            do {
                m = (e + d) / 2;
                if (chave.compareTo((K) lista[m].chave()) < 0)
                    d = m - 1;
                else
                    e = m + 1;
            } while (e <= d && !chave.equals(lista[m].chave()));

            if (chave.equals(lista[m].chave()))
                resultado = (E) lista[m];
        }
        return resultado;
    }

    private E buscarBinarioRecursivo(K chave, int e, int d) {
        E resultado = null;
        int m = (e + d) / 2;

        if (e > d)
            resultado = null;
        else if (chave.equals(lista[m].chave()))
            resultado = (E) lista[m];
        else if (chave.compareTo((K) lista[m].chave()) < 0)
            resultado = buscarBinarioRecursivo(chave, e, m - 1);
        else
            resultado = buscarBinarioRecursivo(chave, m + 1, d);

        return resultado;
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
