package uff.ic.biblioteca.controller.patterns.command;

import uff.ic.biblioteca.oldmodel.patterns.facade.Cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReserva extends ServletCommand {

    private Cadastro cadastro = null;

    public AddReserva() {
        super();
        cadastro = new Cadastro();
    }

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cadastro.putReserva(request);
        request.getRequestDispatcher(request.getParameter("page")).forward(
                request, response);
    }

    public void execute() {
        // TODO Auto-generated method stub
    }
}
