package ic.tcc00175.biblioteca.oldmodel;

public class CD extends Material {

    private static final long serialVersionUID = 7275695054013329910L;

    public CD() {
        super();
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getInformacoes() {
        return "Autores: " + getAutores() + ", " + getAno();
    }
    private String autores = null;
    private int ano = 0;
}
