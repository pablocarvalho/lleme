/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.sydneyaraujo;

/**
 *
 * @author SidneyMelo
 */
public class NoAvl {

    private NoAvl esquerda;
    private NoAvl direita;
    private NoAvl pai;
    private int chave;
    private int balanceamento;
    // CORRECAO: deveria ser uma lista
    private Object conteudo;

    public NoAvl(int chave) {
        setEsquerda(null);
        setDireita(null);
        setPai(null);
        setChave(chave);
        updateBalanceamento();
    }

    public NoAvl setEsquerda(NoAvl n) {
        this.esquerda = n;
        return this.esquerda;
    }

    public NoAvl getEsquerda() {
        return this.esquerda;
    }

    public NoAvl setDireita(NoAvl n) {
        this.direita = n;
        return this.direita;
    }

    public NoAvl getDireita() {
        return this.direita;
    }

    public NoAvl setPai(NoAvl n) {
        this.pai = n;
        return this.pai;
    }

    public NoAvl getPai() {
        return this.pai;
    }

    public int setChave(int chave) {
        this.chave = chave;
        return this.chave;
    }

    public int getChave() {
        return this.chave;
    }

    public int updateBalanceamento() {
        int b;
        if (this.getEsquerda() == null && this.getDireita() == null)
            b = 0;
        else if (this.getEsquerda() == null)
            b = this.getDireita().getAltura();
        else if (this.getDireita() == null)
            b = this.getEsquerda().getAltura();
        else
            b = this.getDireita().getAltura() - this.getEsquerda().getAltura();
        this.balanceamento = b;
        return this.balanceamento;
    }

    public int getBalanceamento() {
        return this.balanceamento;
    }

    public int getAltura() {
        if (this.getEsquerda() == null && this.getDireita() == null)
            return 0;
        else if (this.getEsquerda() == null)
            return 1 + this.getDireita().getAltura();
        else if (this.getDireita() == null)
            return 1 + this.getEsquerda().getAltura();
        else
            return 1 + Math.max(this.getEsquerda().getAltura(), this.getDireita().getAltura());
    }

    public Object setConteudo(Object o) {
        this.conteudo = o;
        return o;
    }

    public Object getConteudo() {
        return this.conteudo;
    }
}
