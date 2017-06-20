package uff.ic.biblioteca.oldmodel;

import java.util.Calendar;

public class AlunoGraduacao extends Usuario {

    private static final long serialVersionUID = -1406526687145733381L;
    public static int qtdEmprestimo;
    public static int tempoEmprestimo;

    public AlunoGraduacao() {
        setAdmissao(Calendar.getInstance().getTime());
    }

    public int getQtdEmprestimo() {
        return AlunoGraduacao.qtdEmprestimo;
    }

    public int getTempoEmprestimo() {
        return AlunoGraduacao.tempoEmprestimo;
    }
}
