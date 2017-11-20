/*
 * Trabalho de Estruturas de Dados.
 * Professor: Luis André Portes Paes Leme
 */
package uff.ic.lleme.tic10002.trabalhos.s20172.mariojoao;

import java.io.*;
import java.util.*;

/**
 *
 * @author Mario João Junior
 */
public class TrabalhoMario {

    ArvoreAVL arvflux;
    HashTable acumulados;
    ListaFluxo alterados;

    public TrabalhoMario() {
        arvflux = new ArvoreAVL();
        acumulados = new HashTable();
        alterados = new ListaFluxo();
    }

    private class MeuFiltro implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".flx");
        }
    }

    private void lerArquivo(File arq) {
        TFluxo no;
        TAcumulado noht;
        TSetorDia nosd;

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(arq));
            String linha;
            Scanner sc;
            int setor, rod, dia, fluxo;

            while ((linha = buffer.readLine()) != null) {
                sc = new Scanner(linha).useDelimiter(",");
                setor = sc.nextInt();
                rod = sc.nextInt();
                dia = sc.nextInt();
                fluxo = sc.nextInt();

                noht = acumulados.busca(setor, dia);
                if (noht == null) {
                    // Nó novo
                    no = new TFluxo(fluxo, setor, dia);
                    arvflux.inserir(no);
                    acumulados.inserir(setor, dia, fluxo);
                    continue;
                }

                if (noht.eOriginal()) {
                    // Inserir na lista de alterados
                    nosd = new TSetorDia(setor, dia);
                    alterados.inserir(nosd);
                }

                noht.acumula(fluxo);
            }

            while (!alterados.listaVazia()) {
                nosd = alterados.removePrimeiro();
                noht = acumulados.busca(nosd.setor, nosd.dia);
                // remover fluxo antigo da AVL
                no = new TFluxo(noht.fini, noht.setor, noht.dia);
                arvflux.remover(no);

                // inserir novo fluxo na AVL
                no = new TFluxo(noht.fatual, noht.setor, noht.dia);
                arvflux.inserir(no);

                // atualizar o fluxo na tabela Hash
                noht.atualiza();
            }
        } catch (IOException e) {

            System.out.printf("Erro lendo %s.\n", arq.getPath());
        }
    }

    private void lerArquivos(File dir) {
        MeuFiltro filtro;
        int meFluxo,
                maFluxo;

        filtro = new MeuFiltro();
        for (File arq : dir.listFiles(filtro)) {
            System.out.printf("Lendo %s...\n", arq.getName());
            lerArquivo(arq);
        }
        // Achar o Menor Fluxo (MeF)
        meFluxo = arvflux.menor();
        System.out.printf("Menor Fluxo: %d\n", meFluxo);
        // Achar o Maior Fluxo (MaF)
        maFluxo = arvflux.maior();
        System.out.printf("Maior Fluxo: %d\n", maFluxo);
        // Imprimir os fluxos maiores que Mef + 0.8*(MaF-MeF)
        System.out.printf("Limite de Fluxo: %d\n", meFluxo + (int) (0.8 * (maFluxo - meFluxo)));
        arvflux.imprimeMaior(meFluxo + (int) (0.8 * (maFluxo - meFluxo)));
    }

    public static void main(String[] args) {
        File dir;
        TrabalhoMario trab = new TrabalhoMario();

        for (String s : args)
            System.out.println(s);

        if (args.length < 1) {
            System.out.println("Número incorreto de parâmetros");
            return;
        }

        dir = new File(args[0]);
        if (!dir.isDirectory()) {
            System.out.printf("Parâmetro %s não é diretório.\n", dir.getPath());
            return;
        }

        trab.lerArquivos(dir);
    }
}
