/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.cleirissonsilva;

/**
 *
 * @author clerissonss
 */
public class ListaVenda {

    private NoLista primNo;
    private NoLista ultimoNo;
    private int qtdNos;
    private double totalVendidoFilial = 0;

    public ListaVenda() {
        this.primNo = null;
        this.ultimoNo = null;
        this.qtdNos = 0;
    }

    public NoLista getPrimNo() {
        return primNo;
    }

    public void setPrimNo(NoLista primNo) {
        this.primNo = primNo;
    }

    public NoLista getUltimoNo() {
        return ultimoNo;
    }

    public void setUltimoNo(NoLista ultimoNo) {
        this.ultimoNo = ultimoNo;
    }

    public int getQtdNos() {
        return qtdNos;
    }

    public void setQtdNos(int qtdNos) {
        this.qtdNos = qtdNos;
    }

    /**
     * *************************************************************************
     ** Todas as funções e procedimentospara inserir na Lista **
     * *************************************************************************
     */
    public void inserirNoInicio(Venda venda) {

        NoLista novoNoLista = new NoLista(venda);

        if (this.ehVazia())
            this.ultimoNo = novoNoLista;
        novoNoLista.setProx(this.primNo);
        this.primNo = novoNoLista;
        this.qtdNos++;
        //this.total += venda.getTotalVendido();
    }

    public boolean ehVazia() {
        return this.primNo == null;
    }

    /**
     * *************************************************************************
     ** Todas as funções e procedimentos busca na Lista **
     * *************************************************************************
     */
    public double buscarTotalVendidoPorData(int anoMesMenor, int anoMesMaior) {

        double totalVendidoPorData = 0;

        if (anoMesMenor > anoMesMaior) {
            int aux = anoMesMenor;
            anoMesMenor = anoMesMaior;
            anoMesMaior = aux;
        }

        NoLista atual = this.primNo;

        while ((atual != null)) {
            if (atual.getVenda().getAno_mes() >= anoMesMenor && atual.getVenda().getAno_mes() <= anoMesMaior)
                totalVendidoPorData += atual.getVenda().getTotalVendido();

            atual = atual.getProx();
        }

        return totalVendidoPorData;

    }

    public double buscarTotalVendidoFilial() {

        double totalVendidoFilial = 0;

        NoLista atual = this.primNo;

        while ((atual != null)) {
            totalVendidoFilial += atual.getVenda().getTotalVendido();
            atual = atual.getProx();

        }

        return totalVendidoFilial;

    }

    public double getTotalVendidoFilial() {
        return this.totalVendidoFilial;
    }

    /**
     * *************************************************************************
     ** Imprimi a Lista **
     * *************************************************************************
     */
    public String imprimir() {
        String msg = "";

        if (ehVazia())
            msg = "A lista está vazia";
        NoLista atual = this.primNo;

        while (atual != null) {
            msg += " <-[" + atual.getVenda().getCod_filial() + " " + atual.getVenda().getAno_mes() + " " + atual.getVenda().getCod_vendedor() + " " + atual.getVenda().getTotalVendido() + "]";
            atual = atual.getProx();
        }
        return msg;
    }

}
