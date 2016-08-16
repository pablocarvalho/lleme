package ic.tcc00175.biblioteca.oldmodel;

import java.sql.Date;
import java.util.Calendar;

public class Login extends BusinessObject {

    private static final long serialVersionUID = 1694040097376754399L;
    private String id = null;
    private String nome = null;
    private String senha = null;
    private Date expiracao = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(Date expiracao) {
        this.expiracao = expiracao;
    }

    public boolean isExpirado() {
        if (expiracao != null) {
            if (expiracao.compareTo(Calendar.getInstance().getTime()) >= 0) {
                return false;
            }
            return true;
        }
        return false;
    }
}
