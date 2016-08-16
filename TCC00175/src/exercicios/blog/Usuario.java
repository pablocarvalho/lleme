package exercicios.blog;

import java.util.HashSet;
import java.util.Set;

public class Usuario {

    private String nome = null;
    private String email = null;
    private Set<Blog> favoritos = new HashSet<Blog>();

    private Usuario() {
    }

    public Usuario(String email, String nome) {
        this.nome = nome;
        this.email = email;
    }

    public String obterNome() {
        return nome;
    }

    public void atribuirNome(String nome) {
        this.nome = nome;
    }

    public String obterEmail() {
        return email;
    }

    public void atribuirEmail(String email) {
        this.email = email;
    }
}
