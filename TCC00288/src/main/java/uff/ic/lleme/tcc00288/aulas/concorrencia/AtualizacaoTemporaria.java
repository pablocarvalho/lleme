package uff.ic.lleme.tcc00288.aulas.concorrencia;

import uff.ic.lleme.tcc00288.aulas.util.MyThread;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AtualizacaoTemporaria {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = startT1();
        Thread t2 = startT2();
        t1.join();
        t2.join();
    }

    private static Thread startT1() throws InterruptedException {
        Thread t = new MyThread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {

                        try {
                            conn.setAutoCommit(true);

                            long x = 0;
                            {// Parte 1
                                x = lerX(conn, "for update");
                                System.out.println(String.format("Transacao 1 le x = %d", x));
                                int N = 5;
                                System.out.println(String.format("Transacao 1 faz x = %d - %d = %d", x, N, x - N));
                                x = x - N;
                                escreverX(conn, x);
                                System.out.println(String.format("Transacao 1 salva x = %d", x));
                                System.out.println("Transacao 1 em processamento...");
                                Thread.sleep(2000);
                            }

                            long y = 0;
                            {// Parte 2
                                y = lerY(conn, "for update");
                                System.out.println(String.format("Transacao 1 le y = %d", y));
                                desfazX(conn, x + 5);
                                System.out.println(String.format("Transacao 1 falha e desfaz a atualizacao de x = %d  ***", x));
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
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
        Thread t = new MyThread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        conn.setAutoCommit(true);

                        try {
                            long x = 0;
                            {// Parte 1
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(1000);
                                x = lerX(conn, "for update");
                                System.out.println(String.format("Transacao 2 le x = %d", x));
                                int N = 8;
                                System.out.println(String.format("Transacao 2 faz x = %d - %d = %d", x, N, x - N));
                                x = x - N;
                                escreverX(conn, x);
                                System.out.println(String.format("Transacao 2 salva x = %d", x));
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(2000);
                                long novox = lerXNovamente(conn);
                                System.out.println(String.format("Transacao 2 perde o valor x = %d que agora é x = %d <--------", x, novox));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
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
