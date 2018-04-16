package uff.ic.lleme.tcc00328.provas.s20152.vr20152;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Disciplina implements Serializable {

    public String codigo;
    public String name;
    public Map<String, Turma> turmas = new HashMap<>();

    public Disciplina(String codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }

    public Turma criarTurma(String codigo) {
        Turma turma;
        if (!turmas.containsKey(codigo)) {
            turma = new Turma(codigo);
            turmas.put(codigo, turma);
        } else
            turma = turmas.get(codigo);
        return turma;
    }

    public Turma getTurma(String turma) {
        return turmas.get(turma);
    }
}
