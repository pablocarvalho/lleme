package uff.ic.lleme.tic10002.utils;

public class Empregado extends Entidade<Integer, Empregado> {

    private Integer chave = 0;
    public String nome = null;

    private Empregado() {

    }

    public Empregado(int cpf) {
        this.chave = cpf;
    }

    @Override
    public Integer chave() {
        return chave;
    }

    public Integer cpf() {
        return chave;
    }

    @Override
    public int compareTo(Empregado emp) {
        return chave().compareTo(emp.chave());
    }

}
