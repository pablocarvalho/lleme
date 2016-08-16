package patterns.proxy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class UsuarioModelo implements Usuario {

    private int id;
    private String nome;
    private long cpf;
    private Endereco endereco;
    private Timestamp timestamp;
    /**
     * @aggregation composite
     */
    private Set<Blog> blogs;

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public void persistir() throws ClassNotFoundException, SQLException, Exception {
        // não faz nada
    }

    public void atualizar() throws ClassNotFoundException, SQLException, Exception {
        // Não faz nada
    }
}
