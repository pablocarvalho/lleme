package uff.ic.lleme.tic10002.trabalhos.s20171.Emerson_Souza;

public class No {

    public Venda conteudo;
    public No esquerda;
    public No direita;
    public No pai;
    public int balanceamento;

    public No(Venda conteudo) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setConteudo(conteudo);
    }

    public Venda getConteudo() {
        return conteudo;
    }

    public void setConteudo(Venda conteudo) {
        this.conteudo = conteudo;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public No getPai() {
        return pai;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }

    public No getDireita() {
        return direita;
    }

    public No setDireita(No direita) {
        this.direita = direita;
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}
