package patterns.proxy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Set;

public interface Usuario {

    public long getCpf();

    public Endereco getEndereco();

    public int getId();

    public String getNome();

    public Timestamp getTimestamp();

    public void setCpf(long cpf);

    public void setEndereco(Endereco endereco);

    public void setId(int id);

    public void setNome(String nome);

    public void setTimestamp(Timestamp timestamp);

    public Set<Blog> getBlogs() throws ClassNotFoundException, SQLException, Exception;

    public void setBlogs(Set<Blog> blogs);

    public void persistir() throws ClassNotFoundException, SQLException, Exception;

    public void atualizar() throws ClassNotFoundException, SQLException, Exception;
}
