package ic.tcc00175.biblioteca.oldmodel.patterns.mediator;

import ic.tcc00175.biblioteca.oldmodel.Livro;
import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Reserva;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.factory.Factory;

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
            lnkErrosCollection.add("Erro: usuario não cadastrado.");
        } else if (lnkUsuario.atingiuLimiteReserva()) {
            lnkErrosCollection.add("Erro: o limite de reservas são três livros.");
        } else {
            this.lnkReserva.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera Material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material não cadastrado.");
        } else {
            try {
                if (!Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                    lnkErrosCollection.add("Erro: só é permitido reservar livros.");
                } else if (lnkUsuario != null
                        && lnkUsuario.getLnkReserva().containsMaterial(
                        lnkMaterial)) {
                    lnkErrosCollection.add("Erro: não é permitido reservar o mesmo livro mais de uma vez.");
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
                this.lnkErrosCollection.add("Erro: chave já cadastrada.");
            }
        }

        // Inclusão da reserva
        if (lnkErrosCollection.isEmpty()) {
            lnkUsuario.getLnkReserva().put(this.lnkReserva);
            ((Livro) lnkMaterial).getLnkReserva().put(this.lnkReserva);
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
            lnkErrosCollection.add("Erro: usuario não cadastrado.");
        } else {
            this.lnkReserva.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera Material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material não cadastrado.");
        } else {
            try {
                if (!Class.forName("ic.tcc00175.biblioteca.model.Livro").isInstance(lnkMaterial)) {
                    lnkErrosCollection.add("Erro: só é permitido reservar livros.");
                } else {
                    this.lnkReserva.setLnkrevLivro((Livro) lnkMaterial);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Verifica chave não existente
        if (lnkErrosCollection.isEmpty()) {
            if (((Livro) lnkMaterial).getLnkReserva().get(lnkReserva.getKey()) == null) {
                this.lnkErrosCollection.add("Erro: chave não está cadastrada.");
            }
        }

        if (lnkErrosCollection.isEmpty()) {
            this.lnkUsuario.getLnkReserva().remove(lnkReserva.getKey());
            ((Livro) this.lnkMaterial).getLnkReserva().remove(
                    lnkReserva.getKey());
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
