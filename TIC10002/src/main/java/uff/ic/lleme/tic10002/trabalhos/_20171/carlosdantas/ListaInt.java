package uff.ic.lleme.tic10002.trabalhos._20171.carlosdantas;

/**
 *
 * @author Carlos
 */
public class ListaInt {

    private class No {

        private No prox;
        private int valor;

        public No(int valor) {
            this.valor = valor;
            prox = null;
        }
    }

    private No no;

    public ListaInt() {
        no = null;
    }

    public void insere(int valor) {
        No novo = new No(valor);

        if (no != null)
            novo.prox = no;
        no = novo;
    }

    public boolean contem(int valor) {
        No aux = no;
        while (aux != null) {
            if (aux.valor == valor)
                return true;
            aux = aux.prox;
        }
        return false;
    }

}
