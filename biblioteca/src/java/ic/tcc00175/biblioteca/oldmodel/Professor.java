package ic.tcc00175.biblioteca.oldmodel;

import java.util.Calendar;

public class Professor extends Usuario {

    private static final long serialVersionUID = -234871874412425160L;
    public static int qtdEmprestimo;
    public static int tempoEmprestimo;

    public Professor() {
        setAdmissao(Calendar.getInstance().getTime());
    }

    public int getQtdEmprestimo() {
        return Professor.qtdEmprestimo;
    }

    public int getTempoEmprestimo() {
        return Professor.tempoEmprestimo;
    }
}
