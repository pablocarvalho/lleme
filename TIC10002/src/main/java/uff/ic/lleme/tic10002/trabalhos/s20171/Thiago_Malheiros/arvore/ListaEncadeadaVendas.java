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
public class ListaEncadeadaVendas {

    public NoListaEncadeada primeiro;
    public NoListaEncadeada ultimo;
    int totalNos;

    //Construtor da classe
    public ListaEncadeadaVendas() {
        primeiro = null;
        ultimo = null;
        totalNos = 0;
    }

    //Metodo para retornar o primeiro No da lista
    public NoListaEncadeada getPrimeiroNo() {
        return primeiro;
    }

    //Metodo para retornar a quantidade de nos da lista
    public int getTotalNos() {
        return totalNos;
    }

    //Metodo para chegar se a lista ta vazia
    public boolean checkListaVazia() {
        if (getTotalNos() == 0)
            return true;
        return false;
    }

    //metodo para inserir um novo no no inicio da lista
    public void inserirNoInicio(NoListaEncadeada no) {
        if (checkListaVazia()) {

            ultimo = no;
            primeiro = ultimo;
        } else {
            no.proximo = primeiro;
            primeiro = no;
        }
        totalNos++;
    }

    //metodo para inserir um novo no no final da lista
    public void inserirNoFim(NoListaEncadeada no) {
        if (checkListaVazia()) {
            ultimo = no;
            primeiro = ultimo;
        } else {
            ultimo.proximo = no;
            ultimo = no;
        }
        totalNos++;
    }

    //metodo para inserir um novo no no final da lista
    public void inserirNoFim(String cod_filial, String cod_vendedor, String data, String total_vendido) {
        NoListaEncadeada no = new NoListaEncadeada(cod_filial, cod_vendedor, data, total_vendido);

        if (checkListaVazia()) {
            ultimo = no;
            primeiro = ultimo;
        } else {
            ultimo.proximo = no;

            ultimo = no;
        }
        totalNos++;
    }

    //metodo para excluir um no da lista
    public void excluirNo(NoListaEncadeada no) {
        NoListaEncadeada noAnterior = primeiro; //Como nao sei , atribuo ao no anterior o primeiro da lista
        NoListaEncadeada noAtual = noAnterior;  //Como nao sei, atribuo ao noAtual o primeiro da lista

        int contador = 0;
        if (checkListaVazia() == false) // verifico se a lista ta vazia

            //Varro a lista incrimentando o noAtual e o anterior ate que o calor seja igual ou termine a lista
            while (contador <= getTotalNos() && !noAtual.vendaObject.cod_Filial.equals(no.vendaObject.cod_Filial)) {
                noAnterior = noAtual;
                noAtual = noAtual.proximo;
                contador++;
            }

        //Se o o valor do noAtual for igual o valor do no passado por parametro
        if (noAtual.vendaObject.cod_Filial.equals(no.vendaObject.cod_Filial)) {
            //Se eu nao tiver elementos na lista atribuo nulo para primeiro e ultimo
            if (getTotalNos() == 0)
                ultimo = primeiro = null;
            else //se a lista tiver elementos
            if (noAtual == primeiro) // se buscado for o primeiro da lista

                primeiro = noAtual.proximo; //atualizo o primeiro no com o proximo.
            else //se nao for  o primeiro da lista

                noAnterior.proximo = noAtual.proximo; //atualizo o proximo do anterior
            totalNos--; //decremento minha lista
        }
    }

    //metodo que busca um no na lista
    public NoListaEncadeada procuraEleme(NoListaEncadeada no) {
        NoListaEncadeada noAtual = primeiro.proximo;

        while (noAtual != null) {
            if (noAtual.vendaObject.cod_Filial.equals(no.vendaObject.cod_Filial))
                return noAtual;
            noAtual = noAtual.proximo;
        }

        System.out.println("nao encontrado");
        return null;
    }

    public int exibirLista() {
        NoListaEncadeada temp = primeiro;
        int vendas = 0;
        int contador = 1;
        if (checkListaVazia() == false)
            while (contador <= getTotalNos()) {

                String data = temp.vendaObject.data;

                System.out.println("FILIAL: " + temp.vendaObject.cod_Filial + " DATA(mes/ano): " + data.substring(0, 2) + "/" + data.substring(2, 4) + " VENDAS: " + temp.vendaObject.total_Vendido);
                vendas += Integer.parseInt(temp.vendaObject.total_Vendido);
                temp = temp.proximo;
                contador++;

            }

        return vendas;
    }
}
