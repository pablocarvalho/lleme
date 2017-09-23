package uff.ic.lleme.tic10002.prova.s20171;

public class P120171Q5 extends ListaEstaticaDeFilas {

    public P120171Q5(int tamanho) {
        super(tamanho);
    }

    public FilaEstaticaDeInt enfileirar(FilaEstaticaDeInt elemento) {
        return super.incluir(elemento);
    }

    public FilaEstaticaDeInt desenfileirar() {
        return super.excluir(0);
    }
}
