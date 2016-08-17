package patterns.abstractFactory;

import java.sql.SQLException;
import patterns.proxy.Blog;
import patterns.proxy.Usuario;

public abstract class FabricaObjetosModelo {

    public abstract Usuario createUsuario(int id) throws ClassNotFoundException,
            SQLException, Exception;

    public abstract Blog createBlog(int id) throws ClassNotFoundException,
            SQLException, Exception;
}
