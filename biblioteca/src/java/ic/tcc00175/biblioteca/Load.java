package ic.tcc00175.biblioteca;

import ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao;
import ic.tcc00175.biblioteca.oldmodel.AlunoPosGraduacao;
import ic.tcc00175.biblioteca.oldmodel.Biblioteca;
import ic.tcc00175.biblioteca.oldmodel.CD;
import ic.tcc00175.biblioteca.oldmodel.Emprestimo;
import ic.tcc00175.biblioteca.oldmodel.Exemplar;
import ic.tcc00175.biblioteca.oldmodel.Livro;
import ic.tcc00175.biblioteca.oldmodel.Login;
import ic.tcc00175.biblioteca.oldmodel.Professor;
import ic.tcc00175.biblioteca.oldmodel.Reserva;
import ic.tcc00175.biblioteca.oldmodel.Revista;
import ic.tcc00175.biblioteca.oldmodel.Sistema;
import ic.tcc00175.biblioteca.oldmodel.Usuario;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.ExemplarColecao;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.MaterialColecao;
import ic.tcc00175.biblioteca.oldmodel.patterns.adapter.UsuarioColecao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Load {

    public Load(Sistema sistema) {
        HashMap logins = sistema.getLnkLogin();
        Login login = new Login();
        login.setId("admin");
        login.setNome("Administrador");
        login.setSenha("admin");
        logins.put(login.getId(), login);

        UsuarioColecao usuarios = sistema.getLnkUsuario();
        Usuario usuario = new AlunoGraduacao();
        usuario.setId(1);
        usuario.setNome("João da Silva");
        usuarios.put(usuario);
        usuario = new AlunoPosGraduacao();
        usuario.setId(2);
        usuario.setNome("Luiz Fernando Rodrigues");
        usuarios.put(usuario);
        usuario = new Professor();
        usuario.setId(3);
        usuario.setNome("Carlos Jose Pereira de Lucena");
        usuarios.put(usuario);

        HashMap bibliotecas = sistema.getLnkBiblioteca();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("Informática");
        bibliotecas.put(biblioteca.getNome(), biblioteca);

        MaterialColecao materiais = biblioteca.getLnkMaterial();
        Livro livro = new Livro();
        ExemplarColecao exemplares = livro.getLnkExemplar();
        livro.setCodigo(100);
        livro.setTitulo("Engenharia de Software");
        livro.setEditora("Addison Wesley");
        livro.setAutores("Ian Sommerville");
        livro.setEdicao(6);
        livro.setAnoPublicacao(2000);
        Exemplar exemplar = new Exemplar();
        exemplar.setNum(1);
        exemplar.setLnkrevMaterial(livro);
        exemplares.put(exemplar);
        exemplar = new Exemplar();
        exemplar.setNum(2);
        exemplar.setLnkrevMaterial(livro);
        exemplares.put(exemplar);
        materiais.put(livro);

        livro = new Livro();
        exemplares = livro.getLnkExemplar();
        livro.setCodigo(101);
        livro.setTitulo("UML Guia do Usuário");
        livro.setEditora("Campus");
        livro.setAutores("Grady Booch, James Rumbaugh, Ivar Jacobson");
        livro.setEdicao(7);
        livro.setAnoPublicacao(2000);
        exemplar = new Exemplar();
        exemplar.setNum(3);
        exemplar.setLnkrevMaterial(livro);
        exemplares.put(exemplar);
        materiais.put(livro);

        // Livros acrescentados para o teste do limite de reserva
        livro = new Livro();
        exemplares = livro.getLnkExemplar();
        livro.setCodigo(102);
        livro.setTitulo("Livro 3");
        livro.setEditora("Campus");
        livro.setAutores("Grady Booch, James Rumbaugh, Ivar Jacobson");
        livro.setEdicao(7);
        livro.setAnoPublicacao(2000);
        exemplar = new Exemplar();
        exemplar.setNum(4);
        exemplar.setLnkrevMaterial(livro);
        exemplares.put(exemplar);
        materiais.put(livro);

        Exemplar exemplarEmprestimo = exemplar;

        livro = new Livro();
        exemplares = livro.getLnkExemplar();
        livro.setCodigo(103);
        livro.setTitulo("Livro 4");
        livro.setEditora("Campus");
        livro.setAutores("Grady Booch, James Rumbaugh, Ivar Jacobson");
        livro.setEdicao(7);
        livro.setAnoPublicacao(2000);
        exemplar = new Exemplar();
        exemplar.setNum(5);
        exemplar.setLnkrevMaterial(livro);
        exemplares.put(exemplar);
        materiais.put(livro);
        // ----------------------

        Revista revista = new Revista();
        exemplares = revista.getLnkExemplar();
        revista.setCodigo(200);
        revista.setTitulo("IEEE Transactions in Software Engineering");
        revista.setNumero(53);
        revista.setMes("Setembro");
        revista.setAno(2005);
        exemplar = new Exemplar();
        exemplar.setNum(6);
        exemplar.setLnkrevMaterial(revista);
        exemplares.put(exemplar);
        exemplar = new Exemplar();
        exemplar.setNum(7);
        exemplar.setLnkrevMaterial(revista);
        exemplares.put(exemplar);
        materiais.put(revista);

        CD cd = new CD();
        exemplares = cd.getLnkExemplar();
        cd.setCodigo(300);
        cd.setTitulo("Nós vamos invadir a tua praia");
        cd.setAutores("Ultraje a Rigor");
        cd.setAno(1990);
        exemplar = new Exemplar();
        exemplar.setNum(8);
        exemplar.setLnkrevMaterial(cd);
        exemplares.put(exemplar);
        materiais.put(cd);

        Reserva reserva = new Reserva();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            reserva.setData(data.parse("04/10/2005"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reserva.setLnkrevLivro(livro);
        reserva.setLnkrevUsuario(usuario);
        livro.getLnkReserva().put(reserva);
        usuario.getLnkReserva().put(reserva);

        Emprestimo emprestimo = new Emprestimo();
        data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            emprestimo.setData(data.parse("06/10/2005"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        emprestimo.setLnkrevExemplar(exemplarEmprestimo);
        emprestimo.setLnkrevUsuario(usuario);
        exemplarEmprestimo.setLnkEmprestimo(emprestimo);
        usuario.getLnkEmprestimo().put(emprestimo);

        sistema.save();
    }
}
