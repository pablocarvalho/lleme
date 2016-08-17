package oo;

public class Consultor extends Funcionario implements Usuario {

    public Gerente gerentes;

    public Consultor() {
        super("nao definido");
    }

    public float calculaSalario(float comissao) {
        super.calculaSalario();
        salario = salario + 100.0f;
        return salario;
    }

    public void login(String id, String senha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void logout() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
