package ic.tcc00175.biblioteca.controller.patterns.command;

import ic.tcc00175.biblioteca.oldmodel.patterns.facade.Seguranca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends ServletCommand {

    private Seguranca seguranca = null;

    public DoLogin() {
        super();
        seguranca = new Seguranca();
    }

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        seguranca.doLogin(request);
        request.getRequestDispatcher("../jsp/login.jsp").forward(request,
                response);
    }

    public void execute() {
        // TODO Auto-generated method stub
    }
}
