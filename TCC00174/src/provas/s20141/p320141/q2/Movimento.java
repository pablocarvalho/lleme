package provas.s20141.p320141.q2;

import java.util.Objects;

public class Movimento implements Comparable {

    public final Pos a;
    public final Pos m;
    public final Pos b;
    private static final Tabuleiro tabuleiro = Tabuleiro.obterInstancia();

    public Movimento(Pos a, Pos b) {
        this.a = a;
        this.b = b;
        this.m = new Pos((a.i + b.i) / 2, (a.j + b.j) / 2);
    }

    public int score() {
        return tabuleiro.calcularScore(this);
    }

    @Override
    public int compareTo(Object o) {
        Movimento m2 = (Movimento) o;
        return (int) Math.signum(this.score() - m2.score());
    }

    @Override
    public boolean equals(Object o) {
        Movimento mv = (Movimento) o;
        return this.a.equals(mv.a) && this.m.equals(mv.m)
            && this.b.equals(mv.b);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.a);
        hash = 97 * hash + Objects.hashCode(this.m);
        hash = 97 * hash + Objects.hashCode(this.b);
        return hash;
    }

}
