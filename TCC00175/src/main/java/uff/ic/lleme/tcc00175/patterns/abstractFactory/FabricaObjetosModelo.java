package uff.ic.lleme.tcc00175.patterns.abstractFactory;

import java.sql.SQLException;
import uff.ic.lleme.tcc00175.patterns.proxy.Blog;
import uff.ic.lleme.tcc00175.patterns.proxy.Usuario;

public abstract class FabricaObjetosModelo {

    public abstract Usuario createUsuario(int id) throws ClassNotFoundException,
            SQLException, Exception;

    public abstract Blog createBlog(int id) throws ClassNotFoundException,
            SQLException, Exception;
}
