package exercicios.blog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditorDeBlog {

    private BD bd = BD.getInstance();

    public EditorDeBlog() {
        super();
    }

    public void cadastrarUsuario(String email, String nome) throws Exception {
        Usuario usuario = new Usuario(email, nome);
        bd.saveUsuario(usuario);
    }

    public Blog criarBlog(String email, String titulo) throws Exception {
        Usuario usuario = bd.obterUsuario(email);
        Blog blog = new Blog(usuario, titulo);
        bd.saveBlog(blog);
        return blog;
    }

    public void publicarNota(String tituloBlog, String emailAutor, String mensagem) throws Exception {
        Nota nota = null;
        Blog blog = bd.obterBlog(tituloBlog);
        Usuario autor = bd.obterUsuario(emailAutor);
        if (blog.obterDono() == autor) {
            nota = new Nota(autor, mensagem);
            blog.incluirNota(nota);
        } else
            throw new Exception("Usuario n?o autorizado");
    }

    public void excluirNota(String tituloBlog, Date dataDeCriacaoNota) {
        Blog blog = bd.obterBlog(tituloBlog);
        Nota nota = blog.obterNota(dataDeCriacaoNota);
        Usuario autorNota = nota.obterAutor();

        blog.excluirNota(nota);
        for (Comentario comentario : nota.listarComentarios())
            if (autorNota != comentario.obterAutor())
                enviarEmail(comentario.obterAutor(), tituloBlog, dataDeCriacaoNota, comentario.obterDataDeCriacao());
    }

    public void publicarComentario(String tituloBlog, Date dataDeCriacaoNota, String emailAutor, String mensagem) {
        Blog blog = bd.obterBlog(tituloBlog);
        Nota nota = blog.obterNota(dataDeCriacaoNota);
        Usuario autor = bd.obterUsuario(emailAutor);
        Comentario comentario = new Comentario(autor, mensagem);
        nota.incluirComentario(comentario);
    }

    public void excluirComentario(String tituloBlog, Date dataDeCriacaoNota, Date dataDeCriacaoComentario) {
        Blog blog = bd.obterBlog(tituloBlog);
        Nota nota = blog.obterNota(dataDeCriacaoNota);
        Comentario comentario = nota.obterComentario(dataDeCriacaoComentario);
        Usuario autor = comentario.obterAutor();

        comentario = nota.excluirComentario(comentario);
        enviarEmail(autor, tituloBlog, dataDeCriacaoNota, dataDeCriacaoComentario);
    }

    private void enviarEmail(Usuario usuario, String tituloBlog, Date dataDeCriacaoNota, Date dataDeCriacaoComentario) {
        System.out.println("Email enviado para " + usuario.obterEmail());
    }

    public String[][] listarNotas(String tituloBlog) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Blog blog = bd.obterBlog(tituloBlog);
        Nota[] notas = blog.listarNotas();

        String[][] lista = new String[notas.length][3];
        for (int i = 0; i < notas.length; i++) {
            lista[i][0] = sdf.format(notas[i].obterDataDeCriacao());
            lista[i][1] = notas[i].obterMensagem();
            lista[i][2] = notas[i].obterAutor().obterEmail();
        }
        return lista;
    }

    public String[] listarBlogs() {
        Blog[] blogs = bd.listarBlogs();

        String[] lista = new String[blogs.length];
        for (int i = 0; i < lista.length; i++)
            lista[i] = blogs[i].obterTitulo();
        return lista;
    }

    public String[][] listarUsuarios() {
        Usuario[] usuarios = bd.listarUsuarios();

        String[][] lista = new String[usuarios.length][2];
        for (int i = 0; i < lista.length; i++) {
            lista[i][0] = usuarios[i].obterEmail();
            lista[i][1] = usuarios[i].obterNome();
        }
        return lista;
    }

    public String[][] obterConteudos(String tituloBlog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
