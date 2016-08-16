package reservas;

import java.util.Collection;

public class Hospede extends Cliente {
    /**
     * @attribute
     */
    public String nacionalidade;

    /**
     * @attribute
     */
    public String endereco;

    /**
     * @associates <{reservas.Hospedagem}>
     */
    public Collection hospedagens;

    public Hospede(int identidade, String nome, long tel, String endereco, String nac) {
        super(0,"",0);
    }
}
