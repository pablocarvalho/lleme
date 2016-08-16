package exercicios.reservas;

import java.util.Collection;

public class Cliente {

    /**
     * @attribute ss
     */
    public int identidade;
    /**
     * @attribute
     */
    public String nome;
    /**
     * @attribute
     */
    public long telefone;
    /**
     * @associates <{reservas.Reserva}>
     */
    public Collection reservas;

    public Cliente(int identidade, String nome, long tel) {
    }
}
