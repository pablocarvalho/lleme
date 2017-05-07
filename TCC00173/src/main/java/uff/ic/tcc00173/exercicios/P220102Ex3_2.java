package uff.ic.tcc00173.exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P220102Ex3_2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] estacoes = new String[80];
        int[][] tempos = new int[80][80];
        carregaTempos("", estacoes, tempos);
        String estacao1, estacao2;
        int codEstacao1 = 0, codEstacao2 = 0, tempo = 0;
        try (InputStream is = new FileInputStream("");
            Scanner in = new Scanner(is);) {
            if (in.hasNext()) {
                estacao1 = in.next();
                codEstacao1 = buscaEstacao(estacoes, estacao1);
            }
            while (in.hasNext()) {
                estacao2 = in.next();
                codEstacao2 = buscaEstacao(estacoes, estacao2);
                tempo += tempos[codEstacao1][codEstacao2];
                codEstacao1 = codEstacao2;
            }
        }

    }

    public static void carregaTempos(String nomeArq, String[] estacoes,
        int[][] tempos) throws FileNotFoundException, IOException {
        try (InputStream is = new FileInputStream(nomeArq);
            Scanner in = new Scanner(is);) {
            String estacaoA, estacaoB;
            int codA, codB, tempo, codigo = 0;
            while (in.hasNext()) {
                estacaoA = in.next();
                estacaoB = in.next();
                tempo = in.nextInt();
                codA = buscaEstacao(estacoes, estacaoA);
                if (codA == -1) {
                    codA = codigo;
                    estacoes[codigo++] = estacaoA;
                }
                codB = buscaEstacao(estacoes, estacaoB);
                if (buscaEstacao(estacoes, estacaoB) == -1) {
                    codB = codigo;
                    estacoes[codigo++] = estacaoB;
                }
                tempos[codA][codB] = tempo;
                tempos[codB][codA] = tempo;
            }
        }
    }

    public static int buscaEstacao(String[] estacoes, String estacao) {
        for (int i = 0; i < estacoes.length; i++)
            if (estacoes[i].equals(estacao))
                return i;
        return -1;
    }
}
