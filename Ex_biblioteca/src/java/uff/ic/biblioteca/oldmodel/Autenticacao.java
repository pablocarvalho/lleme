package uff.ic.biblioteca.oldmodel;

public class Autenticacao {

    /**
     * @link dependency
     */
    /* #Sistema lnkSistema; */
    private Sistema lnkSistema = null;
    private String id = null;
    private String senha = null;

    public Autenticacao(String id, String senha) {
        lnkSistema = Sistema.getInstance();
        this.id = id;
        this.senha = senha;
    }

    public Autenticacao() {
        super();
        lnkSistema = Sistema.getInstance();
    }

    public String getId() {
        if (isValid()) {
            Login lnkLogin = null;
            lnkLogin = (Login) lnkSistema.getLnkLogin().get(id);
            if (lnkLogin != null) {
                return lnkLogin.getId();
            }
        }
        return null;
    }

    public String getNome() {
        if (isValid()) {
            Login lnkLogin = null;
            lnkLogin = (Login) lnkSistema.getLnkLogin().get(id);
            if (lnkLogin != null) {
                return lnkLogin.getNome();
            }
        }
        return null;
    }

    public boolean isLoginExpirado() {
        if (isValid()) {

            Login lnkLogin = null;
            lnkLogin = (Login) lnkSistema.getLnkLogin().get(id);
            if (lnkLogin != null) {
                return lnkLogin.isExpirado();
            }
        }
        return false;
    }

    public boolean isValid() {
        Login lnkLogin = null;
        lnkLogin = (Login) lnkSistema.getLnkLogin().get(id);
        if (lnkLogin != null && lnkLogin.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
}
