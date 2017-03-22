package uff.ic.lleme.ttic10002;

public class Empregado implements Comparable<Empregado> {

    public String nome = null;

    @Override
    public int compareTo(Empregado o) {
        return this.nome.compareTo(o.nome);
    }

}
