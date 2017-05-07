package uff.ic.tcc00328.aulas.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkMean extends RecursiveAction {

    private int mInicio = 0;
    private int mTamanho = 0;
    private List<Aluno> mAlunos = new ArrayList<>();

    public ForkMean(List<Aluno> alunos, int inicio, int tamanho) {
        mAlunos = alunos;
        mInicio = inicio;
        mTamanho = tamanho;
    }

    protected void computeDirectly() {
        Aluno aluno;
        for (int i = mInicio; i < mInicio + mTamanho; i++) {
            aluno = mAlunos.get(i);
            aluno.media = (aluno.n1 + aluno.n2) / 2;
        }
    }
    protected static int sLimite = 1000000;

    @Override
    protected void compute() {
        if (mTamanho < sLimite) {
            computeDirectly();
            return;
        }
        int split = mTamanho / 2;
        invokeAll(new ForkMean(mAlunos, mInicio, split),
            new ForkMean(mAlunos, mInicio + split, mTamanho - split));
    }
}
