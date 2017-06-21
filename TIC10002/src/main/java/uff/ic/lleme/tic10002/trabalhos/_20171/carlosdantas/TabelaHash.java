package uff.ic.lleme.tic10002.trabalhos._20171.carlosdantas;

/**
 *
 * @author Carlos
 */
public class TabelaHash {

    private final ListaInt[] lista = new ListaInt[331];
    private final int m = 331;

    public TabelaHash() {
        for (int i = 0; i < m; i++)
            lista[i] = new ListaInt();
    }

    public void insere(int valor) {
        int modo = valor % m;
        lista[modo].insere(valor);
    }

    public boolean contem(int valor) {
        int modo = valor % m;
        return lista[modo].contem(valor);
    }
}
