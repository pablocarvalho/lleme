package patterns.abstractFactory;

import java.sql.SQLException;
import patterns.proxy.Blog;
import patterns.proxy.BlogModelo;
import patterns.proxy.BlogProxyAccessBD;
import patterns.proxy.Usuario;
import patterns.proxy.UsuarioModelo;
import patterns.proxy.UsuarioProxyAccessBD;

public class FabricaObjetosModeloAccess extends FabricaObjetosModelo {

    @Override
    public Usuario createUsuario(int id) throws ClassNotFoundException,
            SQLException, CloneNotSupportedException, Exception {
        return new UsuarioProxyAccessBD(id, new UsuarioModelo());
    }

    @Override
    public Blog createBlog(int id) throws ClassNotFoundException,
            SQLException, CloneNotSupportedException, Exception {
        return new BlogProxyAccessBD(id, new BlogModelo());
    }
}
