package uff.ic.tcc00328.aulas.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MainForkMean {

    public static void main(String[] args) throws InterruptedException {
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno;
        for (int i = 0; i < 10000000; i++) {
            aluno = new Aluno();
            aluno.n1 = Math.random() * 11;
            aluno.n2 = Math.random() * 11;
            alunos.add(aluno);
        }
        System.out.println("inicializado.");
        //
        //
        Date inicio = new Date();
        for (int i = 0; i < alunos.size(); i++) {
            aluno = alunos.get(i);
            aluno.media = (aluno.n1 + aluno.n2) / 2;
        }
        System.out.printf("primeiro metodo: %d milisegundos%n", (new Date().getTime()
            - inicio.getTime()));
        //
        //
        inicio = new Date();
        ForkMean fb = new ForkMean(alunos, 0, alunos.size());
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fb);
        System.out.printf("segundo metodo: %d milisegundos%n", (new Date().getTime()
            - inicio.getTime()));
    }
}
