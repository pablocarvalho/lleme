package provas.s20141.p120141;

import java.io.Serializable;

public class Aluno implements Serializable {

    public int matricula = 0;
    public String nome = null;

    public Aluno(int matricula) {
        this.matricula = matricula;
    }
}
