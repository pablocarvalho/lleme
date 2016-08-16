package patterns.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import patterns.abstractFactory.FabricaObjetosModelo;
import patterns.abstractFactory.FabricaObjetosModeloAccess;

public abstract class ObjetoAccessBD {

    private static Connection con;
    private static FabricaObjetosModelo fabrica = new FabricaObjetosModeloAccess();

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Blog", "", "");
        }
        return con;
    }

    public static void close() throws SQLException {
        con.close();
    }

    public static FabricaObjetosModelo getFabrica() {
        return fabrica;
    }
}
