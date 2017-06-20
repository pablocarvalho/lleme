package uff.ic.biblioteca.oldmodel.patterns.mediator;

import uff.ic.biblioteca.oldmodel.Livro;
import uff.ic.biblioteca.oldmodel.Material;
import uff.ic.biblioteca.oldmodel.Reserva;
import uff.ic.biblioteca.oldmodel.Sistema;
import uff.ic.biblioteca.oldmodel.Usuario;
import uff.ic.biblioteca.oldmodel.patterns.factory.Factory;

import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

public class ReservaMediador {

    @SuppressWarnings({"unchecked", "unchecked", "unchecked", "unchecked",
        "unchecked", "unchecked"})
    public void putReserva(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        this.lnkUsuarioMediator = new UsuarioMediador();
        this.lnkMaterialMediator = new MaterialMediador();
        String mensagem = null;

        // Cria Reserva
        this.lnkReserva = Factory.createReserva(request,
                this.lnkErrosCollection);

        // Recupera Usuario
        this.lnkUsuario = this.lnkUsuarioMediator.getUsuario(request,
                lnkErrosCollection);
        if (lnkUsuario == null) {
            lnkErrosCollection.add("Erro: usuario n�o cadastrado.");
        } else if (lnkUsuario.atingiuLimiteReserva()) {
            lnkErrosCollection.add("Erro: o limite de reservas s�o tr�s livros.");
        } else {
            this.lnkReserva.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera Material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material n�o cadastrado.");
        } else {
            try {
                if (!Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                    lnkErrosCollection.add("Erro: s� � permitido reservar livros.");
                } else if (lnkUsuario != null
                        && lnkUsuario.getLnkReserva().containsMaterial(
                        lnkMaterial)) {
                    lnkErrosCollection.add("Erro: n�o � permitido reservar o mesmo livro mais de uma vez.");
                } else {
                    this.lnkReserva.setLnkrevLivro((Livro) lnkMaterial);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Verifica chave duplicada
        if (lnkErrosCollection.isEmpty()) {
            if (((Livro) lnkMaterial).getLnkReserva().get(lnkReserva.getKey()) != null) {
                this.lnkErrosCollection.add("Erro: chave j� cadastrada.");
            }
        }

        // Inclus�o da reserva
        if (lnkErrosCollection.isEmpty()) {
            lnkUsuario.getLnkReserva().put(this.lnkReserva);
            ((Livro) lnkMaterial).getLnkReserva().put(this.lnkReserva);
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
        request.getSession().setAttribute("material", this.lnkMaterial);
        request.getSession().setAttribute("reserva", this.lnkReserva);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    @SuppressWarnings({"unchecked", "unchecked", "unchecked", "unchecked"})
    public void removeReserva(HttpServletRequest request) {
        this.lnkSistema = Sistema.getInstance();
        this.lnkErrosCollection = new HashSet();
        this.lnkUsuarioMediator = new UsuarioMediador();
        this.lnkMaterialMediator = new MaterialMediador();
        String mensagem = null;

        // Cria Reserva
        this.lnkReserva = Factory.createReserva(request,
                this.lnkErrosCollection);

        // Recupera Usuario
        this.lnkUsuario = this.lnkUsuarioMediator.getUsuario(request,
                lnkErrosCollection);
        if (lnkUsuario == null) {
            lnkErrosCollection.add("Erro: usuario n�o cadastrado.");
        } else {
            this.lnkReserva.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera Material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material n�o cadastrado.");
        } else {
            try {
                if (!Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                    lnkErrosCollection.add("Erro: s� � permitido reservar livros.");
                } else {
                    this.lnkReserva.setLnkrevLivro((Livro) lnkMaterial);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Verifica chave n�o existente
        if (lnkErrosCollection.isEmpty()) {
            if (((Livro) lnkMaterial).getLnkReserva().get(lnkReserva.getKey()) == null) {
                this.lnkErrosCollection.add("Erro: chave n�o est� cadastrada.");
            }
        }

        if (lnkErrosCollection.isEmpty()) {
            this.lnkUsuario.getLnkReserva().remove(lnkReserva.getKey());
            ((Livro) this.lnkMaterial).getLnkReserva().remove(
                    lnkReserva.getKey());
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
        request.getSession().setAttribute("material", this.lnkMaterial);
        request.getSession().setAttribute("reserva", this.lnkReserva);
        request.getSession().setAttribute("mensagem", mensagem);
    }

    public void updReserva(HttpServletRequest request) {
        request.getSession();
        // TO DO
    }

    public void newReserva(HttpServletRequest request) {
        this.lnkReserva = new Reserva();
        request.getSession().setAttribute("usuario", null);
        request.getSession().setAttribute("material", null);
        request.getSession().setAttribute("reserva", this.lnkReserva);
        request.getSession().setAttribute("mensagem", null);
    }

    public void getReserva(HttpServletRequest request) {
        request.getSession();
        // TO DO
    }
    private HashSet lnkErrosCollection = null;
    private Usuario lnkUsuario;
    private Material lnkMaterial;
    private Reserva lnkReserva;
    private Sistema lnkSistema;
    private MaterialMediador lnkMaterialMediator;
    private UsuarioMediador lnkUsuarioMediator;
}
