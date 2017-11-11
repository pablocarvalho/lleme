/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.sydneyaraujo;

/**
 *
 * @author SidneyMelo
 */
public class NoLista {

    private int chave;
    private Object conteudo;
    public NoLista anterior;
    public NoLista proximo;

    public NoLista(int chave, Object conteudo) {
        this.chave = chave;
        this.conteudo = conteudo;
    }

    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    public Object getConteudo() {
        return this.conteudo;
    }
}
