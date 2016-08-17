package oo.disciplina;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Disciplina {

    private Avaliacao[] colecao = new Avaliacao[10];
    private int posLivre = 0;

    public Avaliacao[] getColecao() {
        return colecao;
    }

    public float media(int index) {
        return (colecao[index].getNotaP3() + colecao[index].getNotaTrab()) / 2;
    }

    public Disciplina(String notasT, String notasP3) throws FileNotFoundException, IOException {
        carregaAvaliacoes(notasT, notasP3);
    }

    public Avaliacao buscaAvaliacao(int matricula) {
        for (Avaliacao avaliacao : colecao)
            if (avaliacao.getMatricula() == matricula)
                return avaliacao;
        return null;
    }

    private void carregaAvaliacoes(String notasT, String notasP3) throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream(notasT);
        Scanner in = new Scanner(input);
        while (in.hasNext())
            colecao[posLivre++] = new Avaliacao(in.nextInt(), in.nextFloat());
        input.close();

        input = new FileInputStream(notasP3);
        in = new Scanner(input);
        Avaliacao avaliacao;
        while (in.hasNext()) {
            avaliacao = buscaAvaliacao(in.nextInt());
            if (avaliacao != null)
                avaliacao.setNotaP3(in.nextFloat());
            else
                colecao[posLivre++] = new Avaliacao();
        }

    }
}
