package uff.ic.lleme.tic10002.trabalhos.s20171.ricardo_bhering;

public class ListaVenda {

    protected int codFunc;
    protected double valor;
    // CORRECAO: deveria apontar para um no e nao uma lista
    protected ListaVenda proximo;

    public ListaVenda() {
        codFunc = -1;
        valor = 0.0;
        proximo = null;
    }

    protected void adicionar(int vendedor, double valorVenda) {
        if (this.codFunc == -1) {
            this.codFunc = vendedor;
            this.valor = valorVenda;
        } else {
            ListaVenda novaVenda = new ListaVenda();
            novaVenda.codFunc = vendedor;
            novaVenda.valor = valorVenda;
            ListaVenda aux = this;
            ListaVenda temp = aux.proximo;
            aux.proximo = novaVenda;
            novaVenda.proximo = temp;
        }
    }

    protected float somaVenda() {
        ListaVenda aux = this;
        float soma = 0;
        while (aux != null) {
            soma += aux.valor;
            aux = aux.proximo;
        }
        return soma;
    }
}
