package exercicios.blog;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Blog {

    private Date dataDeCriacao = null;
    private String titulo = null;
    private Usuario dono = null;
    /**
     * @associates <{exercicios.blog.Nota}>
     */
    private Map<Date, Nota> notas = new HashMap<>();

    private Blog() {
    }

    public Blog(Usuario dono, String titulo) {
        this.titulo = titulo;
        this.dono = dono;
        this.dataDeCriacao = Calendar.getInstance().getTime();
    }

    public Date obterDataDeCriacao() {
        return dataDeCriacao;
    }

    public void atribuirDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String obterTitulo() {
        return titulo;
    }

    public void atribuirTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario obterDono() {
        return dono;
    }

    public void atribuirDono(Usuario dono) {
        this.dono = dono;
    }

    public Nota[] obterNotas() {
        return notas.entrySet().toArray(new Nota[0]);
    }

    public Nota excluirNota(Nota nota) {
        return notas.remove(nota.obterDataDeCriacao());
    }

    public void incluirNota(Nota nota) {
        notas.put(nota.obterDataDeCriacao(), nota);
    }

    public Nota obterNota(Date dataDeCriacaoNota) {
        return notas.get(dataDeCriacaoNota);
    }

    public Nota[] listarNotas() {
        int i = 0;
        Nota[] lista = new Nota[notas.size()];
        for (Map.Entry<Date, Nota> entry : notas.entrySet())
            lista[i++] = entry.getValue();
        return lista;
    }
}
