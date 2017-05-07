package uff.ic.tcc00175.patterns.abstractFactory;

import java.sql.SQLException;
import uff.ic.tcc00175.patterns.proxy.Blog;
import uff.ic.tcc00175.patterns.proxy.BlogModelo;
import uff.ic.tcc00175.patterns.proxy.BlogProxyAccessBD;
import uff.ic.tcc00175.patterns.proxy.Usuario;
import uff.ic.tcc00175.patterns.proxy.UsuarioModelo;
import uff.ic.tcc00175.patterns.proxy.UsuarioProxyAccessBD;

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
