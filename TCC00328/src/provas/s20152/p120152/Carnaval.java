package provas.s20152.p120152;

import java.util.HashSet;
import java.util.Set;

public class Carnaval {

    public int ano = 0;
    public final Set<Escola> escolas = new HashSet<>();
    private final Set<Jurado> jurados = new HashSet<>();

    public void registrarJurado(Jurado jurado) throws Exception {
        verificarDuplicidadeJurado(jurado);
        verificarLimiteJurados(jurado);
        jurados.add(jurado);
    }

    void registrarEscola(Escola escola) throws Exception {
        verificarDuplicidadeEscola(escola);
        escolas.add(escola);
    }

    private void verificarDuplicidadeJurado(Jurado jurado) throws Exception {
        for (Jurado j : jurados)
            if (j.nome.equals(jurado.nome))
                throw new Exception("Jurado já foi registrado.");
    }

    private void verificarDuplicidadeEscola(Escola escola) throws Exception {
        for (Escola e : escolas)
            if (e.nome.equals(escola.nome))
                throw new Exception("Escola já foi registrada.");
    }

    private void verificarLimiteJurados(Jurado jurado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
