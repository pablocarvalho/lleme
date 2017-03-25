package uff.ic.lleme.ttic10002;

public class Empregado extends Entidade<String, Empregado> {

    public String cpf = null;
    public String nome = null;

    @Override
    public int compareTo(Empregado emp) {
        return this.cpf.compareTo(emp.cpf);
    }

    @Override
    public String getChave() {
        return cpf;
    }

}
