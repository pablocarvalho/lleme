package uff.ic.lleme.tcc00328.provas.s20152.p120152;

public class Jurado {

    public String nome = null;
    public Quesito quesito = null;

    private Jurado() {
    }

    public Jurado(String nome, Quesito quesito) {
        this.nome = nome;
        this.quesito = quesito;
    }
}
