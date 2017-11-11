/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.mariojoao;

/**
 *
 * @author Mario João Jr.
 */
public class TFluxo {

    int fluxo;
    int setor;
    int dia;

    public TFluxo(int fluxo, int setor, int dia) {
        this.fluxo = fluxo;
        this.setor = setor;
        this.dia = dia;
    }

    public int getChave() {
        return fluxo;
    }
}
