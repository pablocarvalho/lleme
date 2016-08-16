package provas.s20141.vr20141.q2;

public class MinhaClasse implements Comparavel {

    public String nome;

    public MinhaClasse(String nome) {
        this.nome = nome;
    }

    @Override
    public int comparar(Comparavel o) {
        MinhaClasse c = (MinhaClasse) o;
        return this.nome.compareTo(c == null ? null : c.nome);
    }

    @Override
    public String toString() {
        return nome;
    }

}
