package uff.ic.biblioteca.oldmodel;

import java.util.Calendar;

public class AlunoPosGraduacao extends Usuario {

    private static final long serialVersionUID = 5847142664349103701L;
    public static int qtdEmprestimo;
    public static int tempoEmprestimo;

    public AlunoPosGraduacao() {
        setAdmissao(Calendar.getInstance().getTime());
    }

    public int getQtdEmprestimo() {
        return AlunoPosGraduacao.qtdEmprestimo;
    }

    public int getTempoEmprestimo() {
        return AlunoPosGraduacao.tempoEmprestimo;
    }
}
