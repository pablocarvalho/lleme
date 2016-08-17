package provas.s20141.p320141.q2;

public class Pos {

    public int i;
    public int j;

    public Pos(int linha, int coluna) {
        this.i = linha;
        this.j = coluna;
    }

    @Override
    public boolean equals(Object o) {
        Pos p = (Pos) o;
        return p != null && this.i == p.i && this.j == p.j;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.i;
        hash = 79 * hash + this.j;
        return hash;
    }

}
