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
public class Lista {

    public NoLista inicio;
    public int tamanho;

    public Lista() {
        inicio = null;
        tamanho = 0;
    }

    public void inserir(NoLista no) {
        if (this.inicio == null)
            this.inicio = no;
        else {
            NoLista atual = this.inicio;
            while (atual.proximo != null)
                atual = atual.proximo;
            atual.proximo = no;
        }
        tamanho++;
    }
}
