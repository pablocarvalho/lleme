package provas.s20141.p320141.q2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Tabuleiro {

    private static Tabuleiro tab = null;
    private static int[][] estado = {
        {9, 9, 1, 1, 1, 9, 9},
        {9, 9, 1, 1, 1, 9, 9},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1},
        {9, 9, 1, 1, 1, 9, 9},
        {9, 9, 1, 1, 1, 9, 9}};
//    private final int[][] estado = {
//        {9, 1, 1, 1, 9},
//        {1, 1, 1, 1, 1},
//        {1, 1, 0, 1, 1},
//        {1, 1, 1, 1, 1},
//        {9, 1, 1, 1, 9}};
    private final Set<Pos> uns = new HashSet();

    public Queue<Movimento> movimentosPossiveis() {
        int k;
        int l;
        Queue<Movimento> cand = new PriorityQueue();
        for (Pos pu : uns) {
            k = pu.i;
            l = pu.j + 2;
            Movimento mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv))
                cand.add(mv);
            k = pu.i - 2;
            l = pu.j;
            mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv))
                cand.add(mv);
            k = pu.i;
            l = pu.j - 2;
            mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv))
                cand.add(mv);
            k = pu.i + 2;
            l = pu.j;
            mv = new Movimento(new Pos(pu.i, pu.j), new Pos(k, l));
            if (eValidoMov(mv))
                cand.add(mv);
        }
        return cand;
    }

    public void aplicarMov(Movimento mv) {
        if (mv != null && estado != null && eValidoMov(mv)) {
            estado[mv.a.i][mv.a.j] = 0;
            estado[mv.m.i][mv.m.j] = 0;
            estado[mv.b.i][mv.b.j] = 1;
            boolean r1 = uns.remove(mv.a);
            boolean r2 = uns.remove(mv.m);
            uns.add(mv.b);
        } else {
            System.out.println("(" + mv.a.i + "," + mv.a.j + ")-->(" + mv.b.i + "," + mv.b.j + ")");
            throw new IllegalArgumentException();
        }
    }

    public void desaplicarMov(Movimento mv) {
        if (mv != null && estado != null && eValidoRev(mv)) {
            estado[mv.a.i][mv.a.j] = 1;
            estado[mv.m.i][mv.m.j] = 1;
            estado[mv.b.i][mv.b.j] = 0;
            uns.add(mv.a);
            uns.add(mv.m);
            uns.remove(mv.b);
        } else {
            System.out.println("(" + mv.a.i + "," + mv.a.j + ")-->(" + mv.b.i + "," + mv.b.j + ")");
            throw new IllegalArgumentException();
        }
    }

    private boolean eValidoMov(Movimento mv) {
        if (mv != null && estado != null)
            if (mv.a.i >= 0 && mv.a.i < estado.length 
                && mv.a.j >= 0 && mv.a.j < estado[0].length
                && mv.b.i >= 0 && mv.b.i < estado.length 
                && mv.b.j >= 0 && mv.b.j < estado[0].length
                && Math.abs(mv.a.i - mv.b.i) <= 2 && Math.abs(mv.a.j - mv.b.j) <= 2
                && (Math.abs(mv.a.i - mv.b.i) == 2 || Math.abs(mv.a.j - mv.b.j) == 2)
                && estado[mv.a.i][mv.a.j] == 1 
                && estado[mv.m.i][mv.m.j] == 1
                && estado[mv.b.i][mv.b.j] == 0)
                return true;
        return false;
    }

    public boolean eValidoRev(Movimento mv) {
        if (mv != null && estado != null)
            if (mv.a.i >= 0 && mv.a.i < estado.length 
                && mv.a.j >= 0 && mv.a.j < estado[0].length
                && mv.b.i >= 0 && mv.b.i < estado.length 
                && mv.b.j >= 0 && mv.b.j < estado[0].length
                && Math.abs(mv.a.i - mv.b.i) <= 2 && Math.abs(mv.a.j - mv.b.j) <= 2
                && (Math.abs(mv.a.i - mv.b.i) == 2 || Math.abs(mv.a.j - mv.b.j) == 2)
                && estado[mv.a.i][mv.a.j] == 0 
                && estado[mv.m.i][mv.m.j] == 0
                && estado[mv.b.i][mv.b.j] == 1)
                return true;
        return false;
    }

    public Tabuleiro() {
        for (int i = 0; i < estado.length; i++)
            for (int j = 0; j < estado[0].length; j++)
                if (estado[i][j] == 1)
                    uns.add(new Pos(i, j));
    }

    public static Tabuleiro obterInstancia() {
        if (tab == null)
            tab = new Tabuleiro();
        return tab;
    }

    public int[][] obterEstado() {
        return estado;
    }

    public int calcularScore(Movimento mv) {
        Pos centro = new Pos(estado.length / 2, estado[0].length / 2);
        int raio = estado.length / 2;

        // Favorece movimento que cria casas varias na periferia do tabuleiro
        int deltaI1 = Math.abs(mv.a.i - centro.i);
        int deltaJ1 = Math.abs(mv.a.j - centro.j);
        int deltaI2 = Math.abs(mv.m.i - centro.i);
        int deltaJ2 = Math.abs(mv.m.j - centro.j);
        int score = raio - Math.max(deltaI1, deltaJ1) + raio - Math.max(deltaI2, deltaJ2);

        return score;
    }

    public int contarUns() {
        return uns.size();
    }

    private static int contaZeroEmTorno(Pos p, Pos exclusao) {
        int cont = 0;
        for (Pos pe : emTorno(p, null))
            if (!pe.equals(exclusao)
                && estado[pe.i][pe.j] == 0)
                cont++;
        return cont;
    }

    private static List<Pos> emTorno(Pos p, Pos exclusao) {
        List<Pos> pes = new ArrayList<>();
        Pos pe;
        if (p != null
            && p.i >= 0 && p.i < estado.length
            && p.j >= 0 && p.j < estado[0].length) {

            pe = new Pos(p.i - 1, p.j);
            if (pe.i >= 0 && pe.i < estado.length
                && pe.j >= 0 && pe.j < estado[0].length
                && !pe.equals(exclusao))
                pes.add(pe);

            pe = new Pos(p.i, p.j - 1);
            if (pe.i >= 0 && pe.i < estado.length
                && pe.j >= 0 && pe.j < estado[0].length
                && !pe.equals(exclusao))
                pes.add(pe);

            pe = new Pos(p.i + 1, p.j);
            if (pe.i >= 0 && pe.i < estado.length
                && pe.j >= 0 && pe.j < estado[0].length
                && !pe.equals(exclusao))
                pes.add(pe);

            pe = new Pos(p.i, p.j + 1);
            if (pe.i >= 0 && pe.i < estado.length
                && pe.j >= 0 && pe.j < estado[0].length
                && !pe.equals(exclusao))
                pes.add(pe);
        }
        return pes;
    }

}
