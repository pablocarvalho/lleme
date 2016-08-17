package patterns.proxy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class UsuarioProxyAccessBD extends ObjetoAccessBD implements Usuario {

    private Usuario usuario;
    private Timestamp originalTimestamp = null;

    public UsuarioProxyAccessBD(int id, Usuario usuario) throws ClassNotFoundException,
            SQLException, CloneNotSupportedException, Exception {
        this.usuario = usuario;
        loadBD(id);
    }

    private void loadBD(int id) throws ClassNotFoundException,
            SQLException, CloneNotSupportedException, ClassNotFoundException,
            Exception {
        ResultSet resultSet = getConnection().createStatement().
                executeQuery("select * from Usuario where id=" + id);
        if (resultSet.next()) {
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setCpf(resultSet.getLong("cpf"));
            Endereco endereco = new Endereco(resultSet.getString("logradouro"),
                    resultSet.getString("bairro"));
            usuario.setEndereco(endereco);
            usuario.setTimestamp(resultSet.getTimestamp("timestamp"));
            originalTimestamp = usuario.getTimestamp();
        }
        usuario.setBlogs(null);
    }

    public long getCpf() {
        return usuario.getCpf();
    }

    public Endereco getEndereco() {
        return usuario.getEndereco();
    }

    public int getId() {
        return usuario.getId();
    }

    public String getNome() {
        return usuario.getNome();
    }

    public void setCpf(long cpf) {
        usuario.setCpf(cpf);
    }

    public void setEndereco(Endereco endereco) {
        usuario.setEndereco(endereco);
    }

    public void setId(int id) {
        usuario.setId(id);
    }

    public void setNome(String nome) {
        usuario.setNome(nome);
    }

    public Timestamp getTimestamp() {
        return usuario.getTimestamp();
    }

    public void setTimestamp(Timestamp date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Set<Blog> getBlogs() throws ClassNotFoundException, SQLException, Exception {
        if (usuario.getBlogs() == null) {
            setBlogs(new HashSet<Blog>());
            ResultSet resultSet = getConnection().createStatement().
                    executeQuery("select id from Blog where usuario=" + usuario.getId());
            while (resultSet.next()) {
                Blog blog = getFabrica().createBlog(resultSet.getInt("id"));
                blog.setUsuario(this);
                usuario.getBlogs().add(blog);
            }
        }
        return usuario.getBlogs();
    }

    public void persistir() throws ClassNotFoundException, SQLException, Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String updateStr = "update usuario set "
                + " id=" + usuario.getId()
                + ", nome='" + usuario.getNome() + "'"
                + ", cpf=" + usuario.getCpf()
                + ", logradouro='" + usuario.getEndereco().logradouro + "'"
                + ", bairro='" + usuario.getEndereco().bairro + "'"
                + ", timestamp=#" + sdf.format(Calendar.getInstance().getTime()) + "#"
                + " where id=" + usuario.getId() + " and timestamp=#"
                + sdf.format(originalTimestamp) + "#";
        int resultSet = getConnection().createStatement().
                executeUpdate(updateStr);
        if (resultSet == 0)
            throw new Exception("Usuario modificado anteriormente") {
            };
        for (Blog blog : getBlogs())
            blog.persistir();
    }

    public void atualizar() throws ClassNotFoundException, SQLException, Exception {
        loadBD(getId());
    }

    public void setBlogs(Set<Blog> blogs) {
        usuario.setBlogs(blogs);
    }
}
