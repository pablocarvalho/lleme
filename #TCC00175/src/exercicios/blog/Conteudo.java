package exercicios.blog;

import java.util.Calendar;
import java.util.Date;

public class Conteudo implements Comparable<Conteudo> {

    private Date dataDeCriacao;
    private String mensagem;
    private Usuario autor;

    public Conteudo(Usuario autor, String mensagem) {
        this.mensagem = mensagem;
        this.autor = autor;
        this.dataDeCriacao = Calendar.getInstance().getTime();
    }

    public Date obterDataDeCriacao() {
        return dataDeCriacao;
    }

    public String obterMensagem() {
        return mensagem;
    }

    public Usuario obterAutor() {
        return autor;
    }

    @Override
    public int compareTo(Conteudo o) {
        return dataDeCriacao.compareTo(o.dataDeCriacao);
    }

    @Override
    public boolean equals(Object o) {
        return dataDeCriacao.equals(o);
    }
}
