/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.cleirissonsilva;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author clerissonss
 */
public class Main_TrabalhoDeImplementacao {

    public static char menu() {

        String msg;

        System.out.println("                                |                                    ");
        System.out.println("                                |                                    ");
        System.out.println("                                |                                    ");
        System.out.println("* ***************************************************************** *");
        System.out.println("* ***                     Escolha uma Opção                     *** *");
        System.out.println("* ***************************************************************** *\n");
        System.out.println("1 - Total de VENDAS em um intervalo de duas FILIAIS");
        System.out.println("2 - Total de VENDAS em um intervalo de duas FILIAIS e de dois MESES ");
        System.out.println("3 - Total de VENDAS de TODAS as em um intervalo de dois MESES");
        System.out.println("4 - IMPRIMIR arvores");
        System.out.println("5 - SAIR do programa");
        System.out.println("* ***************************************************************** *\n");

        msg = new Scanner(System.in).next();
        return msg.charAt(0);

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int cod_filial1;
        int cod_filial2;
        int data1;
        int data2;
        long totalVendido;
        char opc;

        /**
         * *************************************************************************
         ** Código responsável por ler o arquivo e inserir as vendas na
         * arvore**
         * *************************************************************************
         */
        Arvore_Filial novaArvore = new Arvore_Filial();
        Arvore_AnoMes novaArvoreAM = new Arvore_AnoMes();

        try {
            Scanner leitor = new Scanner(new File("arquivoVendas.txt"));

            while (leitor.hasNext()) {

                Venda venda = new Venda();

                venda.setCod_filial(leitor.nextInt());
                venda.setAno_mes(leitor.nextInt());
                venda.setCod_vendedor(leitor.nextInt());
                venda.setTotalVendido(leitor.nextDouble());

                novaArvore.inserir(venda);
                novaArvoreAM.inserir(venda);

            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println("* ****************************************************************** *");
        System.out.println("*         TRABALHO DE IMPLEMENTÇÃO - ESTRUTURA DE DADOS 2017/01      *");
        System.out.println("*                  Aluno: Clerisson dos Santos e Silva               *");
        System.out.println("*                                                                    *");
        System.out.println("* ***    As filiais estão cadastradas com códigos de 00 a 100    *** *");
        System.out.println("* ***  Os meses estão cadastrados no formato anoMÊS ex. 201701   *** *");
        System.out.println("*                           12 201603 02 3000                        *");
        System.out.println("*                           03 201705 05 4000                        *");
        System.out.println("* ****************************************************************** *\n");

        do {
            opc = menu();

            switch (opc) {
                case '1':
                    System.out.println("");
                    System.out.println("* ****************************************************************** *");
                    System.out.println("* *** Opção 1 - Total de VENDAS em um intervalo de duas FILIAIS  *** *");

                    System.out.println("***** Informe duas FILIAIS para servirem como intervalo de busca *****\n");

                    System.out.println("1- Entre com o código da 1ª FILIAL: (ATENÇÃO: Deve ser no intervalo de FILIAIS de 00 a 100)");
                    cod_filial1 = scan.nextInt();

                    System.out.println("2 -Entre com o código da 2ª FILIAL: (ATENÇÃO: Deve ser no intervalo de FILIAIS de 00 a 100)");
                    cod_filial2 = scan.nextInt();

                    totalVendido = (long) novaArvore.buscarTotalVendidoPorFilial(novaArvore.raiz, cod_filial1, cod_filial2);

                    System.out.println("");
                    System.out.println("O Total vendido nestas filiais foi de R$ " + totalVendido);
                    System.out.println("* ***************************************************************** *\n");

                    break;
                case '2':

                    System.out.println("");
                    System.out.println("* ****************************************************************** *");
                    System.out.println("* *** Opção 2 - Total de VENDAS em um intervalo de duas FILIAIS e de dois MESES *** *");

                    System.out.println("***** Informe duas FILIAIS e  e dois MESES diferentes para servirem como intervalo de busca *****\n");

                    System.out.println("1- Entre com o código da 1ª FILIAL: (ATENÇÃO: Deve ser no intervalo de FILIAIS de 00 a 100)");
                    cod_filial1 = scan.nextInt();

                    System.out.println("2 -Entre com o código da 2ª FILIAL: (ATENÇÃO: Deve ser no intervalo de FILIAIS de 00 a 100)");
                    cod_filial2 = scan.nextInt();

                    System.out.println("3- Entre com a 1ª DATA.(ATENÇÃO: Deve ser digitada no formato anoMES - Ex: 201701):");
                    data1 = scan.nextInt();

                    System.out.println("4- Entre com a 2ª DATA.(ATENÇÃO: Deve ser digitada no formato anoMES - Ex: 201701):");
                    data2 = scan.nextInt();

                    totalVendido = (long) novaArvore.buscarTotalVendidoPorDataEFilial(novaArvore.raiz, cod_filial1, cod_filial2, data1, data2);

                    System.out.println("");
                    System.out.println("\nO Total vendido neste intervalo de FILIAIS entre as datas " + data1 + " e " + data2 + " foi de R$ " + totalVendido);
                    System.out.println("* ***************************************************************** *\n");

                    break;
                case '3':

                    System.out.println("");
                    System.out.println("* ****************************************************************** *");
                    System.out.println("* *** Opção 3 - Total de VENDAS de TODAS as em um intervalo de dois MESES *** *");

                    System.out.println("***** Informe dois MESES diferentes para servirem como intervalo de busca *****\n");

                    System.out.println("1- Entre com a primeira Data.(ATENÇÃO: Deve ser digitada no formato anoMES - Ex: 201701):");
                    data1 = scan.nextInt();

                    System.out.println("2- Entre com a segunda Data.(ATENÇÃO: Deve ser digitada no formato anoMES - Ex: 201701):");
                    data2 = scan.nextInt();

                    totalVendido = (long) novaArvoreAM.buscarTotalVendidoDeTodasAsFiliaisPorData(novaArvoreAM.raiz, data1, data2);

                    System.out.println("");
                    System.out.println("\nO Total vendido em todas as FILIAIS neste intervalo de datas " + data1 + " e " + data2 + " foi de R$ " + totalVendido);
                    System.out.println("* ***************************************************************** *\n");

                    break;
                case '4':

                    System.out.println("ARVORE ORGANIZADA por FILIAIS\n");
                    novaArvore.imprimirArvore();
                    System.out.println("\n\n\n");
                    System.out.println("ARVORE ORGANIZADA por DATAS\n");
                    novaArvoreAM.imprimirArvore();

                    break;
                case '5':
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção Invalida");
            }

        } while (opc != '5');
        System.exit(0);

    }

}
