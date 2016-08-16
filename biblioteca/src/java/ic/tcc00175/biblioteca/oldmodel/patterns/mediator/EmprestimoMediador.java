package ic.tcc00175.biblioteca.oldmodel.patterns.mediator;

import ic.tcc00175.biblioteca.oldmodel.Emprestimo;
import ic.tcc00175.biblioteca.oldmodel.Exemplar;
import ic.tcc00175.biblioteca.oldmodel.Livro;
import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.factory.Factory;

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
            this.lnkErrosCollection.add("Erro: usuario não cadastrado.");
        } else {
            this.lnkEmprestimo.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera exemplar
        this.lnkExemplar = this.lnkExemplarMediator.getExemplar(request,
                lnkErrosCollection);
        if (lnkExemplar == null) {
            lnkErrosCollection.add("Erro: exemplar não cadastrado.");
        } else if (this.lnkExemplar.getLnkEmprestimo() != null) {
            lnkErrosCollection.add("Erro: exemplar já emprestado.");
        } else {
            this.lnkEmprestimo.setLnkrevExemplar(lnkExemplar);
        }

        // Recupera material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material não cadastrado.");
        }

        // Verifica se há outro emprestimo para o mesmo material
        if (lnkMaterial != null) {
            if (lnkUsuario.getLnkEmprestimo().containsEmprestado(lnkMaterial)) {
                lnkErrosCollection.add("Erro: outro exemplar do mesmo material já está emprestado para o usuario.");
            }
        }

        // Verifica se há emprestimo atrasado
        if (lnkUsuario.getLnkEmprestimo().containsAtraso()) {
            lnkErrosCollection.add("Erro: há um emprestimo atrasado para o usuario.");
        }

        // Verifica se o limite de emprestimos foi atingido
        if (lnkUsuario.atingiuLimiteEmprestimo()) {
            lnkErrosCollection.add("Erro: usuario atingiu o número máximo de emprestimos permitido.");
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
                        lnkErrosCollection.add("Erro: número exemplares disponíveis menor do que o número de reservas.");
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
                this.lnkErrosCollection.add("Erro: chave já cadastrada.");
            }
        }

        // Inclusão da emprestimo
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
            mensagem = "OK! Inclusão realizada com sucesso.";
        } else {
            Iterator iter = this.lnkErrosCollection.iterator();
            mensagem = "Inclusão mal sucedida!";
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
            lnkErrosCollection.add("Erro: usuario não cadastrado.");
        } else {
            this.lnkEmprestimo.setLnkrevUsuario(lnkUsuario);
        }

        // Recupera exemplar
        this.lnkExemplar = this.lnkExemplarMediator.getExemplar(request,
                lnkErrosCollection);
        if (lnkExemplar == null) {
            lnkErrosCollection.add("Erro: exemplar não cadastrado.");
        } else {
            this.lnkEmprestimo.setLnkrevExemplar(lnkExemplar);
        }

        // Verifica chave não cadastrada
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
            mensagem = "OK! Remoção realizada com sucesso.";
        } else {
            Iterator iter = lnkErrosCollection.iterator();
            mensagem = "Remoção mal sucedida!";
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
            this.lnkErrosCollection.add("Erro: usuario não cadastrado.");
        }

        // Recupera Material
        this.lnkMaterial = this.lnkMaterialMediator.getMaterial(request,
                lnkErrosCollection);
        if (lnkMaterial == null) {
            lnkErrosCollection.add("Erro: material não cadastrado.");
        }

        // Verifica se material está emprestado
        if (!this.lnkUsuario.getLnkEmprestimo().isEmprestado(lnkMaterial)) {
            this.lnkErrosCollection.add("Erro: material não está emprestado.");
        }

        // Devolução
        if (lnkErrosCollection.isEmpty()) {
            this.lnkUsuario.getLnkEmprestimo().setDevolucao(lnkMaterial);
            this.lnkSistema.save();
            mensagem = "OK! Devolução realizada com sucesso.";
        } else {
            Iterator iter = this.lnkErrosCollection.iterator();
            mensagem = "Devolução mal sucedida!";
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
