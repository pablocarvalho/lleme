package uff.ic.lleme.tcc00175.patterns.proxy;

import java.sql.SQLException;
import uff.ic.lleme.tcc00175.patterns.abstractFactory.FabricaObjetosModelo;
import uff.ic.lleme.tcc00175.patterns.abstractFactory.FabricaObjetosModeloAccess;

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
