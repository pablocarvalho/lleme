package aulas.polimorfismo.listbox;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ColecaoDeProfessores implements SelecionavelPorNome {

    private Collection<Professor> colecao = new HashSet<>();

    public ColecaoDeProfessores() {
    }

    public void add(Professor professor) {
        colecao.add(professor);
    }

    @Override
    public Iterator<Nomeavel> getIteratorPorNome(String nome) {
        Collection<Nomeavel> resultado = new HashSet<>();
        for (Professor professor : colecao)
            if (professor.getNome().contains(nome))
                resultado.add(professor);
        return resultado.iterator();
    }
}
