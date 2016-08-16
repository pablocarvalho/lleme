package reservas;

public class Hospedagem extends Operacao {
    /**
     * @attribute
     */
    public String destino;

    /**
     * @attribute
     */
    public String origem;
    public Quarto quarto;
    public Reserva reserva;

    public Hospedagem(Reserva reserva, Quarto quarto, String origem, String destino) {
    }

    public Hospedagem(Periodo periodo, Quarto quarto, String origem, String destino) {
    }
}
