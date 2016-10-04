

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TCC00287 {

    private static Connection connection = null;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connectPostgres();
        executeDeletePostgres();
        executeInsertPostgres();
        executeSelectPostgres();
        executeProcedurePostgres();
        connection.close();

        //
        //
        connectMySQL();
        executeDeleteMySQL();
        executeInsertMySQL();
        executeSelectMySQL();
        executeProcedureMySQL();
        connection.close();

    }
    public static void executeDeletePostgres() throws SQLException {
        String delete = "DELETE FROM \"EMPREGADO\";";
        Statement st = connection.createStatement();
        st.executeUpdate(delete);
    }
    public static void executeInsertPostgres() throws SQLException {
        String insert = "INSERT INTO \"EMPREGADO\"\n "
                + "(\"FNOME\", \"MINICIAL\", \"UNOME\", \"SSN\", \"DATANASC\", \"ENDERECO\", "
                + " \"SEXO\", \"SALARIO\", \"SUPERSSN\", \"DNO\")\n "
                + "  VALUES ('Luiz', 'P', 'Leme', 123, null, null, 'M', null, null, 0);";
        Statement st = connection.createStatement();
        st.executeUpdate(insert);
    }
    public static void executeSelectPostgres() throws SQLException {
        String select = "SELECT \"FNOME\", \"UNOME\" FROM \"EMPREGADO\";";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next())
            System.out.println(rs.getString("FNOME") + " " + rs.getString("UNOME"));
    }
    public static void executeProcedurePostgres() throws SQLException {
        String select = "SELECT * FROM select_employees();";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next())
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
    }
    public static void connectPostgres() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/tcc00287", "postgres", "fluminense");
        Statement st = connection.createStatement();
        st.executeUpdate("set schema 'default';");
    }
    public static void connectMySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "fluminense");
        props.put("useSSL", "false");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tcc00287", props);
    }
    private static void executeDeleteMySQL() throws SQLException {
        String delete = "DELETE FROM EMPREGADO;";
        Statement st = connection.createStatement();
        st.executeUpdate(delete);
    }
    private static void executeInsertMySQL() throws SQLException {
        String insert = "INSERT INTO EMPREGADO\n "
                + "(FNOME, MINICIAL, UNOME, SSN, DATANASC, ENDERECO, "
                + " SEXO, SALARIO, SUPERSSN, DNO)\n "
                + "  VALUES ('Luiz', 'P', 'Leme', 123, null, null, 'M', null, null, 0);";
        Statement st = connection.createStatement();
        st.executeUpdate(insert);
    }
    public static void executeSelectMySQL() throws SQLException {
        String select = "SELECT FNOME, UNOME FROM EMPREGADO;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while (rs.next())
            System.out.println(rs.getString("FNOME") + " " + rs.getString("UNOME"));
    }
    /**
     * @see
     * <a href="https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-statements-callable.html">Connector-J</a><br>
     * <a href="https://docs.oracle.com/javase/tutorial/jdbc/basics/storedprocedures.html">Connector-J</a>
     */
    public static void executeProcedureMySQL() throws SQLException {
        CallableStatement cs = connection.prepareCall("{call select_employees(?)}");
        cs.setString(1, "DFHFGHDF");
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            System.out.println(first_name + " " + last_name);
        }

    }
}
