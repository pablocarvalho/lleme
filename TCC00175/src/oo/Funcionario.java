package oo;

public abstract class Funcionario implements Usuario {

    protected String nome;
    protected float salario;

    private Funcionario() {
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public float calculaSalario() {
        salario = 10;
        return salario;
    }

    public abstract float calculaSalario(float comissao);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
