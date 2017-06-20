/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.cleirissonsilva;

/**
 *
 * @author clerissonss
 */
public class NoLista {

    private Venda venda;
    private NoLista prox;

    public NoLista(Venda venda) {
        this.venda = venda;
        this.prox = null;
    }

    /**
     * @return the venda
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    /**
     * @return the prox
     */
    public NoLista getProx() {
        return prox;
    }

    /**
     * @param prox the prox to set
     */
    public void setProx(NoLista prox) {
        this.prox = prox;
    }

}
