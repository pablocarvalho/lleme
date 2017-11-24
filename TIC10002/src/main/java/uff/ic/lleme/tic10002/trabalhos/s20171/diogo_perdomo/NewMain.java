/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.diogo_perdomo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class NewMain {

    public static void main(String[] args) {

        //INSTANCIA DAS ARVORES DE FILIAIS E DATA
        ArvoreAvl Arvore_filial = new ArvoreAvl("filial");
        ArvoreAvl Arvore_data = new ArvoreAvl("data");

        //ESTA PARTE FAZ A LEITURA DO ARQUIVO
        //---------------------------------------
        JFileChooser arquivo = new JFileChooser();
        arquivo.showOpenDialog(null);
        String caminho = arquivo.getSelectedFile().getAbsolutePath();

        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                int filial = Integer.parseInt(linha.substring(0, linha.indexOf(',')));
                linha = linha.substring(linha.indexOf(',') + 1, linha.length());
                int ano_mes = Integer.parseInt(linha.substring(0, linha.indexOf(',')));
                linha = linha.substring(linha.indexOf(',') + 1, linha.length());
                int codvend = Integer.parseInt(linha.substring(0, linha.indexOf(',')));
                linha = linha.substring(linha.indexOf(',') + 1, linha.length());
                Double totalvend = Double.parseDouble(linha);
                //INSERE OS CAMPOS DO ARQUIVO DENTRO DA ARVORE
                Arvore_filial.inserir(filial, ano_mes, codvend, totalvend);
                Arvore_data.inserir(filial, ano_mes, codvend, totalvend);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //IMPRIME AS ARVORES
        System.out.printf("\nArvore de Filiais.\n");
        Arvore_filial.print();
        System.out.printf("\nArvore de Datas.\n");
        Arvore_data.print();

        //PERGUNTAS DO TRABALHO
        System.out.println("\n->Total de vendas das filiais com códigos entre 10 e 20");
        Arvore_filial.pesquisaRange(Arvore_filial.raiz, 10, 20);
        Double Total = Arvore_filial.getTotal();
        System.out.println("Total=" + Total);

        System.out.println("-> Total de vendas das filiais com códigos entre 10 e 20 nos meses de Jan/17 até Jun/17\n");

        System.out.println("Registros com data entre Jan/17 ate Jun/17\n");
        Arvore_data.pesquisaRange(Arvore_data.raiz, 201701, 201706);

        System.out.println("\nUniao ou Hash Join com os registros entre 10 e 20\n");
        Total = Arvore_data.hash.imprime_hash_join(Arvore_filial.hash);
        System.out.println("Total=" + Total);

        System.out.println("\n-> Total de vendas de todas as filiais nos meses de Ago/17 até Out/17\n");
        Arvore_data.hash.limpa_lista();
        Arvore_data.Limpa_total();
        Arvore_data.pesquisaRange(Arvore_data.raiz, 201708, 201710);
        Total = Arvore_data.getTotal();
        System.out.println("Total=" + Total);

    }

}
