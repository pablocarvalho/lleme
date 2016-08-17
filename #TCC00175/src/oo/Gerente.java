package oo;

public class Gerente extends Funcionario implements Usuario {

    public Gerente(String nome) {
        super(nome);
    }

    public Gerente() {
        super("");
        System.out.println("");
    }

    public void login(String id, String senha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void logout() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float calculaSalario(float comissao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
