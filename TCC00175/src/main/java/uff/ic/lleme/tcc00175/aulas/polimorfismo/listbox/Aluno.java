package uff.ic.lleme.tcc00175.aulas.polimorfismo.listbox;

public class Aluno implements Nomeavel {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome.trim();
    }
}
