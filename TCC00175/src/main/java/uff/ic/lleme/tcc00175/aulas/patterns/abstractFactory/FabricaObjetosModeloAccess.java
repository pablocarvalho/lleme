package uff.ic.lleme.tcc00175.aulas.patterns.abstractFactory;

import java.sql.SQLException;
import uff.ic.lleme.tcc00175.aulas.patterns.proxy.Blog;
import uff.ic.lleme.tcc00175.aulas.patterns.proxy.BlogModelo;
import uff.ic.lleme.tcc00175.aulas.patterns.proxy.BlogProxyAccessBD;
import uff.ic.lleme.tcc00175.aulas.patterns.proxy.Usuario;
import uff.ic.lleme.tcc00175.aulas.patterns.proxy.UsuarioModelo;
import uff.ic.lleme.tcc00175.aulas.patterns.proxy.UsuarioProxyAccessBD;

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
