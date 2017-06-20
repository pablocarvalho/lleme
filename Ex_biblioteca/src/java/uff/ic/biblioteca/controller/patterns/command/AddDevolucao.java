package uff.ic.biblioteca.controller.patterns.command;

import uff.ic.biblioteca.oldmodel.patterns.facade.Cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDevolucao extends ServletCommand {

    private Cadastro cadastro = null;

    public AddDevolucao() {
        super();
        cadastro = new Cadastro();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cadastro.putDevolucao(request);
        request.getRequestDispatcher(request.getParameter("page")).forward(
                request, response);
    }
}
