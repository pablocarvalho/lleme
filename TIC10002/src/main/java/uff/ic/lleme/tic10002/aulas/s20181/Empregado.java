package uff.ic.lleme.tic10002.aulas.s20181;

public class Empregado extends Pessoa {

    private int matricula;
    private double salario;
    private int dependentes;
    private Departamento departamento;
    private static String paiz = "Brasil";

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Empregado() {
        matricula = 0;

    }

    public Empregado(int matricula, String nome) {
        super.setNome(nome);

    }

    public double salario() {
        return salario * (1 + dependentes * 0.005 + departamento.participacao);
    }

    public double salario(double desconto) {
        return salario * (1 + dependentes * 0.005 + departamento.participacao);
    }

    private void metodo2() {

    }
}
