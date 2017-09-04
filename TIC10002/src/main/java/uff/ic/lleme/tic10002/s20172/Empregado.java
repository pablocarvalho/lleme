package uff.ic.lleme.tic10002.s20172;

public class Empregado {

    public int matricula;
    public String nome;
    public String cargo;
    public float salario;

    public void aumentarSalario(float indice) {
        salario = salario * (1 + indice / 100);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
