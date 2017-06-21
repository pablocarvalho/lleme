package uff.ic.lleme.tic10002.trabalhos._20171.carlosdantas;

public class ListaVendas {

    private class No {

        Venda venda;
        No prox;

        public No(Venda venda) {
            this.venda = venda;
            prox = null;
        }
    }

    private No no;

    public ListaVendas() {
        no = null;
    }

    public void insere(Venda venda) {
        No novo = new No(venda);
        if (no == null)
            no = novo;
        else {
            novo.prox = no;
            no = novo;
        }
    }

    public float somaVendas() {
        float valor = 0;
        No aux = no;
        while (aux != null) {
            valor += aux.venda.getValor();
            aux = aux.prox;
        }
        return valor;
    }

    private No getPrim() {
        return no;
    }

    public void copyList(ListaVendas lista) {
        No aux = lista.getPrim();
        while (aux != null) {
            No novo = new No(aux.venda);
            if (no == null)
                no = novo;
            else {
                novo.prox = no;
                no = novo;
            }
            aux = aux.prox;
        }
    }

    public Venda pop() {
        Venda v = null;
        if (no != null) {
            v = no.venda;
            no = no.prox;
        }
        return v;
    }
}
