package oo.dicionario;

public class Entrada {

    private String vocabulo;
    private String significado;

    public Entrada(String vocabulo, String significado) {
        this.vocabulo = vocabulo;
        this.significado = significado;
    }

    public void setVocabulo(String vocabulo) {
        this.vocabulo = vocabulo;
    }

    public String getVocabulo() {
        return vocabulo;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getSignificado() {
        return significado;
    }
}
