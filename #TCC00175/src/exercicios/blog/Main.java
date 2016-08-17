package exercicios.blog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        EditorDeBlog editor = new EditorDeBlog();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");

        try {

            String email1 = "lapaesleme@ic.uff.br";
            String nome1 = "Luiz Andre";
            editor.cadastrarUsuario(email1, nome1);

            String email2 = "outro@ic.uff.br";
            String nome2 = "Outro usuario";
            editor.cadastrarUsuario(email2, nome2);

            String titulo1 = " TPA";
            editor.criarBlog(email1, titulo1);

            String[] blogs = editor.listarBlogs();
            // Buscar na lista de Blogs o blog de interese
            String[][] usuarios = editor.listarUsuarios();
            // Buscar na lista de usuarios

            String tituloBlog = titulo1;
            String nota1 = "Primeira nota";
            editor.publicarNota(tituloBlog, email1, nota1);

            String[][] notas = editor.listarNotas(titulo1);
            String comentario = "Comentario da nota";

            for (int i = 0; i < notas.length; i++)
                if (notas[i][1].equals(nota1)) {
                    String ds = notas[i][0];
                    Date data = sdf.parse(notas[i][0]);
                    editor.publicarComentario(titulo1, data, email2, comentario);
                }

            String[][] conteudo = editor.obterConteudos(tituloBlog);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
