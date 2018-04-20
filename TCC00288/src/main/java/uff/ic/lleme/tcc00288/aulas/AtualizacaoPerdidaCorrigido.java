package uff.ic.lleme.tcc00288.aulas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.postgresql.util.PSQLException;

public class AtualizacaoPerdidaCorrigido {

    public static void main(String[] args) throws InterruptedException {
        initTabela();
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
                    System.out.println("Comecou transacao 1.");
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(false);
                        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

                        try (Statement st = conn.createStatement();) {
                            long x = 0;
                            {// Parte 1
                                ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x' for update;");
                                if (rs1.next())
                                    x = rs1.getLong("valor");
                                System.out.println(String.format("Transacao 1 le x = %d", x));
                                System.out.println(String.format("Transacao 1 faz x = %d - 5", x));
                                x = x - 5;
                                System.out.println("Transacao 1 entra em espera...");
                                Thread.sleep(2000);
                                System.out.println("Transacao 1 continua.");
                            }

                            long y = 0;
                            {// Parte 2
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                System.out.println(String.format("Transacao 1 salva x = %d", x));
                                ResultSet rs2 = st.executeQuery("select valor from tabela where chave = 'y' for update;");
                                if (rs2.next())
                                    y = rs2.getLong("valor");
                                System.out.println(String.format("Transacao 1 le y = %d", y));
                                System.out.println("Transacao 1 entra em espera...");
                                Thread.sleep(2000);
                                System.out.println("Transacao 1 continua.");
                            }

                            {// Parte 3
                                System.out.println(String.format("Transacao 1 faz y = %d + 3", y));
                                y = y + 3;// y=20
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", y, "'y'"));
                                System.out.println(String.format("Transacao 1 salva y = %d", y));
                            }
                            conn.commit();

                            long novox = 0;
                            ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                            if (rs1.next())
                                novox = rs1.getLong("valor");
                            System.out.println(String.format("Transacao 1 le x = %d igual a leitura anterior x = %d", novox, x));
                        } catch (PSQLException e) {
                            conn.rollback();
                        }
                    }
                    System.out.println("Terminou trancacao 1.");
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
                        System.out.println("Comecou transacao 2.");
                        Class.forName("org.postgresql.Driver");
                        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                            conn.setAutoCommit(false);
                            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                            try (Statement st = conn.createStatement();) {

                                long x = 0;
                                {// Parte 1
                                    System.out.println("Transacao 2 entra em espera...");
                                    Thread.sleep(1000);
                                    System.out.println("Transacao 2 continua.");
                                    ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x' for update;");
                                    if (rs1.next())
                                        x = rs1.getLong("valor");
                                    System.out.println(String.format("Transacao 2 le x = %d", x));
                                    System.out.println(String.format("Transacao 2 faz x = %d - 8", x));
                                    x = x - 8;
                                    System.out.println("Transacao 2 entre em espera...");
                                    Thread.sleep(2000);
                                    System.out.println("Transacao 2 continua.");
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
                        System.out.println("Terminou trancacao 2.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (run);
            }
        };
        t.start();
        return t;
    }

    private static void initTabela() {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                conn.setAutoCommit(true);

                try (Statement st = conn.createStatement();) {
                    st.execute("drop table if exists tabela cascade;");
                    st.execute("create table tabela(chave char,valor bigint, primary key(chave));");
                    st.execute("insert into tabela values('x',100);");
                    st.execute("insert into tabela values('y',50);");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
