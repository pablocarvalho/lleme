package uff.ic.lleme.tic10002.provas;

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
