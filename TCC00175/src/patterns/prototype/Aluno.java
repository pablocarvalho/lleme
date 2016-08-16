package patterns.prototype;

import java.util.HashSet;
import java.util.Set;

public class Aluno extends Prototipo {

    private int matricula = 0;
    private String nome = null;
    private Set<String> disciplinas = new HashSet<String>();

    @Override
    public Aluno clone() throws CloneNotSupportedException {
        return (Aluno) super.clone();
    }

    // Deep cloning 1
    protected Prototipo deepCloningCustomizada() throws CloneNotSupportedException {
        Aluno clone = (Aluno) super.clone();
        clone.disciplinas = new HashSet<String>();
        for (String valor : disciplinas)
            clone.disciplinas.add(valor + "");
        return clone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return matricula;
    }

    public void setId(int id) {
        this.matricula = id;
    }

    public Set<String> getColecao() {
        return disciplinas;
    }
}
