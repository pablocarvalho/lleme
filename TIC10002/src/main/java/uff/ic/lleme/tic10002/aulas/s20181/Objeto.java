package uff.ic.lleme.tic10002.aulas.s20181;

public class Objeto {

    public Double chave;

    public Objeto(Double chave) {
        this.chave = chave;
    }

    public Objeto(double chave) {
        this.chave = chave;
    }

    public Objeto(int chave) {
        this.chave = chave * 1.;
    }
}
