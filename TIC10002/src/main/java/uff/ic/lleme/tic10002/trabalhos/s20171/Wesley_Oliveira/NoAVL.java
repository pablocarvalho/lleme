/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Wesley_Oliveira;

/**
 *
 * @author Wesley Oliveira
 */
public class NoAVL {

    private NoAVL esquerda;
    private NoAVL direita;
    private NoAVL pai;
    private int chave;
    private ListaEncadeada lista = new ListaEncadeada();
    private int balanceamento;

    public NoAVL(int k) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setChave(k);
    }

    public NoAVL(int k, Venda venda) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setChave(k);
        setNovavenda(venda);
    }

    public String toString() {
        return Integer.toString(getChave());
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public NoAVL getPai() {
        return pai;
    }

    public NoAVL setPai(NoAVL pai) {
        this.pai = pai;
        return pai;
    }

    public NoAVL getDireita() {
        return direita;
    }

    public NoAVL setDireita(NoAVL direita) {
        this.direita = direita;
        return direita;
    }

    public NoAVL getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoAVL esquerda) {
        this.esquerda = esquerda;
    }

    public ListaEncadeada getLista() {
        return lista;
    }

    public void setNovavenda(Venda venda) {
        this.lista.adicionarNo(venda);
    }
}
