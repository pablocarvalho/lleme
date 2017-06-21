/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.wesleyoliveira;

/**
 *
 * @author Wesley Oliveira
 */
public class ListaEncadeada {

    /// Criaçao da classe Nó
    public class NoLista {

        private Venda obj = null;
        private NoLista proximo = null;

        // Construtor especial
        NoLista(Venda venda) {
            this.obj = venda;
            this.proximo = null;
        }
    }

    public NoLista primeiro;
    public NoLista ultimo;
    int quantidade;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
        quantidade = 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean checkVazia() {
        if (getQuantidade() != 0)
            return false;
        return true;
    }

    public void adicionarNo(Venda venda) {
        NoLista no = new NoLista(venda);

        if (checkVazia()) {
            ultimo = no;
            primeiro = ultimo;
        } else {
            ultimo.proximo = no;
            ultimo = no;
        }
        quantidade++;
    }

    public int printLista() {
        NoLista aux = primeiro;
        int vendas = 0;
        int i = 1;
        if (checkVazia() == false)
            while (i <= getQuantidade()) {

                String ano = aux.obj.getdata().substring(0, 2);
                String mes = aux.obj.getdata().substring(2, 4);

                System.out.println("Filial: " + aux.obj.getfilial() + "  Data: " + mes + "/20" + ano + "  " + aux.obj.getvendedor() + "  Vendas: " + aux.obj.getvenda());
                vendas += Integer.parseInt(aux.obj.getvenda());
                aux = aux.proximo;
                i++;

            }

        return vendas;
    }
}
