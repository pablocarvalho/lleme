package provas.s20121.p120121ex1;

import java.util.Date;

public abstract class Funcionario {

    public String nome;
    public Date admissao;
    public float cargaHoraria;
    public Date ferias;
    public float salario;

    public Funcionario(String nome, Date admissao, float cargaHoraria) {
        this.nome = nome;
        this.admissao = admissao;
        this.cargaHoraria = cargaHoraria;
    }

    public abstract void accept(Visitante visitante);
}
