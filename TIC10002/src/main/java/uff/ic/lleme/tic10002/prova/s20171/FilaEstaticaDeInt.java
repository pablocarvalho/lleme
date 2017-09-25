package uff.ic.lleme.tic10002.prova.s20171;

public class FilaEstaticaDeInt extends ListaEstatica {

    public FilaEstaticaDeInt(int tamanho) {
        super(tamanho);
    }

    public Integer enfileirar(int elemento) {
        return super.incluir(elemento);
    }

    public Integer desenfileirar() {
        return super.excluir(0);
    }

}
