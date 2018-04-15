package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_e_Uchoa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void imprimeArvore(Arvore<Trafego> tree) {

        int n1 = 2;

        Fila<No<Trafego>> fila = new Fila<No<Trafego>>();
        fila.enfileira(tree.raiz);
        while (!fila.vazia()) {
            No<Trafego> aux = fila.desenfileira();

            if (aux != null) {
                System.out.print(aux.objeto.getChave() + ": " + aux.objeto.getConteudo() + "  ");
                fila.enfileira(aux.getEsquerda());
                fila.enfileira(aux.getDireita());
            } else
                System.out.print("--  ");

            if (fila.tamanho == n1) {
                System.out.println();
                n1 *= 2;
            }

        }

        System.out.println();
        System.out.println();

    }

    public static ListaEstatica<Trafego> geraLista(Arvore<Trafego> tree, double limiar) {
        ListaEstatica<Trafego> lista = new ListaEstatica<Trafego>(tree.tamanho);
        Fila<No<Trafego>> fila = new Fila<No<Trafego>>();
        fila.enfileira(tree.raiz);
        while (!fila.vazia()) {
            No<Trafego> aux = fila.desenfileira();

            if (aux != null) {
                fila.enfileira(aux.getEsquerda());
                fila.enfileira(aux.getDireita());

                if (aux.objeto.getConteudo() >= limiar)
                    lista.insere(aux.objeto);
            }

        }
        ordena(lista);

        for (int i = 0; i < lista.tamanhoAtual; i++)
            System.out.println("{" + lista.get(i).getChave() + ";" + lista.get(i).getConteudo() + "}");

        return lista;

    }

    public static void ordena(ListaEstatica<Trafego> lista) {
        for (int i = 0; i < lista.tamanhoAtual; i++)
            for (int j = i + 1; j < lista.tamanhoAtual; j++)
                if (lista.get(i).compareTo(lista.get(j)) < 0) {
                    Trafego aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
    }

    public static Integer buscaMinMax(Arvore<Trafego> tree, boolean isMin) {

        int min = 9999999;
        int max = -1;

        Fila<No<Trafego>> fila = new Fila<No<Trafego>>();
        fila.enfileira(tree.raiz);
        while (!fila.vazia()) {
            No<Trafego> aux = fila.desenfileira();
            if (aux != null) {
                fila.enfileira(aux.getEsquerda());
                fila.enfileira(aux.getDireita());

                if (isMin) {
                    if (aux.objeto.getConteudo() < min)
                        min = aux.objeto.getConteudo();
                } else
                    if (aux.objeto.getConteudo() > max)
                        max = aux.objeto.getConteudo();
            }

        }

        return isMin ? min : max;
    }

    public static void main(String args[]) throws IOException {
        String dir = "C:\\Users\\Luana Uch�a\\Desktop\\ED";

        int min = -1, max = -1;
        double limiar = 0;

        Arvore<Trafego> tree = new Arvore<Trafego>();
        TabelaDeDispersao<Trafego> hash = new TabelaDeDispersao<Trafego>(10000);

        while (true) {

            File[] arquivos = (new File(dir)).listFiles();
            for (File arq : arquivos) {

                BufferedReader br = new BufferedReader(new FileReader(arq));
                while (br.ready()) {
                    String[] linha = br.readLine().split(";");

                    Trafego obj = new Trafego();
                    obj.setor = linha[0];
                    obj.dia = linha[2];
                    obj.fluxo = Integer.parseInt(linha[3]);

                    Trafego ref = hash.busca(obj);

                    if (ref != null)
                        ref.setConteudo(obj.getConteudo());
                    else {
                        tree.insere(obj); // ... insere na �rvore
                        hash.insere(obj); // ... insere na 'hash'
                    }

                    min = buscaMinMax(tree, true);
                    max = buscaMinMax(tree, false);

                    limiar = min + 0.8 * (max - min);

                }
                br.close();

            }
            imprimeArvore(tree);

            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Limiar de fluxo: " + limiar);

            geraLista(tree, limiar);

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
            }

        }

    }

}
