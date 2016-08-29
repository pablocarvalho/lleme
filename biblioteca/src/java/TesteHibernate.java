
import uff.ic.biblioteca.DAO.DAOHibernateUtil;
import uff.ic.biblioteca.model.Livro;
import uff.ic.biblioteca.model.Material;
import uff.ic.biblioteca.model.Operacao;
import uff.ic.biblioteca.model.Reserva;
import uff.ic.biblioteca.model.Tipo;
import uff.ic.biblioteca.model.Usuario;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luiz Leme
 */
public class TesteHibernate {

    public static void main(String[] args) {
        Session session1 = DAOHibernateUtil.getSessionFactory().getCurrentSession();
        session1.beginTransaction();
        Tipo aluno = new Tipo(1, "Aluno Grad.");
        session1.save(aluno);
        Usuario u1 = new Usuario(123, aluno, "Luiz");
        session1.save(u1);
        Material m1 = new Material(1l, "Engenharia de Software");
        session1.save(m1);
        Livro l1 = new Livro(1l, m1);
        session1.save(l1);
        Operacao op1 = new Operacao(1, u1, Calendar.getInstance().getTime());
        session1.save(op1);
        Reserva r1 = new Reserva(1, op1, l1);
        session1.save(r1);
        session1.getTransaction().commit();

        Session session2 = DAOHibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();
        List<Livro> livros = session2.createQuery("from Livro where material_codigo=1").list();
        for (Livro l : livros) {
            System.out.println(l.getMaterial().getTitulo());
            Set<Reserva> sr = l.getReservas();
            for (Reserva r : sr) {
                System.out.println(r.getOperacao().getUsuario().getNome());
                System.out.println(r.getOperacao().getData().toString());
            }
        }
        session2.getTransaction().commit();

    }
}
