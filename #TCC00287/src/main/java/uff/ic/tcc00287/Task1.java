package uff.ic.tcc00287;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 implements Runnable {

    @Override
    public void run() {
        try (Connection conn = connect();) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            try (Statement st = conn.createStatement();) {
                System.out.println(Arrays.toString(getBalances(conn)));
                Thread.sleep(2000);
                st.executeUpdate("UPDATE accounts SET balance = balance - 100.00;");
                conn.commit();
                System.out.println(Arrays.toString(getBalances(conn)));
                System.out.println("Terminou thread 1");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Erro thread 1");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public String[] getBalances(Connection conn) throws SQLException {
        List<String> result = new ArrayList<>();
        try (Statement st = conn.createStatement();) {
            ResultSet rs = st.executeQuery("SELECT * FROM accounts;");
            while (rs.next())
                result.add(rs.getString("name") + ": " + rs.getDouble("balance"));
        }
        return result.toArray(new String[0]);
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tcc00287", "postgres", "fluminense");
        Statement st = conn.createStatement();
        st.executeUpdate("set schema 'default';");
        return conn;
    }

}
