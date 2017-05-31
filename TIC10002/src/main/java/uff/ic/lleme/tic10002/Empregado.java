package uff.ic.lleme.tic10002;

public class Empregado extends Entidade<String, Empregado> {

    public int chave = 0;
    public String cpf = null;
    public String nome = null;

    public Empregado(int chave) {
        this.chave = chave;
    }

    public Empregado(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int compareTo(Empregado emp) {
        return getChave().compareTo(emp.getChave());
    }

    @Override
    public String getChave() {
        return cpf;
    }

    public Integer compararChave(String cpf) {
        if (getChave() != null && cpf != null)
            return getChave().compareTo(cpf);
        else
            return null;
    }

    public Integer compararInstancia(Empregado empregado) {
        if (getChave() != null && empregado != null && empregado.getChave() != null)
            return getChave().compareTo(empregado.cpf);
        else
            return null;
    }

}
