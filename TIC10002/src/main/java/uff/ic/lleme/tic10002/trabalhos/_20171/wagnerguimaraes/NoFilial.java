/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.wagnerguimaraes;

/**
 *
 * @author Wagner
 */
public class NoFilial {

    private NoFilial esquerda;
    private NoFilial direita;
    private NoFilial pai;
    private int chave;
    private Filial conteudo;
    private int balanceamento;
    private double SaldoAnual;
    private ListaEncadeadaMeses Meses = null;

    public NoFilial(Filial Filial) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setChave(Filial.filial);
        setFilial(Filial);
        setSaldoAnual(Filial.total_vendido);
        setMeses(Filial);
    }

    public NoFilial() {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setChave(0);
        setFilial(null);
    }

    public void setMeses(NoFilial conteudo) {
        if (Meses == null)
            Meses = new ListaEncadeadaMeses();
        Meses.Inserir(conteudo);
    }

    private void setMeses(Filial Filial) {
        NoFilial No = new NoFilial();
        No.setChave(Filial.filial);
        No.setFilial(Filial);
        No.setFilial(Filial);
        No.setSaldoAnual(Filial.total_vendido);
        Meses = new ListaEncadeadaMeses();
        Meses.Inserir(No);
    }

    public ListaEncadeadaMeses getMeses() {
        return Meses != null ? Meses : null;
    }

    public double getSaldoAnual() {
        return this.SaldoAnual;
    }

    public void setSaldoAnual(double Saldo) {
        this.SaldoAnual = this.SaldoAnual + Saldo;
    }

    public Filial getFilial() {
        return conteudo;
    }

    public void setFilial(Filial F) {
        conteudo = F;
    }

    public double getValorVendido() {
        return conteudo.total_vendido;
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

    public NoFilial getPai() {
        return pai;
    }

    public NoFilial setPai(NoFilial pai) {
        this.pai = pai;
        return pai;
    }

    public NoFilial getDireita() {
        return direita;
    }

    public NoFilial setDireita(NoFilial direita) {
        this.direita = direita;
        return direita;
    }

    public NoFilial getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoFilial esquerda) {
        this.esquerda = esquerda;
    }

}
