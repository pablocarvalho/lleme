package exercicios.blog;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Nota extends Conteudo {

    /**
     * @associates <{exercicios.blog.Comentario}>
     */
    private final Map<Date, Comentario> comentarios = new HashMap<>();

    public Nota(Usuario autor, String mensagem) {
        super(autor, mensagem);
    }

    public Comentario[] obterComentarios() {
        return comentarios.entrySet().toArray(new Comentario[0]);
    }

    public void incluirComentario(Comentario comentario) {
        comentarios.put(comentario.obterDataDeCriacao(), comentario);
    }

    public Comentario excluirComentario(Comentario comentario) {
        return comentarios.remove(comentario.obterDataDeCriacao());
    }

    public Comentario obterComentario(Date dataDeCriacaoComentario) {
        return comentarios.get(dataDeCriacaoComentario);
    }

    public Comentario[] listarComentarios() {
        int i = 0;
        Comentario[] lista = new Comentario[comentarios.size()];
        for (Map.Entry<Date, Comentario> entry : comentarios.entrySet())
            lista[i++] = entry.getValue();
        return lista;
    }
}
