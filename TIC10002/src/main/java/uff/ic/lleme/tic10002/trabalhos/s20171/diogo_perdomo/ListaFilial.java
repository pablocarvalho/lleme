/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.diogo_perdomo;

public class ListaFilial {

    private No primeiro = null;
    private No ultimo = null;
    private No corrente = null;
    public ListaFilial proxlista = null;
    private int chave = 0;

    public ListaFilial(int Chave) {
        //this.Filial = Filial;
        this.chave = Chave;
        //System.out.println("criou lista, chave ="+Chave);
    }

    public class No {

        public int Filial = 0;
        public int Ano_mes = 0;
        public int cod_vendedor = 0;
        public double totalvendido = 0.0;

        public No atras = null;
        public No frente = null;

        public No(int Filial, int Ano_mes, int cod_vendedor, double totalvendido) {
            //this.Filial = ListaFilial.this.Filial;
            this.Filial = Filial;
            this.Ano_mes = Ano_mes;
            this.cod_vendedor = cod_vendedor;
            this.totalvendido = totalvendido;
        }

    }

    public void incluir(int Filial, int Ano_mes, int cod_vendedor, double totalvendido) {
        if (primeiro == null) {
            No no = new No(Filial, Ano_mes, cod_vendedor, totalvendido);
            primeiro = no;
            ultimo = no;
        } else {
            No novo = new No(Filial, Ano_mes, cod_vendedor, totalvendido);
            ultimo.atras = novo;
            novo.frente = ultimo;
            ultimo = novo;
        }
    }

    public No getPrimeiroNo() {
        return primeiro;
    }

    public int getFilial() {
        return primeiro.Filial;
    }

    public int getChave() {
        return chave;
    }

    public int getAno_mes() {
        return primeiro.Ano_mes;
    }

    public int getcod_vendedor() {
        return primeiro.cod_vendedor;
    }

    public double gettotalvendido() {
        return primeiro.totalvendido;
    }

    public Double imprime_lista() {
        corrente = primeiro;
        Double Total = 0.0;
        while (corrente != null) {
            Total += corrente.totalvendido;
            System.out.println("Filial: " + corrente.Filial + " Ano:" + corrente.Ano_mes + " CodVend:" + corrente.cod_vendedor + " totalvend: " + corrente.totalvendido);

            corrente = corrente.atras;
        }

        return Total;
    }

    public Double imprime_lista_2(Hash hash) {
        corrente = primeiro;
        Double Total = 0.0;
        boolean resultado;
        while (corrente != null) {

            resultado = hash.pesquisaHash_join(corrente.Filial);
            if (resultado == true) {

                System.out.println("Filial: " + corrente.Filial + " Ano:" + corrente.Ano_mes + " CodVend:" + corrente.cod_vendedor + " totalvend: " + corrente.totalvendido);
                Total += corrente.totalvendido;
            }
            corrente = corrente.atras;
        }

        return Total;
    }

    public void limpa() {
        primeiro = null;
    }

}
