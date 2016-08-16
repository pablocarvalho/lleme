package exercicios.reservas;

import java.util.Collection;
import java.util.HashSet;

public class Quarto {

    /**
     * @attribute
     */
    public int numero = 0;
    public TipoQuarto tipo = null;
    /**
     * @associates <{reservas.Hospedagem}>
     */
    public Collection hospedes = new HashSet<Hospedagem>();

    public boolean estaDisponivel() {
        return false;
    }
}
