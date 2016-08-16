
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class Teste2JDBC {

    public static void main(String[] args) {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "lleme",
                    "lleme");

            String query = "BEGIN LISTA_USUARIO(?); END;";
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();
            try (ResultSet rs = (ResultSet) cstmt.getObject(1)) {
                while (rs.next()) {
                    System.out.println(rs.getLong("id"));
                    System.out.println(rs.getString("nome"));
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(TestJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
