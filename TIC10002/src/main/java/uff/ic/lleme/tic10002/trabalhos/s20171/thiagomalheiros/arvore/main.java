/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.thiagomalheiros.arvore;

import java.io.*;
import java.text.ParseException;

/**
 *
 * @author Thiago Malheiros Porcino
 */
public class main {

    public static ArvoreAVL t_filial = new ArvoreAVL();
    public static ArvoreAVL t_data = new ArvoreAVL();
    public static ListaEncadeadaVendas[][] hash_linha_coluna;

    public static void main(String[] args) throws ParseException, IOException {
        //leitura de arquivo
        LerArquivo("src/TRAB_VENDAS/ARQUIVO_DE_VENDAS.txt");

        // Valores de consulta de filiais
        //- Simulação de entrada de dados na busca
        int filialDE = 1;
        int filialATE = 4;

        // Valores de intervalo de datas em string
        //- Simulação de entrada de dados na busva
        String data_mes_ano_DE = "0317";
        String data_mes_ano_ATE = "0617";

        //Converte a data String para data no formato aceito pela funcao de busca [ (ano * 100) + mes ]
        int data_DE = gerarChave(data_mes_ano_DE.substring(0, 2), data_mes_ano_DE.substring(2, 4));
        int data_ATE = gerarChave(data_mes_ano_ATE.substring(0, 2), data_mes_ano_ATE.substring(2, 4));

        //chamada de funções
        imprimeTotalDeVendasPorFiliais(filialDE, filialATE);
        imprimeTotalDeVendasPorFiliaisData(filialDE, filialATE, data_DE, data_ATE);
        imprimeTotalDeVendasPorData(data_DE, data_ATE);

    }

    /*
    FUNÇÃO RESPONONSÁVEL POR CONVERTER UMA DATA EM STRING PARA INTEIRO

    funcao responsável por converter uma data em formato inteiro para gerar chave
    do vetor de busca

    A chave gerada é é um inteiro e para isto converto a data do formato MMAA para
    (AA * 100) + MM

    exemplo: String "0117" -> (17 * 100) + 01 = 1701
     */
    public static int gerarChave(String s1, String s2) {
        int mes = Integer.parseInt(s1);
        int ano = Integer.parseInt(s2) * 100;
        int chave = ano + mes;
        return chave;
    }

    /*
 FUNÇÃO DE LEITURA DE ARQUIVO

     */
    //Funcao responsavel por fazer uma primeira leitura do arquivo para saber qual é
    // a filial de maior ID para criar o vetor ID com tamanho MAIORFILIAL + 1 de forma dinamica
    public static int retornaTamanhoMax(String file) throws FileNotFoundException, IOException {
        int maior = 0;
        try {
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // objeto linha
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] palavras = strLine.split(",");

                if (Integer.parseInt(palavras[0]) > maior)
                    maior = Integer.parseInt(palavras[0]);
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return maior;
    }

    public static void LerArquivo(String file) throws IOException {
        int maior = retornaTamanhoMax(file);
        hash_linha_coluna = new ListaEncadeadaVendas[maior + 1][3000];
        //int maior = 9999;
        try {
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // objeto linha
            String strLine;

            while ((strLine = br.readLine()) != null) {
                //cada linha é transformado em um array de palavras
                String[] palavras = strLine.split(",");

                //separo e converto o id e data como inteiros para ser usado como chave
                int chaveId = Integer.parseInt(palavras[0]);
                int chaveData = gerarChave(palavras[1].substring(0, 2), palavras[1].substring(2, 4));

                //objeto venda
                NoListaEncadeada venda = new NoListaEncadeada(palavras[0], palavras[1], palavras[2], palavras[3]);

                t_filial.inserir(chaveId, venda);
                t_data.inserir(chaveData, venda);

                if (hash_linha_coluna[chaveId][chaveData] != null)
                    hash_linha_coluna[chaveId][chaveData].inserirNoFim(venda);
                else {
                    ListaEncadeadaVendas l = new ListaEncadeadaVendas();
                    hash_linha_coluna[chaveId][chaveData] = l;
                    hash_linha_coluna[chaveId][chaveData].inserirNoFim(venda);
                }

            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    /*
    FUNÇÕES DE IMPRESSÃO DOS DADOS POR INTERVALOS
    UTILIZANDO AS FUNÇÕES DE BUSCA EM O(1).
     */
//Imprime todas as vendas por filiais em um intervalo
    public static void imprimeTotalDeVendasPorFiliais(int de, int ate) {
        System.out.println("---------- VENDAS POR FILIAIS ----------");
        System.out.println("INTERVALO (FILIAIS): DE:" + de + "        ATE:" + ate);
        System.out.println("");
        int soma = 0;

        for (int i = de; i <= ate; i++)

            soma += buscarVendasPorFilial(i);

        System.out.println("-------------------------------------------");
        System.out.println("SUBTOTAL DE VENDAS: " + soma);
        System.out.println("");
        System.out.println("");
    }
//imprime o total de vendas por intervalos de filial e data

    public static void imprimeTotalDeVendasPorFiliaisData(int filialDe, int filialAte, int de, int ate) {

        String tdata = de + "," + ate;

        String anod1 = tdata.substring(0, 2);
        String anod2 = tdata.substring(5, 7);

        String mes1 = tdata.substring(2, 4);
        String mes2 = tdata.substring(7, 9);

        System.out.println("-------- VENDAS POR FILIAIS E DATAS --------");
        System.out.println("INTERVALO (FILIAIS): DE:" + filialDe + "        ATE:" + filialAte);
        System.out.println("INTERVALO (DATA):    DE: " + mes1 + "/" + anod1 + " ATE: " + mes2 + "/" + anod2);
        System.out.println("");
        int soma = 0;

        for (int i = filialDe; i <= filialAte; i++)
            for (int j = de; j <= ate; j++)
                soma += buscarVendasPorFilialData(i, j);

        System.out.println("-------------------------------------------");
        System.out.println("SUBTOTAL DE VENDAS: " + soma);
        System.out.println("");
        System.out.println("");

    }
//imprime o total de vendas por data em um intervalo

    public static void imprimeTotalDeVendasPorData(int de, int ate) {
        String tdata = de + "," + ate;

        String anod1 = tdata.substring(0, 2);
        String anod2 = tdata.substring(5, 7);

        String mes1 = tdata.substring(2, 4);
        String mes2 = tdata.substring(7, 9);

        System.out.println("------------- VENDAS POR DATA -------------");
        System.out.println("INTERVALO (DATA):    DE: " + mes1 + "/" + anod1 + " ATE: " + mes2 + "/" + anod2);
        System.out.println("");
        int soma = 0;

        for (int j = de; j <= ate; j++)

            soma += buscarVendasPorData(j); //System.out.print(">>>>>>>>>>>>>>>>>>>" + soma);
        System.out.println("-------------------------------------------");
        System.out.println("SUBTOTAL DE VENDAS: " + soma);
        System.out.println("");
        System.out.println("");

    }

    public static int buscarVendasPorFilial(int filialId) {
        int quantidadeVendas = 0;
        NoArvoreAVL no = t_filial.buscar(filialId);
        if (no != null)
            quantidadeVendas += no.getLista().exibirLista();

        return quantidadeVendas;
    }

    public static int buscarVendasPorFilialData(int filialId, int data) {
        int quantidadeVendas = 0;
        if (hash_linha_coluna[filialId][data] != null)
            quantidadeVendas += hash_linha_coluna[filialId][data].exibirLista();
        return quantidadeVendas;
    }

    public static int buscarVendasPorData(int data) {
        int quantidadeVendas = 0;

        NoArvoreAVL no = t_data.buscar(data);
        if (no != null)
            quantidadeVendas += no.getLista().exibirLista();

        return quantidadeVendas;
    }

}
