package uff.ic.biblioteca.oldmodel.patterns.facade;

import uff.ic.biblioteca.oldmodel.patterns.mediator.EmprestimoMediador;
import uff.ic.biblioteca.oldmodel.patterns.mediator.MaterialMediador;
import uff.ic.biblioteca.oldmodel.patterns.mediator.ReservaMediador;
import uff.ic.biblioteca.oldmodel.patterns.mediator.UsuarioMediador;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

public class Cadastro {

    private UsuarioMediador usuarioMediator = null;
    private ReservaMediador reservaMediator = null;
    private EmprestimoMediador emprestimoMediator = null;
    private MaterialMediador materialMediator = null;

    public Cadastro() {
        super();
        usuarioMediator = new UsuarioMediador();
        reservaMediator = new ReservaMediador();
        emprestimoMediator = new EmprestimoMediador();
        materialMediator = new MaterialMediador();
    }

    public void putUsuario(HttpServletRequest request) {
        usuarioMediator.putUsuario(request);
    }

    public void getUsuario(HttpServletRequest request) {
        usuarioMediator.getUsuario(request, new HashSet());
    }

    public void updUsuario(HttpServletRequest request) {
        usuarioMediator.updUsuario(request);
    }

    public void newUsuario(HttpServletRequest request) {
        usuarioMediator.newUsuario(request);
    }

    public void removeUsuario(HttpServletRequest request) {
        usuarioMediator.removeUsuario(request);
    }

    public void newReserva(HttpServletRequest request) {
        reservaMediator.newReserva(request);
    }

    public void updReserva(HttpServletRequest request) {
        reservaMediator.updReserva(request);
    }

    public void putReserva(HttpServletRequest request) {
        reservaMediator.putReserva(request);
    }

    public void getReserva(HttpServletRequest request) {
        reservaMediator.getReserva(request);
    }

    public void removeReserva(HttpServletRequest request) {
        reservaMediator.removeReserva(request);
    }

    public void newEmprestimo(HttpServletRequest request) {
        emprestimoMediator.newEmprestimo(request);
    }

    public void updEmprestimo(HttpServletRequest request) {
        emprestimoMediator.updEmprestimo(request);
    }

    public void putEmprestimo(HttpServletRequest request) {
        emprestimoMediator.putEmprestimo(request);
    }

    public void getEmprestimo(HttpServletRequest request) {
        emprestimoMediator.getEmprestimo(request);
    }

    public void removeEmprestimo(HttpServletRequest request) {
        emprestimoMediator.removeEmprestimo(request);
    }

    public void putDevolucao(HttpServletRequest request) {
        emprestimoMediator.putDevolucao(request);
    }

    public void getDevolucao(HttpServletRequest request) {
        request.getSession();
        // TO DO
    }

    public void removeDevolucao(HttpServletRequest request) {
        request.getSession();
        // TO DO
    }

    public void getMaterial(HttpServletRequest request) {
        materialMediator.getMaterial(request, new HashSet());
    }
}
