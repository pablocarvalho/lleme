package uff.ic.lleme.tic10002.trabalhos._20171.gabrielalves;

public class ArvoreNo {

    public int balanceamento;
    public ArvoreNo esq;
    public ArvoreNo dir;
    public Venda conteudo;
    public ArvoreNo pai;

    public ArvoreNo back = null;
    public ArvoreNo next = null;

    public ArvoreNo(Venda conteudo) {
        setEsq(setDir(setPai(null)));
        setBalanceamento(0);
        setConteudo(conteudo);
        setNext(null);
        setBack(null);
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public ArvoreNo getPai() {
        return pai;
    }

    public ArvoreNo setPai(ArvoreNo pai) {
        this.pai = pai;
        return pai;
    }

    public ArvoreNo getDir() {
        return dir;
    }

    public ArvoreNo setDir(ArvoreNo dir) {
        this.dir = dir;
        return dir;
    }

    public ArvoreNo getEsq() {
        return esq;
    }

    public void setEsq(ArvoreNo esq) {
        this.esq = esq;
    }

    public ArvoreNo getNext() {
        return next;
    }

    public void setNext(ArvoreNo next) {
        this.next = next;
    }

    public ArvoreNo getBack() {
        return back;
    }

    public void setBack(ArvoreNo back) {
        this.back = back;
    }

    public Venda getConteudo() {
        return conteudo;
    }

    public void setConteudo(Venda conteudo) {
        this.conteudo = conteudo;
    }
}
