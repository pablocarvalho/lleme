package uff.ic.biblioteca.controller.patterns.command;

import uff.ic.biblioteca.oldmodel.Autenticacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPage extends ServletCommand {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Autenticacao autenticacao = (Autenticacao) request.getSession().getAttribute("autenticacao");
        //
        // ************************************************
        // Retirar Retirar Retirar Retirar Retirar Retirar
        // autenticacao = new Autenticacao("admin", "admin");
        // ************************************************
        //
        if (autenticacao == null || !autenticacao.isValid()) {
            request.getRequestDispatcher("../jsp/login.jsp").forward(request,
                    response);
        } else {
            request.getSession().setAttribute("mensagem", null);
            request.getRequestDispatcher(request.getParameter("page")).forward(
                    request, response);
        }
    }

    public void execute() {
        // TODO Auto-generated method stub
    }
}
