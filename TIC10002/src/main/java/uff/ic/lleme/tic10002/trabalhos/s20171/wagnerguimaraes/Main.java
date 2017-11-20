/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.wagnerguimaraes;

//import traballhoed.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

/**
 *
 * @author Wagner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static ArvoreFilial ArvoreFilial;

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int Opcao = 0;
        int k = 0;
        int cFilial1, cFilial2, cAnoMes1, cAnoMes2;

        double SaldoFilial = 0, SaltoTotal = 0;
        do {

            System.out.print("\n\n\n\n\n*****************************\n");
            System.out.print("*      Menu do Sistema      *\n");
            System.out.print("*****************************\n");
            System.out.print("\n1. Carregar o Arquivo de Dados");
            System.out.print("\n2. Total de vendas entre intervalos de Filiais");
            System.out.print("\n3. Total de vendas entre intervalos de filiais e meses");
            System.out.print("\n4. Total de vendas de todas das filiais no intervalo de meses");
            System.out.print("\n\nDigite sua opção:             \n");
            Opcao = entrada.nextInt();
            switch (Opcao) {
                case 1:
                    if (LerArquivo() == true)
                        System.out.print("Arquivo carregado com sucesso.\n\n");
                    break;
                case 2:

                    System.out.print("\n\nInforme o código inicial do intervalo: ");
                    cFilial1 = entrada.nextInt();
                    System.out.print("\nInforme o código final do intervalo: ");
                    cFilial2 = entrada.nextInt();

                    ArvoreFilial.buscarSaldoFilial(cFilial1, cFilial2);
                    NoFilial t = ArvoreFilial.sucessor(ArvoreFilial.buscar(cFilial1));
                    System.out.printf("teste %d", t.getChave());

                    break;
                case 3:

                    System.out.print("\n\nInforme o código inicial do intervalo: ");
                    cFilial1 = entrada.nextInt();
                    System.out.print("\nInforme o código final do intervalo: ");
                    cFilial2 = entrada.nextInt();
                    //entrada.nextLine();
                    System.out.print("\n\nInforme a data inicial no formato (yymm)");
                    cAnoMes1 = entrada.nextInt();
                    System.out.print("\n\nInforme a data final no formato (yymm)");
                    cAnoMes2 = entrada.nextInt();

                    ArvoreFilial.buscarSaldoFilialMes(cFilial1, cFilial2, cAnoMes1, cAnoMes2);

                    break;
                case 4:
                    System.out.print("\n\nInforme a data inicial no formato (yymm)");
                    cAnoMes1 = entrada.nextInt();
                    System.out.print("\n\nInforme a data final no formato (yymm)");
                    cAnoMes2 = entrada.nextInt();

                    ArvoreFilial.buscarSaldoMes(cAnoMes1, cAnoMes2);

                    break;
                case 5:
                    Opcao = 6;
                    break;
                default:
                    System.out.print("\nOpção inválida");
            }
        } while (Opcao <= 5);
    }

    /*
    *   Função que ler o arquivo indicado pelo usuário
     */
    public static boolean LerArquivo() {

        /* Ler o endereço do arquivo que o usuário irá infomrmar*/
        String[] col = new String[3];

        ArvoreFilial = new ArvoreFilial();

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");

        String nome = ler.nextLine();

        try {
            FileReader arq = new FileReader(nome);

            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha

            linha = lerArq.readLine(); // le a segunda linha que interessa

            while (linha != null) {

                col = linha.split(";");

                Filial F = new Filial();
                F.filial = Integer.parseInt(col[0]);
                F.ano_mes = Integer.parseInt(col[1]);
                F.cod_vendedor = Integer.parseInt(col[2]);
                F.total_vendido = Double.parseDouble(col[3]);

                ArvoreFilial.inserir(F);

                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return (false);
        }

        return (true);
    }

    public static int arquivoTotallinhas(String Arq) throws FileNotFoundException, IOException {
        File arquivoLeitura = new File(Arq);
        LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arquivoLeitura));
        linhaLeitura.skip(arquivoLeitura.length());
        return linhaLeitura.getLineNumber() - 1;
    }

}
