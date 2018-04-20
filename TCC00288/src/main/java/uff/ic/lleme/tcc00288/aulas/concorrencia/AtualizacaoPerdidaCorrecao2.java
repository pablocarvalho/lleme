package uff.ic.lleme.tcc00288.aulas.concorrencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.postgresql.util.PSQLException;

public class AtualizacaoPerdidaCorrecao2 {

    public static void main(String[] args) throws InterruptedException {
        Config.initBD();
        Thread t1 = startTransactionT1();
        Thread t2 = startTransactionT2();
        t1.join();
        t2.join();
    }

    private static Thread startTransactionT1() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(false);
                        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                        try (Statement st = conn.createStatement();) {
                            long x = 0;
                            {// Parte 1
                                ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x' for update;");
                                if (rs1.next())
                                    x = rs1.getLong("valor");
                                System.out.println(String.format("Transacao 1 le x = %d", x));
                                int N = 5;
                                System.out.println(String.format("Transacao 1 faz x = %d - %d", x, N));
                                x = x - N;
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                            }

                            long y = 0;
                            {// Parte 2
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                System.out.println(String.format("Transacao 1 salva x = %d", x));
                                ResultSet rs2 = st.executeQuery("select valor from tabela where chave = 'y' for update;");
                                if (rs2.next())
                                    y = rs2.getLong("valor");
                                System.out.println(String.format("Transacao 1 le y = %d", y));
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                            }

                            {// Parte 3
                                int N = 3;
                                System.out.println(String.format("Transacao 1 faz y = %d + %d", y, N));
                                y = y + 3;
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", y, "'y'"));
                                System.out.println(String.format("Transacao 1 salva y = %d", y));
                            }
                            conn.commit();

                            long novox = 0;
                            ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x' for update;");
                            if (rs1.next())
                                novox = rs1.getLong("valor");
                            System.out.println(String.format("Transacao 1 le x = %d igual a leitura anterior de x = %d", novox, x));
                        } catch (PSQLException e) {
                            conn.rollback();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        t.start();
        return t;
    }

    private static Thread startTransactionT2() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                boolean run = false;
                do {
                    run = false;
                    try {
                        Class.forName("org.postgresql.Driver");
                        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                            conn.setAutoCommit(false);
                            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                            try (Statement st = conn.createStatement();) {

                                long x = 0;
                                {// Parte 1
                                    System.out.println("Transacao 2 em processamento...");
                                    Thread.sleep(1000);
                                    ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                                    if (rs1.next())
                                        x = rs1.getLong("valor");
                                    System.out.println(String.format("Transacao 2 le x = %d", x));
                                    int N = 8;
                                    System.out.println(String.format("Transacao 2 faz x = %d - %d", x, N));
                                    x = x - 8;
                                    System.out.println("Transacao 2 em processamento...");
                                    Thread.sleep(2000);
                                }

                                {// Parte 2
                                    st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                    System.out.println(String.format("Transacao 2 salva x = %d", x));
                                }
                                conn.commit();

                            } catch (PSQLException e) {
                                conn.rollback();
                                if (e.getSQLState().equals("40001")) {
                                    System.out.println("Transacao 2 ira reiniciar por problemas de serializacao.");
                                    run = true;
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (run);
            }
        };
        t.start();
        return t;
    }
}
