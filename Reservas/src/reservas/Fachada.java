package reservas;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fachada {
    /**
     * @attribute
     */
    private static Set<Hotel> hoteis = new HashSet<Hotel>();
    public Hotel hotel = null;

    public Erro checkIn(int identidade, String nome, long tel, String endereco, String nacionalidade, Date inicio,
                        Date fim) {
        return null;
    }

    public Erro checkIn(int numeroReserva, int identidade, String nome, long tel, String endereco,
                        String nacionalidade) {
        return null;
    }

    public void checkOut(int identidade) {
    }

    private boolean validaReserva(Periodo periodo, Map<TipoQuarto,Integer> pedido) {
        return false;
    }

    public Erro reserva(int identidade, String nomeCliente, int tel, String nomeHotel, Date inicio, Date fim,
                        Map<String, Integer> quartos) {
        return null;
    }
}
