/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package trabalho.mario;

/**
 *
 * @author Mario João Jr.
 */
public class NoAVL {
    int info;
    NoAVL esq = null;
    NoAVL dir = null;
    ListaFluxo    lista;
    int altura = 0;

    public NoAVL(TFluxo info) {
        TSetorDia   sd;
        this.info = info.fluxo;
        this.altura = 1;
        this.lista = new ListaFluxo ();
        sd = new TSetorDia (info.setor, info.dia);
        this.lista.inserir(sd);
    }
}
