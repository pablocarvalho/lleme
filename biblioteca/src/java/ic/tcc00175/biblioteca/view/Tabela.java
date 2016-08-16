package ic.tcc00175.biblioteca.view;

import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.BusinessObjectCollection;

public abstract class Tabela {

    private BusinessObjectCollection colecao = null;
    private int linhas = 0;
    private int pos = 0;

    public abstract String getTabela();

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = (pos < 0 ? 0 : (pos > colecao.size() ? getPos() : pos));
    }

    public Tabela(BusinessObjectCollection colecao) {
        this.colecao = colecao;
    }

    public Tabela() {
        // TO DO
    }

    public void next() {
        setPos(getPos() + this.linhas);
    }

    public void back() {
        setPos(getPos() - this.linhas);
    }

    public void begin() {
        setPos(0);
    }

    public void end() {
        setPos(colecao.size() - this.linhas);
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public BusinessObjectCollection getColecao() {
        return colecao;
    }

    public void setColecao(BusinessObjectCollection colecao) {
        this.colecao = colecao;
    }
}