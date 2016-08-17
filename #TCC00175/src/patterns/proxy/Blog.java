package patterns.proxy;

import java.sql.SQLException;
import java.sql.Timestamp;

public abstract interface Blog {

    public abstract int getId();

    public abstract String getNome();

    public abstract Usuario getUsuario() throws ClassNotFoundException,
            SQLException, Exception;

    public abstract Timestamp getTimestamp();

    public abstract void setId(int id);

    public abstract void setNome(String nome);

    public abstract void setUsuario(Usuario usuario);

    public abstract void setTimestamp(Timestamp timestamp);

    public void atualizar() throws ClassNotFoundException, SQLException, Exception;

    public void persistir() throws ClassNotFoundException, SQLException, Exception;
}
