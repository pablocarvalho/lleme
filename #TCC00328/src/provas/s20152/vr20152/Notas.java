package provas.s20152.vr20152;

import java.io.Serializable;

class Notas implements Serializable {

    public float p1;
    public float p2;
    public Aluno aluno;

    public Notas(float p1, float p2, Aluno aluno) {
        this.p1 = p1;
        this.p2 = p2;
        this.aluno = aluno;
    }

    public String situacao() {
        if (media() >= 6)
            return "Aprovado";
        else
            return "Reprovado";
    }

    public float media() {
        return (p1 + p2) / 2;
    }
}
