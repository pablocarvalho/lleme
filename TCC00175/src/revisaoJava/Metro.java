package revisaoJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Metro {

    private static int tamanhoVetor = 0;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[] estacoes = new String[80];
        float[][] tempos = new float[80][80];

        carregaEstacoes("estacoes.txt", estacoes, tempos);
        System.out.println(calculaTempo("trajeto.txt", estacoes, tempos));

    }

    public static void carregaEstacoes(String nomeArq, String[] estacoes, float[][] tempos) throws FileNotFoundException, IOException {

        InputStream input = new FileInputStream(nomeArq);
        Scanner in = new Scanner(input);
        String[] vetorLinha;
        String linha;
        int estacaoA, estacaoB;

        while (in.hasNextLine()) {
            linha = in.nextLine();
            vetorLinha = linha.split(" ");
            estacaoA = insereEstacao(vetorLinha[0], estacoes);
            estacaoB = insereEstacao(vetorLinha[1], estacoes);
            tempos[estacaoA][estacaoB] = Float.parseFloat(vetorLinha[2]);
            tempos[estacaoB][estacaoA] = Float.parseFloat(vetorLinha[2]);
        }
        input.close();
    }

    private static float calculaTempo(String nomeArq, String[] estacoes, float[][] tempos) throws FileNotFoundException {
        InputStream input = new FileInputStream(nomeArq);
        Scanner in = new Scanner(input);
        String estacaoA = null;
        String estacaoB = null;
        float tempo = 0;
        if (in.hasNextLine()) {
            estacaoA = in.nextLine();
            while (in.hasNextLine()) {
                estacaoB = in.nextLine();
                tempo += tempos[buscaEstacao(estacaoA, estacoes)][buscaEstacao(estacaoB, estacoes)];
                estacaoA = estacaoB;
            }
        }
        return tempo;
    }

    public static int insereEstacao(String estacao, String[] estacoes) {
        int i = buscaEstacao(estacao, estacoes);
        if (i == -1) {
            estacoes[tamanhoVetor++] = estacao;
            i = tamanhoVetor - 1;
        }
        return i;

    }

    public static int buscaEstacao(String estacao, String[] estacoes) {
        boolean achou = false;
        int i = 0;
        while (!achou && i < estacoes.length && estacoes[i] != null)
            if (estacoes[i].equals(estacao))
                achou = true;
            else
                i++;
        if (!achou)
            i = -1;

        return i;
    }
}
