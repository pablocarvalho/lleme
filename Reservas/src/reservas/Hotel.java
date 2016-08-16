package reservas;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Hotel {
    /**
     * @attribute
     */
    public String nome;

    /**
     * @associates <{reservas.Quarto}>
     */
    public Collection quartos = new HashSet<Quarto>();

    /**
     * @associates <{reservas.Reserva}>
     */
    public Collection reservas = new TreeSet<Reserva>();

    public Hotel(String nome) {
    }

    public Set<Quarto> listaQuartosDisponiveis(Reserva reserva) {
        return null;
    }

    public Set<Quarto> listaQuartosDisponiveis() {
        return null;
    }

    public Map<TipoQuarto, Integer> listaCapacidade() {
        return null;
    }

    public Set<Operacao> listaOperacoesDistintas(Periodo periodo) {
        return null;
    }
}
