package uff.ic.biblioteca.oldmodel.patterns.mediator;

import uff.ic.biblioteca.oldmodel.AlunoGraduacao;
import uff.ic.biblioteca.oldmodel.Emprestimo;
import uff.ic.biblioteca.oldmodel.Exemplar;
import uff.ic.biblioteca.oldmodel.Sistema;
import uff.ic.biblioteca.oldmodel.Usuario;
import uff.ic.biblioteca.oldmodel.patterns.adapter.UsuarioColecao;
import uff.ic.biblioteca.oldmodel.patterns.factory.Factory;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class UsuarioMediador {

    public void putUsuario(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        String mensagem = null;
        this.lnkUsuarioCollection = this.lnkSistema.getLnkUsuario();
        this.lnkUsuario = Factory.createUsuario(request,
                this.lnkErrosCollection);
        if (lnkUsuarioCollection.get(lnkUsuario.getKey()) != null) {
            this.lnkErrosCollection.add("Erro: chave j� cadastrada.");
        }

        // Inclus�o do usuario
        if (lnkErrosCollection.isEmpty()) {
            lnkUsuarioCollection.put(lnkUsuario);
            lnkSistema.save();
            mensagem = "OK! Inclus�o realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Inclus�o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("usuario", this.lnkUsuario);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    public void removeUsuario(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        String mensagem = null;
        this.lnkUsuarioCollection = this.lnkSistema.getLnkUsuario();
        this.lnkUsuario = lnkUsuarioCollection.get(Factory.createKeyUsuario(
                request, this.lnkErrosCollection));
        if (lnkUsuario == null) {
            this.lnkErrosCollection.add("Erro: id n�o cadastrado.");
        }

        if (lnkErrosCollection.isEmpty()) {
            for (int i = 0; i < this.lnkUsuario.getLnkReserva().size(); i++) {
                this.lnkUsuario.getLnkReserva().get(i).getLnkrevLivro().getLnkReserva().remove(this.lnkUsuario);
            }
            for (int i = 0; i < this.lnkUsuario.getLnkEmprestimo().size(); i++) {
                lnkEmprestimo = this.lnkUsuario.getLnkEmprestimo().get(i);
                lnkExemplar = this.lnkUsuario.getLnkEmprestimo().get(i).getLnkrevExemplar();
                if (lnkExemplar.getLnkEmprestimo().getKey().compareTo(
                        lnkEmprestimo.getKey()) == 0) {
                    lnkExemplar.setLnkEmprestimo(null);
                }
            }
            this.lnkUsuario = lnkUsuarioCollection.remove(this.lnkUsuario.getKey());
            lnkSistema.save();
            mensagem = "OK! Remo��o realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Remo��o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("usuario", this.lnkUsuario);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    public void updUsuario(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        String mensagem = null;
        this.lnkUsuarioCollection = lnkSistema.getLnkUsuario();
        Usuario usu = lnkUsuarioCollection.get(Factory.createKeyUsuario(
                request, this.lnkErrosCollection));
        if (usu == null) {
            this.lnkErrosCollection.add("Erro: id n�o est� cadastrado.");
            this.lnkUsuario = new AlunoGraduacao();
        } else {
            this.lnkUsuario = Factory.createUsuario(request,
                    this.lnkErrosCollection);
            this.lnkUsuario.setLnkEmprestimo(usu.getLnkEmprestimo());
            this.lnkUsuario.setLnkReserva(usu.getLnkReserva());
        }

        // Altera��o do usuario
        if (lnkErrosCollection.isEmpty()) {
            lnkUsuarioCollection.put(lnkUsuario);
            lnkSistema.save();
            mensagem = "OK! Atualiza��o realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Atualiza��o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("usuario", this.lnkUsuario);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    public void newUsuario(HttpServletRequest request) {
        this.lnkUsuario = new AlunoGraduacao();
        request.getSession().setAttribute("usuario", lnkUsuario);
        request.getSession().setAttribute("mensagem", null);
    }

    public Usuario getUsuario(HttpServletRequest request,
            HashSet lnkErrosCollection) {
        this.lnkSistema = Sistema.getInstance();
        String mensagem = null;
        this.lnkUsuarioCollection = lnkSistema.getLnkUsuario();
        this.lnkUsuario = lnkUsuarioCollection.get(Factory.createKeyUsuario(
                request, this.lnkErrosCollection));
        if (lnkErrosCollection.isEmpty()) {
            if (lnkUsuario == null) {
                mensagem = "Recupera��o mal sucedida!";
                mensagem += "\nErro: id n�o est� cadastrado.";
            }
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Recupera��o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("usuario", lnkUsuario);
        request.getSession().setAttribute("mensagem", mensagem);
        return lnkUsuario;
    }
    private UsuarioColecao lnkUsuarioCollection = null;
    private HashSet lnkErrosCollection = null;
    private Usuario lnkUsuario;
    private Sistema lnkSistema;
    private Emprestimo lnkEmprestimo;
    private Exemplar lnkExemplar;
}
