package uff.ic.biblioteca.controller;

import uff.ic.biblioteca.controller.patterns.command.AddDevolucao;
import uff.ic.biblioteca.controller.patterns.command.AddEmprestimo;
import uff.ic.biblioteca.controller.patterns.command.AddReserva;
import uff.ic.biblioteca.controller.patterns.command.AddUsuario;
import uff.ic.biblioteca.controller.patterns.command.Back;
import uff.ic.biblioteca.controller.patterns.command.Begin;
import uff.ic.biblioteca.controller.patterns.command.DoLogin;
import uff.ic.biblioteca.controller.patterns.command.DoLogout;
import uff.ic.biblioteca.controller.patterns.command.End;
import uff.ic.biblioteca.controller.patterns.command.GetEmprestimo;
import uff.ic.biblioteca.controller.patterns.command.GetReserva;
import uff.ic.biblioteca.controller.patterns.command.GetUsuario;
import uff.ic.biblioteca.controller.patterns.command.NewEmprestimo;
import uff.ic.biblioteca.controller.patterns.command.NewUsuario;
import uff.ic.biblioteca.controller.patterns.command.Next;
import uff.ic.biblioteca.controller.patterns.command.RemoveEmprestimo;
import uff.ic.biblioteca.controller.patterns.command.RemoveReserva;
import uff.ic.biblioteca.controller.patterns.command.RemoveUsuario;
import uff.ic.biblioteca.controller.patterns.command.SelMaterial;
import uff.ic.biblioteca.controller.patterns.command.SelUsuario;
import uff.ic.biblioteca.controller.patterns.command.ServletCommand;
import uff.ic.biblioteca.controller.patterns.command.ShowPage;
import uff.ic.biblioteca.controller.patterns.command.UpdEmprestimo;
import uff.ic.biblioteca.controller.patterns.command.UpdReserva;
import uff.ic.biblioteca.controller.patterns.command.UpdUsuario;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemController extends javax.servlet.http.HttpServlet implements
        javax.servlet.Servlet {

    private static final long serialVersionUID = -3607555740681227648L;
    private HashMap<String, ServletCommand> lnkCommand = null;

    public SystemController() {
        super();
        lnkCommand = new HashMap();
        // P�ginas
        lnkCommand.put("ShowPage", new ShowPage());
        // Opera��es
        lnkCommand.put("DoLogin", new DoLogin());
        lnkCommand.put("DoLogout", new DoLogout());
        lnkCommand.put("AddUsuario", new AddUsuario());
        lnkCommand.put("GetUsuario", new GetUsuario());
        lnkCommand.put("UpdUsuario", new UpdUsuario());
        lnkCommand.put("RemUsuario", new RemoveUsuario());
        lnkCommand.put("NewUsuario", new NewUsuario());
        lnkCommand.put("SelUsuario", new SelUsuario());
        lnkCommand.put("AddReserva", new AddReserva());
        lnkCommand.put("GetReserva", new GetReserva());
        lnkCommand.put("UpdReserva", new UpdReserva());
        lnkCommand.put("RemReserva", new RemoveReserva());
        lnkCommand.put("NewReserva", new NewEmprestimo());
        lnkCommand.put("AddEmprestimo", new AddEmprestimo());
        lnkCommand.put("GetEmprestimo", new GetEmprestimo());
        lnkCommand.put("UpdEmprestimo", new UpdEmprestimo());
        lnkCommand.put("RemEmprestimo", new RemoveEmprestimo());
        lnkCommand.put("NewEmprestimo", new NewEmprestimo());
        lnkCommand.put("SelMaterial", new SelMaterial());
        lnkCommand.put("AddDevolucao", new AddDevolucao());
        lnkCommand.put("Next", new Next());
        lnkCommand.put("Back", new Back());
        lnkCommand.put("Begin", new Begin());
        lnkCommand.put("End", new End());
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        lnkCommand.get("ShowPage").execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        lnkCommand.get(request.getParameter("command")).execute(request, response);
    }
}
