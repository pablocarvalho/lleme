package provas.s20152.vr20152;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Turma implements Serializable {

    public String codigo = null;
    public final Map<String, Aluno> alunos = new HashMap<>();
    public final Map<String, Notas> notas = new HashMap<>();

    public Turma(String codigo) {
        this.codigo = codigo;
    }

    public void inscreverAluno(Aluno aluno) {
        if (!alunos.containsKey(aluno.matricula))
            this.alunos.put(aluno.matricula, aluno);
        else
            System.out.println("Aluno já cadastrado.");
    }

    public Map<String, Aluno> listAlunos() {
        return alunos;
    }

    public void incluirNotas(float p1, float p2, Aluno a) {
        if (alunos.containsKey(a.matricula))
            notas.put(a.matricula, new Notas(p1, p2, a));
        else
            System.out.println("Aluno nao esta inscrito na turma.");
    }
}
