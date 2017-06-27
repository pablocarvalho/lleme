/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.wagneroliveira;

import uff.ic.lleme.tic10002.trabalhos.s20171.wagneroliveira.TemChave;

/**
 *
 * @author wlsantos
 * @param <Chave>
 * @param <Entidade>
 */
public class Hash<Chave extends Number, Entidade extends TemChave> {

    ListaEncadeada[] tabela;
    int TAM_TABELA = 31337;

    public Hash() {
        tabela = new ListaEncadeada[TAM_TABELA];
    }

    private int calculaHash(Integer k) {
        int calc = k.intValue() % TAM_TABELA;
        return calc;
    }

    public void put(Integer k, Entidade ent) {
        int pos = calculaHash(k);

        if (tabela[pos] == null)
            tabela[pos] = new ListaEncadeada<Chave, Entidade>();
        tabela[pos].incluir(ent);
    }

    public Entidade get(Integer k) {
        int pos = calculaHash(k);
        Entidade ent = null;
        ListaEncadeada listaEncadeada = tabela[pos];
        if (listaEncadeada != null)
            ent = (Entidade) listaEncadeada.buscar(k);
        return ent;
    }

    public void print() {
        System.out.println("IMPRIMI HASH");
        for (int i = 0; i < tabela.length; i++) {
            int quant = tabela[i] == null ? 0 : tabela[i].tamanho();
            System.out.println(i + " =>  " + quant);
        }
    }
}
