package uff.ic.lleme.tic10002.aulas.s20181.poo;

public class Empregado extends Pessoa {

    private static String paiz = "Brasil";
    private int matricula;
    private double salario;
    private int dependentes;
    private Departamento departamento;

    public Empregado() {
        matricula = 0;
    }

    public Empregado(int matricula, String nome) {
        super.setNome(nome);
    }

    public static String getPaiz() {
        return paiz;
    }

    public static void setPaiz(String aPaiz) {
        paiz = aPaiz;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double salario() {
        return getSalario() * (1 + getDependentes() * 0.005 + getDepartamento().participacao);
    }

    public double salario(double desconto) {
        return getSalario() * (1 + getDependentes() * 0.005 + getDepartamento().participacao);
    }

    private void metodo2() {

    }
}
