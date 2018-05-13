package uff.ic.lleme.tic10002.aulas.s20181;

public class Conteudo {

    private String chave;

    private Conteudo() {

    }

    public Conteudo(String chave) {
        this.chave = chave;
    }

    public Conteudo(Double chave) {
        this.chave = Double.toString(chave);
    }

    public Conteudo(double chave) {
        this.chave = Double.toString(chave);
    }

    public Conteudo(int chave) {
        this.chave = Double.toString(chave * 1.);
    }

    public Double chaveAsNum() {
        return Double.parseDouble(chave);
    }

    public String chave() {
        return chave;
    }

    public String rotulo() {
        return chave;
    }

}
