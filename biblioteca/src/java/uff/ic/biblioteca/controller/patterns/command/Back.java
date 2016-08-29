package uff.ic.biblioteca.controller.patterns.command;

import uff.ic.biblioteca.view.Tabela;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Back extends ServletCommand {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tabela tabela = (Tabela) request.getSession().getAttribute("tabela");
        if (tabela != null) {
            tabela.back();
        }
        request.getRequestDispatcher(request.getParameter("page")).forward(
                request, response);
    }

    public void execute() {
        // TODO Auto-generated method stub
    }
}