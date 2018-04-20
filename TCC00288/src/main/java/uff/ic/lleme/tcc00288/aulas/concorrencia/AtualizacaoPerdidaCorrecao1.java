package uff.ic.lleme.tcc00288.aulas.concorrencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AtualizacaoPerdidaCorrecao1 {

    public static void main(String[] args) throws InterruptedException {
        Config.initBD();
        Thread t1 = startTransactionT1();
        Thread t2 = startTransactionT2();
        t1.join();
        t2.join();
    }

    private static Thread startTransactionT1() throws InterruptedException {
        Thread t = new MyThread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        ativarControleTransacaoComBloqueio(conn);

                        try {
                            long x = 0;
                            {// Parte 1
                                x = lerX(conn, "for update");
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
                                y = lerY(conn, "for update");
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

                            long novox = lerXNovamente(conn);
                            System.out.println(String.format("Transacao 1 le x = %d igual a leitura anterior de x = %d <--------", novox, x));

                            conn.commit();
                            System.out.println("Transacao 1 confirma e libera bloqueios.");

                        } catch (Exception e) {
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
        Thread t = new MyThread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        ativarControleTransacaoComBloqueio(conn);

                        try {

                            long x = 0;
                            {// Parte 1
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(1000);
                                x = lerX(conn, "for update");
                                System.out.println(String.format("Transacao 2 le x = %d após liberacao do bloqueio.", x));
                                int N = 8;
                                System.out.println(String.format("Transacao 2 faz x = %d - %d = %d", x, N, x - N));
                                x = x - N;
                                System.out.println("Transacao 2 em processamento...");
                                Thread.sleep(2000);
                            }

                            {// Parte 2
                                escreverX(conn, x);
                                System.out.println(String.format("Transacao 2 salva x = %d", x));
                            }
                            conn.commit();

                        } catch (SQLException e) {
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
}
