package aulas.polimorfismo.listbox;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ColecaoDeAlunos implements SelecionavelPorNome {

    private Collection<Aluno> colecao = new HashSet<>();

    public ColecaoDeAlunos() {
    }

    public void add(Aluno aluno) {
        colecao.add(aluno);
    }

    @Override
    public Iterator<Nomeavel> getIteratorPorNome(String nome) {
        Collection<Nomeavel> resultado = new HashSet<>();
        for (Aluno aluno : colecao)
            if (aluno.getNome().contains(nome))
                resultado.add(aluno);
        return resultado.iterator();
    }
}
