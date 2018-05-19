package uff.ic.lleme.tic10002.aulas._old.s20171.lista;

import uff.ic.lleme.tic10002.aulas._old.s20171.ColecaoEmpregado;
import uff.ic.lleme.tic10002.aulas.utils.Empregado;

public class ListaEstaticaEmpregado implements ColecaoEmpregado {

    private final Empregado[] lista = new Empregado[1000];
    private int tamanho = 0;

    public int tamanho() {
        return tamanho;
    }

    @Override
    public Empregado incluir(Empregado emp) {
        if (tamanho < lista.length) {
            for (int i = 0; i < tamanho; i++)
                if (lista[i].chave().equals(emp.chave()))
                    return null;
            return lista[tamanho++] = emp;
        } else
            throw new IndexOutOfBoundsException();

    }

    public void trocar(int i, int j) {
        Empregado aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    public void alterar(int pos, Empregado elem) {
        if (elem != null && elem.chave() != null)
            if (pos < lista.length)
                lista[pos] = elem;
            else
                throw new IndexOutOfBoundsException();
        else
            throw new NullPointerException();
    }

    @Override
    public Empregado excluir(Integer cpf) {
        Empregado resultado = null;
        for (int i = 0; i < tamanho; i++) {
            if (resultado == null && lista[i].chave().equals(cpf))
                resultado = lista[i];

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
    public Empregado buscar(Integer cpf) {
        for (int i = 0; i < tamanho; i++)
            if (lista[i].chave().equals(cpf))
                return lista[i];
        return null;
    }

    public void merge(int p, int q, int r) {
        if (0 <= p && p <= q && q < r && r < tamanho) {
            Empregado[] merge = new Empregado[r - p + 1];
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
