package patterns.singleton;

import java.util.HashSet;
import java.util.Set;

public class UFF {

    private static UFF uff = null;
    private Set<Aluno> alunos = new HashSet<Aluno>();

    private UFF() {
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    static UFF instance() {

        if (uff == null)
            UFF.uff = new UFF();
        return uff;
    }
}
