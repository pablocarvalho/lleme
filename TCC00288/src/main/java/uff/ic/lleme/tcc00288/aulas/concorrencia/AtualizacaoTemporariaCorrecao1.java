package uff.ic.lleme.tcc00288.aulas.concorrencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AtualizacaoTemporariaCorrecao1 {

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
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(true);

                        try (Statement st = conn.createStatement();) {
                            long x = 0;
                            {// Parte 1
                                ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
                                if (rs1.next())
                                    x = rs1.getLong("valor");
                                System.out.println(String.format("Transacao 1 le x = %d", x));
                                int N = 5;
                                System.out.println(String.format("Transacao 1 faz x = %d - %d = %d", x, N, x - N));
                                x = x - N;
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                System.out.println(String.format("Transacao 1 salva x = %d", x));
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                            }

                            long y = 0;
                            {// Parte 2
                                ResultSet rs2 = st.executeQuery("select valor from tabela where chave = 'y';");
                                if (rs2.next())
                                    y = rs2.getLong("valor");
                                System.out.println(String.format("Transacao 1 le y = %d", y));
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x + 5, "'x'"));
                                System.out.println(String.format("Transacao 1 falha e desfaz a atualizacao de x = %d", x));
                            }

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

    private static Thread startT2() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(true);

                        try (Statement st = conn.createStatement();) {
                            long x = 0;
                            {// Parte 1
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(1000);
                                ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x' for update;");
                                if (rs1.next())
                                    x = rs1.getLong("valor");
                                System.out.println(String.format("Transacao 2 le x = %d", x));
                                int N = 8;
                                System.out.println(String.format("Transacao 2 faz x = %d - %d = %d", x, N, x - N));
                                x = x - N;
                                st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
                                System.out.println(String.format("Transacao 2 salva x = %d", x));
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(2000);
                                ResultSet rs2 = st.executeQuery("select valor from tabela where chave = 'x';");
                                long novox = 0;
                                if (rs2.next())
                                    novox = rs2.getLong("valor");
                                System.out.println(String.format("Transacao 2 perde o valor x = %d que agora é x = %d", x, novox));
                            }
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

}
