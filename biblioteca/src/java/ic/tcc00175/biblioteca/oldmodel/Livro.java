package ic.tcc00175.biblioteca.oldmodel;

import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.ReservaColecao;

public class Livro extends Material {

    private static final long serialVersionUID = -1549664849290346204L;

    public Livro() {
        super();
        lnkReserva = new ReservaColecao();
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getInformacoes() {
        return "Editora: " + getEditora() + ", Atutores: " + getAutores()
                + ", Edição: " + getEdicao() + "/" + getAnoPublicacao();
    }

    public ReservaColecao getLnkReserva() {
        return lnkReserva;
    }

    public void setLnkReserva(ReservaColecao lnkReserva) {
        this.lnkReserva = lnkReserva;
    }
    private String editora = null;
    private String autores = null;
    private int edicao = 0;
    private int anoPublicacao = 0;
    private ReservaColecao lnkReserva;
}
