package provas.s20141.p320141.q2;

import java.util.Queue;
import java.util.Stack;

public class RestaUm {

    public static void main(String[] args) {

        backtracking(new Stack(), Tabuleiro.obterInstancia());

    }

    private static void backtracking(Stack<Movimento> movimentos, Tabuleiro tabuleiro) {
        if (eSol(tabuleiro)) {
            imprimirTab(tabuleiro.obterEstado());
            processarSol(movimentos);
        } else {
            Queue<Movimento> cand = gerarCand(tabuleiro);
            while (!cand.isEmpty()) {
                Movimento mv = cand.poll();
                movimentos.push(mv);
                tabuleiro.aplicarMov(mv);
                backtracking(movimentos, tabuleiro);
                tabuleiro.desaplicarMov(mv);
                movimentos.pop();
            }
        }
    }

    private static boolean eSol(Tabuleiro tabuleiro) {
        return tabuleiro.contarUns() == 1;
    }

    private static void processarSol(Stack<Movimento> movimentos) {
        for (Movimento m : movimentos)
            System.out.println("(" + m.a.i + "," + m.a.j + ")-->(" + m.b.i + "," + m.b.j + ")\n");
    }

    private static Queue<Movimento> gerarCand(Tabuleiro tabuleiro) {
        Queue<Movimento> cand = tabuleiro.movimentosPossiveis();
        return cand;
    }

    private static void imprimirTab(int[][] tabuleiro) {
        if (tabuleiro != null)
            for (int[] linha : tabuleiro) {
                for (int j = 0; j < linha.length; j++)
                    System.out.print(linha[j] + " ");
                System.out.println("");
            }
        System.out.println("");
    }

}
