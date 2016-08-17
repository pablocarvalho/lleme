package patterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class Aluno {

    private static Map<Long, Aluno> alunos = new HashMap<Long, Aluno>();
    public long matricula;
    public String nome;

    private Aluno() {
    }

    private Aluno(long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Aluno getAluno(long matricula, String nome) {
        Aluno aluno = alunos.get(matricula);
        if (aluno == null) {
            aluno = new Aluno(matricula, nome);
            alunos.put(matricula, aluno);
        }
        return aluno;
    }
}
