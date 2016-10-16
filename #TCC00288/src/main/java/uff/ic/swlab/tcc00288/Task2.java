package uff.ic.swlab.tcc00288;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Task2 implements Runnable {

    @Override
    public void run() {
        try (Connection conn = connect();) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            try (Statement st = conn.createStatement();) {
                Thread.sleep(0);
                st.executeUpdate("INSERT INTO accounts (name,balance) VALUES('Luiz',1000.0);");
                conn.commit();
                System.out.println("Terminou thread 2.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Erro thread 2!");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tcc00287", "postgres", "fluminense");
        Statement st = conn.createStatement();
        st.executeUpdate("set schema 'default';");
        return conn;
    }

}
