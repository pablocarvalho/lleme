package exemplos.listas.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Labirinto {

    private static boolean finished = false; /* Todas soluções encontradas? */

    private static int[][] labirinto = {{0, 1, 0, 0, 0},
    {0, 1, 0, 1, 0},
    {0, 0, 0, 1, 0},
    {0, 1, 0, 1, 1},
    {0, 1, 0, 0, 0}};

    private static Posicao objetivo = new Posicao(4, 4);

    public static void main(String[] args) {
        Stack<Movimentacao> sol = new Stack<>();
        Posicao inicio = new Posicao(4, 0);
        labirinto[4][0] = 2;
        backtrack(sol, inicio);
    }

    public static void backtrack(Stack<Movimentacao> solution, Posicao pos) {
        if (isSolution(solution))
            processSolution(solution);      
        else {

            List<Movimentacao> candidates = constructCandidates(solution, pos);

            for (Movimentacao mov : candidates) {
                solution.push(mov);
                labirinto[mov.b.linha][mov.b.coluna] = 2;
                backtrack(solution, mov.b);
                solution.pop();
                labirinto[mov.b.linha][mov.b.coluna] = 0;
            }
        }
    }

    public static boolean isSolution(final Stack<Movimentacao> sol) {
        try {
            Movimentacao mov = sol.peek();
            if (mov.b.linha == objetivo.linha && mov.b.coluna == objetivo.coluna)
                return true;
        } catch (EmptyStackException e) {
        }
        return false;
    }

    public static void processSolution(final Stack<Movimentacao> a) {

        int n = labirinto[0].length + 4;
        char[] chars = new char[n];
        Arrays.fill(chars, '-');
        String line = new String(chars);

        System.out.println(line);
        for (int i = 0; i < labirinto.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < labirinto[0].length; j++)
                if (labirinto[i][j] == 2)
                    System.out.print(".");
                else if (labirinto[i][j] == 1)
                    System.out.print("@");
                else
                    System.out.print(" ");
            System.out.println(" |");
        }
        System.out.println(line);

        for (Movimentacao mov : a)
            System.out.println("(" + mov.a.linha + "," + mov.a.coluna + ")-->(" + mov.b.linha + "," + mov.b.coluna + ")");
        System.out.println("---\n");
    }

    public static List<Movimentacao> constructCandidates(final Stack<Movimentacao> sol, Posicao a) {
        List<Movimentacao> cand = new ArrayList();

        Posicao b1 = new Posicao(a.linha + 1, a.coluna);
        if (eValido(b1))
            cand.add(new Movimentacao(a, b1));
        Posicao b2 = new Posicao(a.linha, a.coluna + 1);
        if (eValido(b2))
            cand.add(new Movimentacao(a, b2));
        Posicao b3 = new Posicao(a.linha - 1, a.coluna);
        if (eValido(b3))
            cand.add(new Movimentacao(a, b3));
        Posicao b4 = new Posicao(a.linha, a.coluna - 1);
        if (eValido(b4))
            cand.add(new Movimentacao(a, b4));

        return cand;
    }

    private static boolean estaEm(int[] a, int n) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == n)
                return true;
        return false;
    }

    private static boolean eValido(Posicao pos) {
        if (pos.linha >= 0 && pos.linha < labirinto.length
                && pos.coluna >= 0 && pos.coluna < labirinto[0].length
                && labirinto[pos.linha][pos.coluna] != 1
                && labirinto[pos.linha][pos.coluna] != 2)
            return true;
        return false;
    }
}
