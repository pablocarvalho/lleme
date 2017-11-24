/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Gabriel_Carvalho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Frog33
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arvore arv = new Arvore();
        int filial1 = Integer.MIN_VALUE, filial2 = Integer.MAX_VALUE;
        MesAno data1 = new MesAno(MesAno.MIN), data2 = new MesAno(MesAno.MAX);
        Scanner leitor = new Scanner(System.in);
        String arquivo = "vendas.txt", temp;

        while (true) {
            System.out.println("\n\nCaso queira usar algum arquivo digite aqui (arquivo.txt).");
            System.out.println("O arquivo deve estar no formato cod_filial, mes_ano, cod_vendedor, total_vendido\n"
                    + "                               (    int   ,  String,    String   ,     int)\n"
                    + "                            ex.      10   ,  Jan/17,    abcd     ,     61  ");
            System.out.println("Caso queira usar o arquivo padrão, digite apenas 'n'");

            if (!(temp = leitor.next()).equals("n"))
                arquivo = temp;

            try {
                Venda v;
                Scanner s = new Scanner(new File(arquivo));

                for (int i = 0; s.hasNext(); i++) {
                    v = new Venda(s.nextInt(), s.next(), s.next(), s.nextInt());
                    //System.out.println(v);
                    arv.incluir(v);
                }

                while (true) {

                    while (true) {
                        System.out.println("Gostaria de buscar um intervalo de filiais? (s/n)");
                        if ((temp = leitor.next()).equals("s"))

                            try {
                                System.out.println("Digite a primeira filial do intervalo (inteiro)");
                                filial1 = leitor.nextInt();
                                System.out.println("Digite a segunda filial do intervalo (inteiro)");
                                filial2 = leitor.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.err.println("\n\nAs filiais devem ser do tipo int");
                            }
                        else if (temp.equals("n"))
                            break;
                        else
                            System.out.println("Por favor, escolha uma opção válida (s/n)");
                    }

                    while (true) {
                        System.out.println("Gostaria de buscar um intervalo de Data? (s/n)");
                        if ((temp = leitor.next()).equals("s"))

                            try {
                                System.out.println("Digite a primeira data do intervalo (Mes/Ano ex. Jan/01)");
                                data1 = new MesAno(leitor.next());
                                System.out.println("Digite a segunda data do intervalo (Mes/Ano ex. Jan/01)");
                                data2 = new MesAno(leitor.next());
                                break;
                            } catch (InputMismatchException e) {
                                System.err.println("\n\nAs datas devem ser do tipo String, no formato Mes/ano (ex. Jan/16)");
                            }
                        else if (temp.equals("n"))
                            break;
                        else
                            System.out.println("Por favor, escolha uma opção válida (s/n)");
                    }

                    System.out.println("total: " + arv.busca(filial1, filial2, data1, data2));

                    System.out.println("Deseja realizar outra busca?(s/n)");
                    if (!leitor.next().equals("s"))
                        break;

                    filial1 = Integer.MIN_VALUE;
                    filial2 = Integer.MAX_VALUE;
                    data1 = new MesAno(MesAno.MIN);
                    data2 = new MesAno(MesAno.MAX);
                }

                System.out.println("Gostaria de imprimir as árvores??(s/n)");
                if (leitor.next().equals("s"))

                    while (true) {
                        System.out.println("Gostaria de imprimir todas as árvores, apenas a externa ou apenas as internas(0 = todas, 1 = apenas a externa e 2 = apenas as internas)??");
                        byte aux;

                        try {
                            aux = Byte.parseByte(leitor.next());

                            if (aux > -1 && aux < 3)
                                arv.imprime(aux);
                            else
                                throw new NumberFormatException();

                            break;
                        } catch (NumberFormatException e) {
                            System.err.println("\n\nPor favor escolha um valor entre 0, 1 e 2.");
                        }
                    }
                break;

            } catch (FileNotFoundException ex) {
                arquivo = "vendas.txt";
                System.err.println("\n\nNão foi possível encontrar o arquivo");
            }
        }

    }

}
