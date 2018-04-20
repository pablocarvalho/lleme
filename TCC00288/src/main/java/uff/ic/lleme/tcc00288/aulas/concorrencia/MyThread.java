package uff.ic.lleme.tcc00288.aulas.concorrencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MyThread extends Thread {

    protected void desativarControleTransacao(final Connection conn) throws SQLException {
        conn.setAutoCommit(true);
    }

    protected void ativarControleTransacaoComBloqueio(final Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
    }

    protected void ativarControleTransacaoComIsolamento(final Connection conn) throws SQLException {
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
    }

    protected long lerX(final Connection conn, String bloqueio) throws SQLException {
        try (Statement st = conn.createStatement();) {
            long x = 0;
            ResultSet rs1 = st.executeQuery(String.format("select valor from tabela where chave = 'x' %s;", bloqueio));
            if (rs1.next())
                x = rs1.getLong("valor");
            return x;
        }
    }

    protected long lerY(final Connection conn, String bloqueio) throws SQLException {
        try (Statement st = conn.createStatement();) {
            long y = 0;
            ResultSet rs2 = st.executeQuery(String.format("select valor from tabela where chave = 'y' %s;", bloqueio));
            if (rs2.next())
                y = rs2.getLong("valor");
            return y;
        }
    }

    protected void desfazX(final Connection conn, long x) throws SQLException {
        try (Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
        }
    }

    protected long lerXNovamente(final Connection conn) throws SQLException {
        try (Statement st = conn.createStatement();) {
            long novox = 0;
            ResultSet rs1 = st.executeQuery("select valor from tabela where chave = 'x';");
            if (rs1.next())
                novox = rs1.getLong("valor");
            return novox;
        }
    }

    protected void escreverX(final Connection conn, long x) throws SQLException {
        try (Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", x, "'x'"));
        }
    }

    protected void escreverY(final Connection conn, long y) throws SQLException {
        try (Statement st = conn.createStatement();) {
            st.executeUpdate(String.format("update tabela set valor=%d where chave = %s;", y, "'y'"));
        }
    }
}
