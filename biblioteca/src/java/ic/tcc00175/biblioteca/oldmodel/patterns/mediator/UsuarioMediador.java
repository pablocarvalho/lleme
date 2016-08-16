package ic.tcc00175.biblioteca.oldmodel.patterns.mediator;

import ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao;
import ic.tcc00175.biblioteca.oldmodel.Emprestimo;
import ic.tcc00175.biblioteca.oldmodel.Exemplar;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.UsuarioColecao;
import ic.tcc00175.biblioteca.oldmodel.patterns.factory.Factory;

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
            this.lnkErrosCollection.add("Erro: chave já cadastrada.");
        }

        // Inclusão do usuario
        if (lnkErrosCollection.isEmpty()) {
            lnkUsuarioCollection.put(lnkUsuario);
            lnkSistema.save();
            mensagem = "OK! Inclusão realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Inclusão mal sucedida!";
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
            this.lnkErrosCollection.add("Erro: id não cadastrado.");
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
            mensagem = "OK! Remoção realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Remoção mal sucedida!";
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
            this.lnkErrosCollection.add("Erro: id não está cadastrado.");
            this.lnkUsuario = new AlunoGraduacao();
        } else {
            this.lnkUsuario = Factory.createUsuario(request,
                    this.lnkErrosCollection);
            this.lnkUsuario.setLnkEmprestimo(usu.getLnkEmprestimo());
            this.lnkUsuario.setLnkReserva(usu.getLnkReserva());
        }

        // Alteração do usuario
        if (lnkErrosCollection.isEmpty()) {
            lnkUsuarioCollection.put(lnkUsuario);
            lnkSistema.save();
            mensagem = "OK! Atualização realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Atualização mal sucedida!";
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
                mensagem = "Recuperação mal sucedida!";
                mensagem += "\nErro: id não está cadastrado.";
            }
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Recuperação mal sucedida!";
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
