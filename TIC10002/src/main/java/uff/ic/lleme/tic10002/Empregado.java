package uff.ic.lleme.tic10002;

public class Empregado extends Entidade<String, Empregado> {

    public String cpf = null;
    public String nome = null;

    @Override
    public int compareTo(Empregado emp) {
        return getChave().compareTo(emp.getChave());
    }

    @Override
    public String getChave() {
        return cpf;
    }

}
