package ic.tcc00175.biblioteca.oldmodel.patterns.mediator;

import ic.tcc00175.biblioteca.oldmodel.Autenticacao;

import javax.servlet.http.HttpServletRequest;

public class LoginMediador {

    private Autenticacao lnkAutenticacao = null;

    public void doLogin(HttpServletRequest request) {
        String mensagem = null;
        this.lnkAutenticacao = new Autenticacao(request.getParameter("login_username"), request.getParameter("secretkey"));
        if (this.lnkAutenticacao.isValid()) {
            mensagem = "Login OK.\nAcesso ao sistema Liberado.";
        } else if (this.lnkAutenticacao.isLoginExpirado()) {
            mensagem = "Login expirado.\nAcesso ao sistema bloqueado.";
        } else {
            mensagem = "Login inválido.\nAcesso ao sistema bloqueado.";
        }
        request.getSession().setAttribute("autenticacao", this.lnkAutenticacao);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    public void doLogout(HttpServletRequest request) {
        String mensagem = null;
        mensagem = "Logout OK.\nAcesso ao sistema bloqueado.";
        this.lnkAutenticacao = new Autenticacao();
        request.getSession().setAttribute("autenticacao", this.lnkAutenticacao);
        request.getSession().setAttribute("mensagem", mensagem);
    }
}
