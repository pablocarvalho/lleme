package uff.ic.lleme.tcc00328.provas.s20152.vr20152;

import java.io.Serializable;

public class Aluno implements Serializable {

    public String matricula;
    public String nome;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
}
