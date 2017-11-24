/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Thiago_Malheiros.arvore;

/**
 *
 * @author Thiago Malheiros Porcino
 */
//Cada No do tipo lista Encadeada possui um objeto VENDA e um ponteiro para o
//proximo
public class NoListaEncadeada {

    public Venda vendaObject;
    public NoListaEncadeada proximo;

    public NoListaEncadeada(String s0, String s1, String s2, String s3) {
        vendaObject = new Venda(s0, s1, s2, s3);

        proximo = null;
    }

}
