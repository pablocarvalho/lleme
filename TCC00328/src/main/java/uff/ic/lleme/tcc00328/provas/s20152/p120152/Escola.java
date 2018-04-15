package uff.ic.lleme.tcc00328.provas.s20152.p120152;

import java.util.HashSet;
import java.util.Set;

public class Escola {

    public String nome = null;
    public final Set<Nota> notas = new HashSet<>();

    private Escola() {
    }

    public Escola(String nome) {
        this.nome = nome;
    }

    public void registrarNota(Nota nota) throws Exception {
        verificarQuantidadeNotas(nota);
        notas.add(nota);
    }

    private void verificarQuantidadeNotas(Nota nota) throws Exception {
        int qtd = 1;
        for (Nota n : notas)
            if (n.quesito == nota.quesito) {
                qtd++;
                if (qtd > 3)
                    throw new Exception("Limite de notas para o quesito excedido.");
            }
    }
}
