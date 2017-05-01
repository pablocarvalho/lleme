package uff.ic.lleme.tic10002.provas;

public class FilaEstaticaDeFilas extends ListaEstaticaDeFilas {

    public FilaEstaticaDeFilas(int tamanho) {
        super(tamanho);
    }

    public FilaEstaticaDeInt enfileirar(FilaEstaticaDeInt elemento) {
        return super.incluir(elemento);
    }

    public FilaEstaticaDeInt desenfileirar() {
        return super.excluir(super.tamanho());
    }
}
