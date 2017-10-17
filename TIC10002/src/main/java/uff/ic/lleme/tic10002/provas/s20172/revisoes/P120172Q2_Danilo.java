/*
Segue uma implementação recursiva para imprimir os ultimos 5* valores anteriores de um negativo em uma lista encadeada.
* caso não tenha 5, apos o inicio, ou a um negativo, sera impresso apenas os n ultimos visitados onde n<5.
 */
package uff.ic.lleme.tic10002.provas.s20172.revisoes;

/**
 * @author dlemes
 */
public class P120172Q2_Danilo {

    public Celula Primeiro = null;

    public Celula proxNeg;
    public int quant;
    public int cont;

    static class Celula {

        Celula prox;
        int conteudo;

    }

    public void insereInicio(int i) {

        if (Primeiro == null) {
            Primeiro = new Celula();
            Primeiro.conteudo = i;
            Primeiro.prox = null;

        } else {
            Celula novo = Primeiro;
            Primeiro = new Celula();
            Primeiro.conteudo = i;
            Primeiro.prox = novo;

        }
    }

    private void print() {
        System.out.println("Imprime todos:");
        Celula print = Primeiro;
        while (print != null)
            if (print.prox != null) {
                System.out.print(print.conteudo + ",");
                print = print.prox;
            } else {
                System.out.print(print.conteudo);
                print = print.prox;
            }
        System.out.println();
    }

    public void imprime(Celula atual) {
        if (quant == 0)
            if (atual != null) {
                cont++;
                {// CORRECAO: 1) na sua prova não existe esse bloco
                    if (atual.prox == null)//Verifica fim da final da fila.   *** ADICIONADO
//                    System.out.println("FIM");
                        return;
                }
                if (atual.prox.conteudo < 0) {
                    proxNeg = atual.prox.prox;
                    System.out.print(atual.conteudo + " ");
                    quant = 4;
                    return;
                } else
                    imprime(atual.prox);
            } else {
                // System.out.println("FIM");
                // return "Fim";// CORRECAO: 2) na sua prova existia essa instrução
                // REMOVI O ELSE  *** MODIFICADO
            }
        else {
            //if (quant != 0) {  // CORROCAO: 3) na sua prova nao havia essa instrucao
            if (quant > cont)
                //quant = cont - 1; // SUBITRAIDO -1 PARA MANTER A CONTABILIDADE CORRETA *** MODIFICACAO
                quant = cont; // CORRECAO: 4) na sua prova nao havia a subtracao
            System.out.print(atual.conteudo + " ");  // CORRECAO: 5) essa linha vinha antes de quant--;
            quant--;
            if (quant == 0) {
                System.out.println("");//ADICIONEI APENAS PARA VISUALISACAO
                cont = 0;
                imprime(proxNeg);
            }

        }
    }

    public void run() {
        insereInicio(3);
        insereInicio(1);
        insereInicio(3);
        insereInicio(4);
        insereInicio(9);
        insereInicio(-2);
        insereInicio(9);
        insereInicio(83);
        insereInicio(-2);
        insereInicio(9);
        insereInicio(4);
        insereInicio(88);
        insereInicio(9);
        insereInicio(3);
        insereInicio(-1);
        insereInicio(3);
        insereInicio(5);
        insereInicio(9);
        insereInicio(1);
        insereInicio(2);

        print();

        System.out.println("\nQuestão 2:");
        imprime(Primeiro);

    }

    public static void main(String[] args) {

        new P120172Q2_Danilo().run();

    }

}
