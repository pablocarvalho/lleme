/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.mariojoao;

/**
 *
 * @author Mario João Jr.
 */
public class ListaHash {

    private class TNoListaHash {

        TAcumulado info;
        TNoListaHash prox;

        public TNoListaHash(TAcumulado info) {
            this.info = info;
            this.prox = null;
        }
    }

    private TNoListaHash cabeca;

    public ListaHash() {
        this.cabeca = null;
    }

    public boolean inserir(TAcumulado info) {
        TNoListaHash no;
        if (cabeca == null) {
            cabeca = new TNoListaHash(info);
            return true;
        }

        no = new TNoListaHash(info);
        no.prox = cabeca;
        cabeca = no;
        return true;
    }

    public TAcumulado buscar(int setor, int dia) {
        TNoListaHash p;

        for (p = cabeca; p != null; p = p.prox)
            if (p.info.setor == setor && p.info.dia == dia)
                return p.info;
        return null;
    }

}
