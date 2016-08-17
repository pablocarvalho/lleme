package patterns.proxy;

import java.sql.SQLException;
import java.sql.Timestamp;

public class BlogModelo implements Blog {

    private int id = 0;
    private String nome = null;
    private Usuario usuario = null;
    private Timestamp timestamp = null;

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void atualizar() throws ClassNotFoundException, SQLException, Exception {
        // Não faz nada
    }

    public void persistir() throws ClassNotFoundException, SQLException, Exception {
        // Não faz nada
    }
}
