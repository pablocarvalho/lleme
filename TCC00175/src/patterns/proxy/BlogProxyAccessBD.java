package patterns.proxy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BlogProxyAccessBD extends ObjetoAccessBD implements Blog {

    private Blog blog;
    private Timestamp timestampOriginal = null;
    private int idUsuario;

    public BlogProxyAccessBD(int id, Blog blog) throws ClassNotFoundException,
            SQLException, Exception {
        this.blog = blog;
        loadBD(id);
    }

    private void loadBD(int id) throws SQLException, ClassNotFoundException, Exception {
        ResultSet resultSet = getConnection().createStatement().
                executeQuery("select * from Blog where id=" + id);

        if (resultSet.next()) {
            blog.setId(resultSet.getInt("id"));
            blog.setNome(resultSet.getString("nome"));
            idUsuario = resultSet.getInt("usuario");
            timestampOriginal = resultSet.getTimestamp("timestamp");
        }
        if (getUsuario().getId() != idUsuario)
            setUsuario(null);
    }

    public int getId() {
        return blog.getId();
    }

    public String getNome() {
        return blog.getNome();
    }

    public Usuario getUsuario() throws ClassNotFoundException, SQLException, Exception {
        if (blog.getUsuario() == null)
            blog.setUsuario(getFabrica().createUsuario(idUsuario));
        return blog.getUsuario();
    }

    public Timestamp getTimestamp() {
        return blog.getTimestamp();
    }

    public void setId(int id) {
        this.blog.setId(id);
    }

    public void setNome(String nome) {
        this.blog.setNome(nome);
    }

    public void setUsuario(Usuario usuario) {
        idUsuario = usuario.getId();
        this.blog.setUsuario(usuario);
    }

    public void setTimestamp(Timestamp timestamp) {
        this.blog.setTimestamp(timestamp);
    }

    public void atualizar() throws ClassNotFoundException, SQLException, Exception {
        loadBD(blog.getId());
    }

    public void persistir() throws ClassNotFoundException, SQLException, Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String updateStr = "update Blog set "
                + " id=" + blog.getId()
                + ", nome='" + blog.getNome() + "'"
                + ", cpf=" + blog.getUsuario().getId()
                + ", timestamp=#" + sdf.format(Calendar.getInstance().getTime()) + "#"
                + " where id=" + blog.getId() + " and timestamp=#"
                + sdf.format(timestampOriginal) + "#";
        int resultSet = getConnection().createStatement().
                executeUpdate(updateStr);
        if (resultSet == 0)
            throw new Exception("Blog modificado anteriormente") {
            };
    }
}
