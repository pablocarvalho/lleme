package patterns.composite;

import patterns.prototype.Nomeavel;

public abstract class Item implements Nomeavel {

    private String nome;
    private double variacao;

    public Item(String nome, double variacao) {
        this.nome = nome;
        this.variacao = variacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVariacao() {
        return variacao;
    }

    public void setVariacao(double variacao) {
        this.variacao = variacao;
    }

    public void imprimir() {
        System.out.println(getNome() + ", variação: " + getVariacao());
    }
}
