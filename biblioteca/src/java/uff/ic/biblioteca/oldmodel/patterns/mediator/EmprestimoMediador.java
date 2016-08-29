package uff.ic.biblioteca.oldmodel.patterns.mediator;

import uff.ic.biblioteca.oldmodel.Emprestimo;
import uff.ic.biblioteca.oldmodel.Exemplar;
import uff.ic.biblioteca.oldmodel.Livro;
import uff.ic.biblioteca.oldmodel.Material;
import uff.ic.biblioteca.oldmodel.Sistema;
import uff.ic.biblioteca.oldmodel.Usuario;
import uff.ic.biblioteca.oldmodel.patterns.factory.Factory;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class EmprestimoMediador {

    @SuppressWarnings({"unchecked", "unchecked", "unchecked", "unchecked",
        "unchecked", "unchecked", "unchecked", "unchecked", "unchecked"})
    public void putEmprestimo(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        this.lnkUsuarioMediator = new UsuarioMediador();
        this.lnkExemplarMediator = new ExemplarMediador();
        this.lnkMaterialMediator = new MaterialMediador();
        String mensagem = null;

        // Cria Emprestimo
        this.lnkEmprestimo = Factory.createEmprestimo(request,
                this.lnkErrosCollection);

        // Recupera usuario
        this.lnkUsuario = this.lnkUsuarioMediator.getUsuario(request,
                lnkErrosCollection);
        if (lnkUsuario == null) {
            this.lnkErrosCollection.add("Erro: usuario n�o cadastrado.");
        } else {
            this.lnkEmprestimo.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera exemplar
        this.lnkExemplar = this.lnkExemplarMediator.getExemplar(request,
                lnkErrosCollection);
        if (lnkExemplar == null) {
            lnkErrosCollection.add("Erro: exemplar n�o cadastrado.");
        } else if (this.lnkExemplar.getLnkEmprestimo() != null) {
            lnkErrosCollection.add("Erro: exemplar j� emprestado.");
        } else {
            this.lnkEmprestimo.setLnkrevExemplar(lnkExemplar);
        }

        // Recupera material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material n�o cadastrado.");
        }

        // Verifica se h� outro emprestimo para o mesmo material
        if (lnkMaterial != null) {
            if (lnkUsuario.getLnkEmprestimo().containsEmprestado(lnkMaterial)) {
                lnkErrosCollection.add("Erro: outro exemplar do mesmo material j� est� emprestado para o usuario.");
            }
        }

        // Verifica se h� emprestimo atrasado
        if (lnkUsuario.getLnkEmprestimo().containsAtraso()) {
            lnkErrosCollection.add("Erro: h� um emprestimo atrasado para o usuario.");
        }

        // Verifica se o limite de emprestimos foi atingido
        if (lnkUsuario.atingiuLimiteEmprestimo()) {
            lnkErrosCollection.add("Erro: usuario atingiu o n�mero m�ximo de emprestimos permitido.");
        }

        // ------------------------------------------------------------------
        // Verifica prioridade das reservas
        if (lnkMaterial != null) {
            try {
                if (Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                    Livro livro = (Livro) lnkMaterial;
                    if (livro.getLnkExemplar().sizeDisponiveis() <= livro.getLnkReserva().size()
                            && !lnkUsuario.getLnkReserva().containsMaterial(
                            lnkMaterial)) {
                        lnkErrosCollection.add("Erro: n�mero exemplares dispon�veis menor do que o n�mero de reservas.");
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // ----------------------------------------------------------------

        // Verifica chave duplicada
        if (lnkErrosCollection.isEmpty()) {
            if (this.lnkUsuario.getLnkEmprestimo().get(lnkEmprestimo.getKey()) != null) {
                this.lnkErrosCollection.add("Erro: chave j� cadastrada.");
            }
        }

        // Inclus�o da emprestimo
        if (lnkErrosCollection.isEmpty()) {
            this.lnkUsuario.getLnkReserva().remove(this.lnkMaterial);
            try {
                if (Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                    ((Livro) this.lnkMaterial).getLnkReserva().remove(
                            this.lnkUsuario);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.lnkUsuario.getLnkEmprestimo().put(this.lnkEmprestimo);
            this.lnkExemplar.setLnkEmprestimo(this.lnkEmprestimo);
            this.lnkSistema.save();
            mensagem = "OK! Inclus�o realizada com sucesso.";
        } else {
            Iterator iter = this.lnkErrosCollection.iterator();
            mensagem = "Inclus�o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("usuario", this.lnkUsuario);
        request.getSession().setAttribute("exemplar", this.lnkExemplar);
        request.getSession().setAttribute("material", this.lnkMaterial);
        request.getSession().setAttribute("emprestimo", this.lnkEmprestimo);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    @SuppressWarnings({"unchecked", "unchecked", "unchecked"})
    public void removeEmprestimo(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        this.lnkUsuarioMediator = new UsuarioMediador();
        this.lnkExemplarMediator = new ExemplarMediador();
        String mensagem = null;

        // Cria Emprestimo
        this.lnkEmprestimo = Factory.createEmprestimo(request,
                this.lnkErrosCollection);

        // Recupera Usuario
        this.lnkUsuario = this.lnkUsuarioMediator.getUsuario(request,
                lnkErrosCollection);
        if (lnkUsuario == null) {
            lnkErrosCollection.add("Erro: usuario n�o cadastrado.");
        } else {
            this.lnkEmprestimo.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera exemplar
        this.lnkExemplar = this.lnkExemplarMediator.getExemplar(request,
                lnkErrosCollection);
        if (lnkExemplar == null) {
            lnkErrosCollection.add("Erro: exemplar n�o cadastrado.");
        } else {
            this.lnkEmprestimo.setLnkrevExemplar(lnkExemplar);
        }

        // Verifica chave n�o cadastrada
        if (lnkErrosCollection.isEmpty()) {
            if (this.lnkUsuario.getLnkEmprestimo().get(lnkEmprestimo.getKey()) == null) {
                this.lnkErrosCollection.add("Erro: emprestimo inexistente.");
            }
        }

        if (lnkErrosCollection.isEmpty()) {
            this.lnkUsuario.getLnkEmprestimo().remove(
                    this.lnkEmprestimo.getKey());
            this.lnkExemplar.setLnkEmprestimo(null);
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
        request.getSession().setAttribute("exemplar", this.lnkExemplar);
        request.getSession().setAttribute("emprestimo", this.lnkEmprestimo);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    public void updEmprestimo(HttpServletRequest request) {
        request.getSession();
        // TO DO
    }

    public void newEmprestimo(HttpServletRequest request) {
        this.lnkEmprestimo = new Emprestimo();
        request.getSession().setAttribute("usuario", null);
        request.getSession().setAttribute("exemplar", null);
        request.getSession().setAttribute("material", null);
        request.getSession().setAttribute("emprestimo", this.lnkEmprestimo);
        request.getSession().setAttribute("mensagem", null);
    }

    public void getEmprestimo(HttpServletRequest request) {
        request.getSession();
        // TO DO
    }

    @SuppressWarnings({"unchecked", "unchecked", "unchecked"})
    public void putDevolucao(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        this.lnkUsuarioMediator = new UsuarioMediador();
        this.lnkMaterialMediator = new MaterialMediador();
        this.lnkExemplarMediator = new ExemplarMediador();

        String mensagem = null;

        // Recupera usuario
        this.lnkUsuario = this.lnkUsuarioMediator.getUsuario(request,
                lnkErrosCollection);
        if (lnkUsuario == null) {
            this.lnkErrosCollection.add("Erro: usuario n�o cadastrado.");
        }

        // Recupera Material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material n�o cadastrado.");
        }

        // Verifica se material est� emprestado
        if (!this.lnkUsuario.getLnkEmprestimo().isEmprestado(lnkMaterial)) {
            this.lnkErrosCollection.add("Erro: material n�o est� emprestado.");
        }

        // Devolu��o
        if (lnkErrosCollection.isEmpty()) {
            this.lnkUsuario.getLnkEmprestimo().setDevolucao(lnkMaterial);
            this.lnkSistema.save();
            mensagem = "OK! Devolu��o realizada com sucesso.";
        } else {
            Iterator iter = this.lnkErrosCollection.iterator();
            mensagem = "Devolu��o mal sucedida!";
            while (iter.hasNext()) {
                mensagem = mensagem.concat("\n" + (String) iter.next());
            }
        }
        request.getSession().setAttribute("usuario", this.lnkUsuario);
        request.getSession().setAttribute("material", this.lnkMaterial);
        request.getSession().setAttribute("mensagem", mensagem);
    }
    private HashSet lnkErrosCollection = null;
    private Usuario lnkUsuario;
    private Exemplar lnkExemplar;
    private Material lnkMaterial;
    private Emprestimo lnkEmprestimo;
    private Sistema lnkSistema;
    private ExemplarMediador lnkExemplarMediator;
    private MaterialMediador lnkMaterialMediator;
    private UsuarioMediador lnkUsuarioMediator;
}
