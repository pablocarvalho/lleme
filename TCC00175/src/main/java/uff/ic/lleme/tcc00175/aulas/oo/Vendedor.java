package uff.ic.lleme.tcc00175.aulas.oo;

import uff.ic.lleme.tcc00175.aulas.oo.Funcionario;

public class Vendedor extends Funcionario {

    public Vendedor() {
        super("nao definido");
    }

    public float calculaSalario() {
        return 0;
    }

    public float calculaSalario(float comissao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void login(String id, String senha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void logout() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
