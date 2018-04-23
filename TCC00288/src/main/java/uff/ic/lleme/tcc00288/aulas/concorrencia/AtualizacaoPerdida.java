package uff.ic.lleme.tcc00288.aulas.concorrencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import uff.ic.lleme.tcc00288.aulas.concorrencia.util.Config;
import uff.ic.lleme.tcc00288.aulas.concorrencia.util.Transacao;

public class AtualizacaoPerdida {

    public static void main(String[] args) throws InterruptedException {
        Config.initBD();
        Transacao t1 = iniciarTransacaoT1();
        Transacao t2 = iniciarTransacaoT2();
        t1.join();
        t2.join();
    }

    private static Transacao iniciarTransacaoT1() throws InterruptedException {
        Transacao t = new Transacao(1) {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        this.conn = conn;

                        // -------------------------------------------------------------------------------------------
                        try {

                            long x = 0;
                            {// Parte 1
                                desativarControleTransacao();
                                x = lerX("");
                                int N = 5;
                                x = x - N;
                                System.out.println(String.format("Transacao 1 faz x = %d - %d = %d", x + N, N, x));
                                processar(2000);
                            }

                            long y = 0;
                            {// Parte 2
                                escreverX(x);
                                y = lerY("");
                                processar(2000);
                            }

                            {// Parte 3
                                int N = 3;
                                y = y + N;
                                System.out.println(String.format("Transacao 1 faz y = %d + %d = %d", y - N, N, y));
                                escreverY(y);
                            }

                            {// Parte 4
                                System.out.println("");
                                long novox = lerX("");
                                System.out.println(String.format("Transacao 1 le x = %d em vez de x = %d                         <---", novox, x));
                                System.out.println(String.format("x = %d não será visto por ninguem.                             <---", x));
                                System.out.println(String.format("Transacao 1 nao teve todos os seus efeitos registrados.        <---"));
                                System.out.println(String.format("Transacao 1 poderia ficar inconsistente se usasse x novamente. <---"));
                                System.out.println("Transacao 1 encerra.");
                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        // -------------------------------------------------------------------------------------------

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        t.start();
        return t;
    }

    private static Transacao iniciarTransacaoT2() throws InterruptedException {
        Transacao t = new Transacao(2) {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TCC00288", "postgres", "fluminense");) {
                        this.conn = conn;

                        // -------------------------------------------------------------------------------------------
                        try {

                            long x = 0;
                            {// Parte 1
                                desativarControleTransacao();
                                processar(1000);
                                x = lerX("");
                                int N = 8;
                                x = x - N;
                                System.out.println(String.format("Transacao 2 faz x = %d - %d = %d", x + N, N, x));
                                processar(2000);
                            }

                            {// Parte 2
                                escreverX(x);
                                System.out.println("Transacao 2 encerra.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        // -------------------------------------------------------------------------------------------

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
