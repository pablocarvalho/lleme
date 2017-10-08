package uff.ic.swlab.tcc00288;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AtualizacaoPerdida {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = startT1();
        Thread t2 = startT2();
        t1.join();
        t2.join();
    }

    private static Thread startT1() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Comecou transacao 1");
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(false);
                        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                        try (Statement st = conn.createStatement();) {
                            //st.executeUpdate("set schema 'schema';");
                            long x = 0;
                            {// Bloco 1
                                ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                                if (rs1.next())
                                    x = rs1.getLong("valor");
                                System.out.println(String.format("Transacao 1 le x=%d", x));
                                x = x - 5; // x=10
                                System.out.println(String.format("Transacao 1 faz x=%d", x));
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                                System.out.println("Transacao 1 continua.");
                            }

                            long y = 0;
                            {// Bloco 2
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                System.out.println(String.format("Transacao 1 salva x=%d", x));
                                ResultSet rs2 = st.executeQuery("select valor from tabela where chave = 'y';");
                                if (rs2.next())
                                    y = rs2.getLong("valor");
                                System.out.println(String.format("Transacao 1 le y=%d", y));
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(3000);
                                System.out.println("Transacao 1 continua.");
                            }

                            {// Bloco 3
                                y = y + 3;// y=20
                                System.out.println(String.format("Transacao 1 faz y=%d", y));
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", y, "'y'"));
                                System.out.println(String.format("Transacao 1 salva y=%d", y));
                            }
                            conn.commit();
                        } catch (Exception e) {
                            conn.rollback();
                            System.out.println("Erro transacao 1");
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Terminou trancacao 1");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        t.start();
        return t;
    }

    private static Thread startT2() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Comecou transacao 2");
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(false);
                        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                        try (Statement st = conn.createStatement();) {
                            long x = 0;
                            {// Bloco 1
                                ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                                if (rs1.next())
                                    x = rs1.getLong("valor");
                                System.out.println(String.format("Transacao 2 le x=%d", x));
                                x = x - 8; // x=10
                                System.out.println(String.format("Transacao 2 faz x=%d", x));
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(2000);
                                System.out.println("Transacao 2 continua.");
                            }

                            {// Bloco 2
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                System.out.println(String.format("Transacao 2 salva x=%d", x));
                            }
                            conn.commit();
                        } catch (Exception e) {
                            conn.rollback();
                            System.out.println("Erro trancacao 2");
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Terminou trancacao 2");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        t.start();
        return t;
    }

}
