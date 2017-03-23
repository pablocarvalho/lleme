package uff.ic.lleme.ttic10002;

public class Empregado implements Entidade, Comparable<Empregado> {

    public String nome = null;
    public String cpf = null;

    @Override
    public int compareTo(Empregado o) {
        return this.chave().compareTo(o.chave());
    }

    @Override
    public String chave() {
        return cpf;
    }

}
