package reservas;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

public class Reserva extends Operacao {
    /**
     * @attribute
     */
    public int numero;

    /**
     * @attribute
     */
    public Date criacao;

    /**
     * @associates <{reservas.ItemReserva}>
     */
    public Collection itens = new HashSet<ItemReserva>();

    /**
     * @associates <{reservas.Hospedagem}>
     */
    public Collection hospedagens;
    public Cliente responsavel;

    public Reserva(Cliente cliente, Periodo periodo, Map<TipoQuarto, Integer> pedido) {
    }
}
