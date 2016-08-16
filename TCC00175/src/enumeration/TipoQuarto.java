package enumeration;

import java.util.HashSet;
import java.util.Set;

public enum TipoQuarto {

    SIMPLES, DUPLO, SUITE;
    public Set<Quarto> quartos = new HashSet<Quarto>();

    public Set<Quarto> getQuartos() {
        return quartos;
    }
}
