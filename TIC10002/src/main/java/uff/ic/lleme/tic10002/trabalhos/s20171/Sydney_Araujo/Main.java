/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Sydney_Araujo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SidneyMelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    //Lista contendo todas as entradas
    public static Lista entradas = new Lista();

    //Árvore para Questão 1
    public static AvlMontanteSimples MontantePorFilial = new AvlMontanteSimples();

    //Árvore para Questão 2
    public static AvlMontanteDupla MontantePorFilialEData = new AvlMontanteDupla();

    //Árvore para Questão 3
    public static AvlMontanteSimples MontantePorData = new AvlMontanteSimples();

    public static void main(String[] args) {

        /*
        Leitura do arquivo de entrada e armazenamento dos dados em uma lista encadeada
         */
        lerEntradas("entrada.txt");

        /*
        Estrutura de Dados para Questão 1:
        Construo então uma árvore AVL com o conteúdo da lista encadeada utilizando como chaves
        o código das filiais. O conteúdo de cada nó dessa árvore será o montante de cada filial.
         */
        construirMontantePorFilial();

        /*
        System.out.println("Print MontantePorFilial");
        MontantePorFilial.print();
         */
 /*
        Estrutura de Dados para Questão 2:
        Construo então uma árvore AVL com o conteúdo da lista encadeada utilizando como chaves
        o código das filiais. O conteúdo de cada nó dessa árvore é uma árvore avl cujas chaves são
        as datas da vendas e os conteúdos são as informações de venda
         */
        construirMontantePorFilialEData();

        /*
        System.out.println("Print Montante por Filial e Data");
        MontantePorFilialEData.print();
         */
 /*
        Estrutura de Dados para Questão 3:
        Construo então uma árvore AVL com o conteúdo da lista encadeada utilizando como chaves
        as datas de cada venda. O conteúdo de cada nó dessa árvore será o montante de cada filial.
         */
        construirMontantePorData();

        /*
        System.out.println("Print MontantePorData");
        MontantePorData.print();
         */
        buscaQuestao1(4, 190);

        buscaQuestao2(4, 190, "2015_01", "2016_10");

        buscaQuestao3("2015_01", "2016_10");
    }

    //Método que lê as entradas do arquivo e as insere na Lista entradas.
    public static boolean lerEntradas(String file) {
        try {
            //LER AS ENTRADAS DO ARQUIVO
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                String line = br.readLine();
                while (line != null) {
                    //Faço o split do CSV em 4 strings
                    String[] inputs = line.split(",");
                    //Por fins de organização, passo os 4 valores para variáveis dos tipos corretos para instanciação
                    //de objeto do tipo venda
                    int filial = Integer.parseInt(inputs[0]);
                    String stringdata = inputs[1].split("_")[0];
                    stringdata += inputs[1].split("_")[1];
                    int data = Integer.parseInt(stringdata);
                    int cod_vendedor = Integer.parseInt(inputs[2]);
                    float total_vendido = Float.parseFloat(inputs[3]);

                    //Crio o objeto do tipo Venda e o insiro na lista de Vendas.
                    Venda v = new Venda(filial, data, cod_vendedor, total_vendido);
                    NoLista no = new NoLista(filial, v);
                    entradas.inserir(no);

                    //Leio o próximo valor da lista
                    line = br.readLine();
                    System.out.println("Lendo entrada:");
                    System.out.println(line);
                }
                System.out.println("Fim da leitura do arquivo.");
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void construirMontantePorFilial() {
        for (NoLista atual = entradas.inicio; atual != null; atual = atual.proximo) {
            Venda v = (Venda) atual.getConteudo();
            MontantePorFilial.inserir(v.filial, v.total_vendido);
        }
    }

    public static void construirMontantePorFilialEData() {
        for (NoLista atual = entradas.inicio; atual != null; atual = atual.proximo) {
            Venda v = (Venda) atual.getConteudo();
            MontantePorFilialEData.inserir(v.filial, v);
        }
    }

    public static void construirMontantePorData() {
        for (NoLista atual = entradas.inicio; atual != null; atual = atual.proximo) {
            Venda v = (Venda) atual.getConteudo();
            MontantePorData.inserir(v.data, v.total_vendido);
        }
    }

    public static void buscaQuestao1(int cod_a, int cod_b) {
        System.out.println("Total de vendas das filiais com códigos entre " + cod_a + " e " + cod_b);
        System.out.println(MontantePorFilial.montanteDoIntervalo(cod_a, cod_b));
    }

    public static void buscaQuestao2(int cod_a, int cod_b, String data_a, String data_b) {
        System.out.println("Total de vendas das filiais com códigos entre " + cod_a + " e " + cod_b + " entre as datas " + data_a + " e " + data_b);
        int date_a = Integer.parseInt(data_a.split("_")[0] + data_a.split("_")[1]);
        int date_b = Integer.parseInt(data_b.split("_")[0] + data_b.split("_")[1]);
        System.out.println(MontantePorFilialEData.montanteDosIntervalos(cod_a, cod_b, date_a, date_b));
    }

    public static void buscaQuestao3(String data_a, String data_b) {
        System.out.println("Total de vendas de todas as filiais entre as datas " + data_a + " e " + data_b);
        int date_a = Integer.parseInt(data_a.split("_")[0] + data_a.split("_")[1]);
        int date_b = Integer.parseInt(data_b.split("_")[0] + data_b.split("_")[1]);
        System.out.println(MontantePorData.montanteDoIntervalo(date_a, date_b));
    }
}
