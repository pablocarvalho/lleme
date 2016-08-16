package ic.tcc00175.biblioteca.oldmodel.patterns.factory;

import ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao;
import ic.tcc00175.biblioteca.oldmodel.AlunoPosGraduacao;
import ic.tcc00175.biblioteca.oldmodel.Emprestimo;
import ic.tcc00175.biblioteca.oldmodel.Exemplar;
import ic.tcc00175.biblioteca.oldmodel.Livro;
import ic.tcc00175.biblioteca.oldmodel.Material;
import ic.tcc00175.biblioteca.oldmodel.Professor;
import ic.tcc00175.biblioteca.oldmodel.Reserva;
import ic.tcc00175.biblioteca.oldmodel.Revista;
import ic.tcc00175.biblioteca.oldmodel.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

public class Factory {

    public static Usuario createUsuario(HttpServletRequest request,
            HashSet mensagens) {
        Usuario lnkUsuario = null;
        if (request.getParameter("classe").equals("AlunoGraduacao")) {
            lnkUsuario = new AlunoGraduacao();
        } else if (request.getParameter("classe").equals("AlunoPosGraduacao")) {
            lnkUsuario = new AlunoPosGraduacao();
        } else if (request.getParameter("classe").equals("Professor")) {
            lnkUsuario = new Professor();
        }
        try {
            lnkUsuario.setId((new Long(request.getParameter("id"))).longValue());
        } catch (NumberFormatException numExcp) {
            mensagens.add("Erro: formato inválido para o Id.");
        }
        lnkUsuario.setNome(request.getParameter("nome"));
        lnkUsuario.setLogradouro(request.getParameter("logradouro"));
        lnkUsuario.setComplemento(request.getParameter("complemento"));
        lnkUsuario.setBairro(request.getParameter("bairro"));
        lnkUsuario.setCidade(request.getParameter("cidade"));
        // try {
        // lnkUsuario.setCep((new Integer(request.getParameter("cep")))
        // .intValue());
        // } catch (NumberFormatException numExcp) {
        // mensagens.add("Erro: formato inválido para o Cep.");
        // }
        // try {
        // lnkUsuario.setTelefone((new Long(request.getParameter("telefone")))
        // .longValue());
        // } catch (NumberFormatException numExcp) {
        // mensagens.add("Erro: formato inválido para o Telefone.");
        // }
        // try {
        // lnkUsuario.setCelular((new Long(request.getParameter("celular")))
        // .longValue());
        // } catch (NumberFormatException numExcp) {
        // mensagens.add("Erro: formato inválido para o Celular.");
        // }
        lnkUsuario.setEmail(request.getParameter("email"));
        // try {
        // lnkUsuario.setCpf((new Long(request.getParameter("cpf")))
        // .longValue());
        // } catch (NumberFormatException numExcp) {
        // mensagens.add("Erro: formato inválido para o CPF.");
        // }
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            lnkUsuario.setAdmissao(new Date(data.parse(
                    request.getParameter("admissao")).getTime()));
        } catch (ParseException dtExcp) {
            mensagens.add("Erro: formato inválido para a data de admissão.");
        }
        if (request.getParameter("cancelamento").equals("")) {
            lnkUsuario.setCancelamento(null);
        } else {
            try {
                lnkUsuario.setCancelamento(new Date(data.parse(
                        request.getParameter("cancelamento")).getTime()));
            } catch (ParseException dtExcp) {
                mensagens.add("Erro: formato inválido para a data de cancelamento.");
            }
        }
        return lnkUsuario;
    }

    @SuppressWarnings("unchecked")
    public static Object createKeyUsuario(HttpServletRequest request,
            HashSet mensagens) {
        Usuario lnkUsuario = new AlunoGraduacao();
        try {
            lnkUsuario.setId((new Long(request.getParameter("id"))).longValue());
        } catch (NumberFormatException numExcp) {
            mensagens.add("Erro: formato inválido para o Id.");
        }
        return lnkUsuario.getKey();
    }

    @SuppressWarnings("unchecked")
    public static Reserva createReserva(HttpServletRequest request,
            HashSet mensagens) {
        Reserva lnkReserva = new Reserva();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            lnkReserva.setData(data.parse(request.getParameter("data")));
        } catch (ParseException dtExcp) {
            mensagens.add("Erro: formato inválido para a data.");
        }
        return lnkReserva;
    }

    @SuppressWarnings("unchecked")
    public static Object createKeyReserva(HttpServletRequest request,
            Usuario usuario, Livro livro, HashSet mensagens) {
        Reserva lnkReserva = new Reserva();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            lnkReserva.setData(data.parse(request.getParameter("data")));
        } catch (ParseException dtExcp) {
            mensagens.add("Erro: formato inválido para a data de admissão.");
        }
        lnkReserva.setLnkrevLivro(livro);
        lnkReserva.setLnkrevUsuario(usuario);
        return lnkReserva.getKey();
    }

    @SuppressWarnings("unchecked")
    public static Object createKeyMaterial(HttpServletRequest request,
            HashSet mensagens) {
        Material lnkMaterial = new Revista();
        try {
            lnkMaterial.setCodigo((new Long(request.getParameter("codigo"))).longValue());
        } catch (NumberFormatException numExcp) {
            mensagens.add("Erro: formato inválido para o codigo.");
        }
        return lnkMaterial.getKey();
    }

    @SuppressWarnings("unchecked")
    public static Emprestimo createEmprestimo(HttpServletRequest request,
            HashSet mensagens) {
        Emprestimo lnkEmprestimo = new Emprestimo();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            lnkEmprestimo.setData(data.parse(request.getParameter("data")));
        } catch (ParseException dtExcp) {
            mensagens.add("Erro: formato inválido para a data.");
        }
        return lnkEmprestimo;
    }

    @SuppressWarnings("unchecked")
    public static Exemplar createKeyExemplar(HttpServletRequest request,
            HashSet mensagens) {
        Exemplar lnkExemplar = new Exemplar();
        try {
            lnkExemplar.setNum((new Integer(request.getParameter("num"))).intValue());
        } catch (NumberFormatException numExcp) {
            mensagens.add("Erro: formato inválido para o Id.");
        }
        return lnkExemplar;
    }
}
