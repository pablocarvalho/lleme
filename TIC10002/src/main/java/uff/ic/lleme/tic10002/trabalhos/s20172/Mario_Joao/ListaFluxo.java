/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.Mario_Joao;

/**
 *
 * @author Mario João Jr.
 */
public class ListaFluxo {

    private class TNo {

        TSetorDia info;
        TNo prox;

        public TNo(TSetorDia info) {
            this.info = info;
            this.prox = null;
        }
    }

    TNo cabeca;

    public ListaFluxo() {
        this.cabeca = null;
    }

    public boolean inserir(TSetorDia info) {
        TNo no;
        if (cabeca == null) {
            cabeca = new TNo(info);
            return true;
        }

        no = new TNo(info);
        no.prox = cabeca;
        cabeca = no;
        return true;
    }

    public void imprimir() {
        TNo p;

        for (p = cabeca; p != null; p = p.prox)
            System.out.print(p.info.toString());
    }

    public TSetorDia buscar(int setor, int dia) {
        TNo p;

        for (p = cabeca; p != null; p = p.prox)
            if (p.info.dia == dia && p.info.setor == setor)
                return p.info;
        return null;
    }

    public boolean listaVazia() {
        return cabeca == null;
    }

    public TSetorDia removePrimeiro() {
        TSetorDia no;

        if (cabeca == null)
            return null;

        no = cabeca.info;
        cabeca = cabeca.prox;
        return no;
    }

    public boolean remove(TFluxo info) {
        TNo p, ant;

        for (p = cabeca, ant = null; p != null; ant = p, p = p.prox)
            if (p.info.dia == info.dia && p.info.setor == info.setor) {
                if (ant == null)
                    cabeca = p.prox;
                else
                    ant.prox = p.prox;

                return true;
            }
        return false;

    }

}
