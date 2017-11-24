/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Wesley_Oliveira;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 *
 * @author Wesley Oliveira
 */
public class TRABALHO {

    public static ArvoreAVL arvoreFilial = new ArvoreAVL();
    public static ArvoreAVL arvoreData = new ArvoreAVL();
    public static ListaEncadeada[][] HashFilialData;

    public static void main(String[] args) throws ParseException {
        InputReader("src/trabalho/input2.txt");
        //InputReader("src/trabalho/input.txt"); // OUTRO EXEMPLO DE COM MAIOR NUMERO DE DADOS, usar apenas 1 de cada vez

//  Valores para buscar por Filial - Resposta da 1 pergunta -
//  Formato: (filial de, filial até)
        //    totalPorFilial(1, 4);
        totalPorFilial(3, 6);

//  Valores para buscar por Data - Resposta da 3 pergunta -
//  Formato: (Data de(Ano 2 digitos+Mês 2 digitos), Data até(Ano 2 digitos+Mês 2 digitos))
        totalPorData(1601, 1712);

//  Valores para buscar por Filial + Data - Resposta da 2 pergunta -
//  Formato: (filial de, filial até, Data de(Ano 2 digitos+Mês 2 digitos), Data até(Ano 2 digitos+Mês 2 digitos))
        totalPorFilialEData(2, 4, 1601, 1612);

    }

    public static void InputReader(String file) {

        try {
            FileInputStream fstream = new FileInputStream(file);
            int filiais = 1000;
            int datas = 10000;
            DataInputStream in = new DataInputStream(fstream);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            HashFilialData = new ListaEncadeada[filiais][datas];

            while ((strLine = br.readLine()) != null) { /// A cada leitura do TXT faço uma divisão das Filiais e Datas e uma combinação de ambas
                String[] leitura = strLine.split("/");

                int filial = Integer.parseInt(leitura[0]);/// primeira informação da linha do txt, a filial
                int data = Integer.parseInt(leitura[1]);/// segunda informação da linha do txt, a data

                Venda novo = new Venda(leitura[0], leitura[1], leitura[2], leitura[3]);

                /// Criação do objeto venda que contém como atributos, a filial, data, número do vendedor, número de vendas.
                /// este objeto será inserido em uma Lista Encadeada.
                /// Criação da estrutura de 2 ArvoresAVL (uma organizada por filial e a segunda organizada por datas) em que cada nó da arvore contém
                /// a sua chave de organização e uma Lista Encadeada. Esta Lista Encadeada por sua vez tem como função armazenar em cada um de seus
                /// nós os objetos vendas que foram lidos e criados a partir do txt e inseridos na lista encadeada.
                /// A estrutura da Arvore é composta da seguinte forma: ArvoreAvl > NoAVL > Lista Encadeada > NoLista > Venda
                /// Assim através da busca por uma filial ou data (X) percorro os nós e por ser uma árvore bem balanceada
                /// tem tempo O(log n) se encontrado percorro toda a Lista Encadeada contabilizando
                /// a quantidade de vendas guardadas dentro dos atributos do objeto Venda.
                /// Após a leitura crio uma matriz de Hash de Listas Encadeadas onde estão dispostas em Filiais e Datas permitindo a busca
                /// em tempo constante em seguida fazendo a leitura de toda a Lista Encadeada para contabilizar as vendas das Filiais (Xs) em datas (Ys)
                arvoreFilial.inserir(filial, novo); // Inserçao do obj venda em uma ListaEncadeada em um nó da árvore AVL organizada por Filial
                arvoreData.inserir(data, novo); // Inserçao do obj venda em uma ListaEncadeada em um nó da árvore AVL organizada por data

                //Disposição das FILIAIS e DATAS em uma matriz de Hash organizando as vendas de acordo com as filiais e datas
                if (HashFilialData[filial][data] == null) {
                    ListaEncadeada lista2 = new ListaEncadeada();
                    HashFilialData[filial][data] = lista2;
                    HashFilialData[filial][data].adicionarNo(novo);
                } else
                    HashFilialData[filial][data].adicionarNo(novo);
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void totalPorFilial(int de, int ate) {
        System.out.println("VENDAS DAS FILIAIS de " + de + " até " + ate + ":");
        System.out.println("________________________________________________");

        int total = 0;

        for (int i = de; i <= ate; i++)
            total = total + getVendasPorFilial(i);
        System.out.println("________________________________________________");
        System.out.println("TOTAL DAS VENDAS: " + total);
        System.out.println("");
        System.out.println("");
    }

    public static int getVendasPorFilial(int filialId) {
        NoAVL aux = arvoreFilial.buscar(filialId);
        if (aux != null)
            return aux.getLista().printLista();
        return 0;
    }

    public static void totalPorData(int de, int ate) {
        String tdata = de + "," + ate;

        String mesde = tdata.substring(2, 4);
        String anode = tdata.substring(0, 2);

        String mesate = tdata.substring(7, 9);
        String anoate = tdata.substring(5, 7);

        System.out.println("VENDAS POR DATAS de " + mesde + "/20" + anode + " até " + mesate + "/20" + anoate);
        System.out.println("________________________________________________");

        int total = 0;

        for (int j = de; j <= ate; j++)
            total = total + getVendasPorData(j);
        System.out.println("________________________________________________");
        System.out.println("TOTAL DAS VENDAS: " + total);
        System.out.println("");
        System.out.println("");

    }

    public static int getVendasPorData(int data) {
        NoAVL aux = arvoreData.buscar(data);
        if (aux != null)
            return aux.getLista().printLista();
        return 0;
    }

    public static void totalPorFilialEData(int filialde, int filialate, int datade, int dataate) {
        String data = datade + "," + dataate;

        String mesde = data.substring(2, 4);
        String anode = data.substring(0, 2);

        String mesate = data.substring(7, 9);
        String anoate = data.substring(5, 7);

        System.out.println("VENDAS DAS FILIAIS de " + filialde + " até " + filialate + " e POR DATAS de " + mesde + "/20" + anode + " até " + mesate + "/20" + anoate);
        System.out.println("________________________________________________");

        int total = 0;

        for (int i = filialde; i <= filialate; i++)
            for (int j = datade; j <= dataate; j++)
                total = total + getVendasPorFilialData(i, j);

        System.out.println("________________________________________________");
        System.out.println("TOTAL DAS VENDAS: " + total);
        System.out.println("");
        System.out.println("");

    }

    public static int getVendasPorFilialData(int filialId, int data) {
        int quantidadeVendas = 0;
        if (HashFilialData[filialId][data] != null)
            quantidadeVendas = quantidadeVendas + HashFilialData[filialId][data].printLista();
        return quantidadeVendas;
    }

}
