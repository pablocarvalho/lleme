package uff.ic.lleme.tcc00288.aulas.concorrencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                        ativarControleTransacaoComIsolamento(conn);

                        try {
                            long x = 0;
                            {// Parte 1
                                x = lerX(conn);
                                System.out.println(String.format("Transacao 1 le x = %d", x));
                                int N = 5;
                                System.out.println(String.format("Transacao 1 faz x = %d - %d", x, N));
                                x = x - N;
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                            }

                            long y = 0;
                            {// Parte 2
                                escreverX(conn, x);
                                System.out.println(String.format("Transacao 1 salva x = %d", x));
                                y = lerY(conn);
                                System.out.println(String.format("Transacao 1 le y = %d", y));
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                            }

                            {// Parte 3
                                int N = 3;
                                System.out.println(String.format("Transacao 1 faz y = %d + %d", y, N));
                                y = y + 3;
                                escreverY(conn, y);
                                System.out.println(String.format("Transacao 1 salva y = %d", y));
                            }
                            conn.commit();

                            long novox = lerXNovamente(conn);
                            System.out.println(String.format("Transacao 1 le x = %d igual a leitura anterior de x = %d <--------", novox, x));

                        } catch (SQLException e) {
                            conn.rollback();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            // <editor-fold defaultstate="collapsed" desc=" ${ativarControleTransacaoComIsolamento} ">
            private void ativarControleTransacaoComIsolamento(final Connection conn) throws SQLException {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${lerX} ">
            private long lerX(final Connection conn) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    long x = 0;
                    ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                    if (rs1.next())
                        x = rs1.getLong("valor");
                    return x;
                }
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${lerY} ">
            private long lerY(final Connection conn) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    long y = 0;
                    ResultSet rs2 = st.executeQuery("select valor from tabela where chave = 'y';");
                    if (rs2.next())
                        y = rs2.getLong("valor");
                    return y;
                }
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${lerXNovamente} ">
            private long lerXNovamente(final Connection conn) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    long novox = 0;
                    ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                    if (rs1.next())
                        novox = rs1.getLong("valor");
                    return novox;
                }
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${escreverX} ">
            private void escreverX(final Connection conn, long x) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                }
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${escreverY} ">
            private void escreverY(final Connection conn, long y) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", y, "'y'"));
                }
            }
            // </editor-fold>

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
                            ativarControleTransacaoComIsolamento(conn);

                            try (Statement st = conn.createStatement();) {

                                long x = 0;
                                {// Parte 1
                                    System.out.println("Transacao 2 em processamento...");
                                    Thread.sleep(1000);
                                    x = lerX(conn);
                                    System.out.println(String.format("Transacao 2 le x = %d", x));
                                    int N = 8;
                                    System.out.println(String.format("Transacao 2 faz x = %d - %d", x, N));
                                    x = x - 8;
                                    System.out.println("Transacao 2 em processamento...");
                                    Thread.sleep(2000);
                                }

                                {// Parte 2
                                    escreverX(conn, x);
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

            // <editor-fold defaultstate="collapsed" desc=" ${ativarControleTransacaoComIsolamento} ">
            private void ativarControleTransacaoComIsolamento(final Connection conn) throws SQLException {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${lerX} ">
            private long lerX(final Connection conn) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    long x = 0;
                    ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                    if (rs1.next())
                        x = rs1.getLong("valor");
                    return x;
                }
            }
            // </editor-fold>

            // <editor-fold defaultstate="collapsed" desc=" ${esxceverX} ">
            private void escreverX(final Connection conn, long x) throws SQLException {
                try (Statement st = conn.createStatement();) {
                    st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                }
            }
            // </editor-fold>
        };
        t.start();
        return t;
    }
}
