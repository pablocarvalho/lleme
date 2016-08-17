package patterns.proxy;

import java.sql.SQLException;
import patterns.abstractFactory.FabricaObjetosModelo;
import patterns.abstractFactory.FabricaObjetosModeloAccess;

public class Main {

    public static void main(String[] args) throws SQLException, Exception {

        FabricaObjetosModelo fabrica = new FabricaObjetosModeloAccess();
        Usuario usuario = fabrica.createUsuario(1);
        System.out.println(usuario.getNome());
        usuario.setNome("outro nome");
        usuario.getBlogs();
        System.out.println(usuario.getNome());
        usuario.persistir();
        UsuarioProxyAccessBD.close();
    }
}
