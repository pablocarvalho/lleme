package provas.s20121.vs20121ex3;

import java.util.HashSet;
import java.util.Set;

public class Sujeito {

    private Set<Observador> observadores = new HashSet<>();

    public void registrar(Observador observador) {
        observadores.add(observador);
    }

    public void excluir(Observador observador) {
        observadores.remove(observador);
    }

    public void avisar() {
        for (Observador o : observadores)
            o.atualizar(this);
    }
}
