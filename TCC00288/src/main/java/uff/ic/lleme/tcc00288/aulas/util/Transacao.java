package uff.ic.lleme.tcc00288.aulas.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Transacao extends Thread {

    protected int numero = 0;
    protected Connection conn = null;

    protected Transacao(int numero) {
        this.numero = numero;
    }

    protected void desativarControleTransacao() throws SQLException {
        conn.setAutoCommit(true);
    }

    protected void iniciarTransacaoComBloqueio() throws SQLException {
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
    }

    protected void iniciarTransacaoComIsolamento() throws SQLException {
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
    }

    protected long lerX(String bloqueio) throws SQLException {
        try (Statement st = conn.createStatement();) {
            long x = 0;
            ResultSet rs1 = st.executeQuery(String.format("select valor from tabela where chave = 'x' %s;", bloqueio));
            if (rs1.next())
                x = rs1.getLong("valor");
            System.out.println(String.format("Transacao %d le x = %d", numero, x));
            return x;
        }
    }

    protected long lerY(String bloqueio) throws SQLException {
        try (Statement st = conn.createStatement();) {
            long y = 0;
            ResultSet rs2 = st.executeQuery(String.format("select valor from tabela where chave = 'y' %s;", bloqueio));
            if (rs2.next())
                y = rs2.getLong("valor");
            System.out.println(String.format("Transacao %d le y = %d", numero, y));
            return y;
        }
    }

    protected void desfazX(long x) throws SQLException {
        try (Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
            System.out.println(String.format("Transacao %d falha e desfaz a atualizacao de x = %d  ***", numero, x));
        }
    }

    protected long lerXNovamente() throws SQLException {
        try (Statement st = conn.createStatement();) {
            long novox = 0;
            ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
            if (rs1.next())
                novox = rs1.getLong("valor");
            return novox;
        }
    }

    protected void escreverX(long x) throws SQLException {
        try (Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
            System.out.println(String.format("Transacao %d salva x = %d", numero, x));
        }
    }

    protected void escreverY(long y) throws SQLException {
        try (Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", y, "'y'"));
            System.out.println(String.format("Transacao %d salva y = %d", numero, y));
        }
    }

    protected void processar(long t) throws InterruptedException {
        System.out.println(String.format("Transacao %d em processamento...", numero));
        Thread.sleep(t);
    }
}
