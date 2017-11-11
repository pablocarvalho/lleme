/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.mariojoao;

/**
 *
 * @author Mario João Jr.
 */
public class TAcumulado {

    int setor;
    int dia;
    int fini;
    int fatual;

    public TAcumulado(int setor, int dia) {
        this.setor = setor;
        this.dia = dia;
    }

    public TAcumulado(int setor, int dia, int fini, int fatual) {
        this.setor = setor;
        this.dia = dia;
        this.fini = fini;
        this.fatual = fatual;
    }

    public boolean eOriginal() {
        return fini == fatual;
    }

    public void acumula(int fluxo) {
        fatual += fluxo;
    }

    public void atualiza() {
        fini = fatual;
    }
}
