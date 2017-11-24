package uff.ic.lleme.tic10002.trabalhos.s20171.Ricardo_Bhering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProgramaEDJava {

    public static void main(String args[]) throws NumberFormatException, IOException {
        int filialInicial, filialFinal, dataInicial, dataFinal;
        Filiais arvore = new Filiais();
        Scanner teclado = new Scanner(System.in);

        //Chama carregarestrutura, e carrega o arquivo texto na estrutura.
        long tempoInicial = System.currentTimeMillis();
        carregaestrutura("dados.txt", arvore);
        System.out.println("O metodo carregaEstrutura executou em " + (System.currentTimeMillis() - tempoInicial)
                + " milisegundos");

        System.out.println("Trabalho de Implementa��o - Estrutura de Dados");
        System.out.println("Ricardo George Bhering");
        System.out.println("=====================================================================");
        System.out.println("=========================Menu de Op��es==============================");

        //Cria o menu de op��es do programa.
        while (true) {
            System.out.println("Op��o 1: Total de vendas das filiais por inervalo de Filiais.");
            System.out.println("Op��o 2: Total de vendas das filiais por inervalo de Filiais e");
            System.out.println("intervalo de per�do. ");
            System.out.println("Op��o 3: Total de vendas de todas as filiais por intervalo de per�odo.");

            int opcao;
            System.out.println("Entre com a op��o desejada: \n ");
            opcao = teclado.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Entre com o valor da (Filial Inicial)");
                    filialInicial = teclado.nextInt();
                    System.out.println("Entre com o valor da (Filial Final)");
                    filialFinal = teclado.nextInt();
                    tempoInicial = System.currentTimeMillis();
                    System.out.println("Sa�da de dados da op��o 1: Exercicio 1\n");
                    float total = arvore.relatorioVendas1(filialInicial, filialFinal);
                    System.out.println("O metodo relatorioVendas1 executou em " + (System.currentTimeMillis() - tempoInicial)
                            + " milissegundos");
                    System.out.println("=====================================================================\n");

                case 2:
                    System.out.println("Entre com o valor da (Filial Inicial)");
                    filialInicial = teclado.nextInt();
                    System.out.println("Entre com o valor da (Filial Final");
                    filialFinal = teclado.nextInt();
                    System.out.println("Formato Ex: 201701 (AnoMes)");
                    System.out.println("Entre com o valor da (Data Inicial)");
                    dataInicial = teclado.nextInt();
                    System.out.println("Entre com o valor da (Data Final)");
                    dataFinal = teclado.nextInt();
                    tempoInicial = System.currentTimeMillis();
                    System.out.println("Exercicio 2\n");
                    arvore.relatorioVendas2(filialInicial, filialFinal, dataInicial, dataFinal);
                    System.out.println("O metodo relatorioVendas2 executou em " + (System.currentTimeMillis() - tempoInicial)
                            + " milissegundos");
                    System.out.println("=====================================================================\n");
                case 3:
                    System.out.println("Formato Ex: 201701 (AnoMes)");
                    System.out.println("Entre com o valor da (Data Inicial)");
                    dataInicial = teclado.nextInt();
                    System.out.println("Entre com o valor da (Data Final)");
                    dataFinal = teclado.nextInt();
                    tempoInicial = System.currentTimeMillis();
                    System.out.println("Exercicio 3\n");
                    arvore.relatorioVendas3(dataInicial, dataFinal);
                    System.out.println("O metodo relatorioVendas3 executou em " + (System.currentTimeMillis() - tempoInicial)
                            + " milissegundos");
                    System.out.println("=====================================================================\n");

                default:
                    System.out.println("\nVoc� digitou uma opera��o inv�lida.\n");
            }
        }

    }//L� o arquivo informado e chama inserir.

    static void carregaestrutura(String arquivo, Filiais filiais) throws NumberFormatException, IOException {
        BufferedReader ler = new BufferedReader(new FileReader(new File(arquivo)));
        String linha;
        while ((linha = ler.readLine()) != null) {
            Integer filial = Integer.valueOf(linha.split(";")[0]);
            Integer ano_mes = Integer.valueOf(linha.split(";")[1]);
            Integer vendedor = Integer.valueOf(linha.split(";")[2]);
            float valorVenda = Float.valueOf(linha.split(";")[3]);
            filiais.inserir(filial, ano_mes, vendedor, valorVenda);
        }
        ler.close();
    }
}
