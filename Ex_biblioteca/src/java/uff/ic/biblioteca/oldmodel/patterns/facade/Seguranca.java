package uff.ic.biblioteca.oldmodel.patterns.facade;

import uff.ic.biblioteca.oldmodel.patterns.mediator.LoginMediador;

import javax.servlet.http.HttpServletRequest;

public class Seguranca {

    private LoginMediador mediador = null;

    public Seguranca() {
        super();
        mediador = new LoginMediador();
    }

    public void doLogin(HttpServletRequest request) {
        mediador.doLogin(request);
    }

    public void doLogout(HttpServletRequest request) {
        mediador.doLogout(request);
    }
}
