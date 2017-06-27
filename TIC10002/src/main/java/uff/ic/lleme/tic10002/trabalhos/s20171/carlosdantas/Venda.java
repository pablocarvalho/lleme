package uff.ic.lleme.tic10002.trabalhos.s20171.carlosdantas;

/**
 *
 * @author Carlos
 */
public class Venda {

    private float valor;
    private int id_vendedor;
    private int id_loja;
    private MesAno mesAno;

    public Venda(int id_loja, MesAno mesAno, int id_vendedor, float valor) {
        this.valor = valor;
        this.id_vendedor = id_vendedor;
        this.id_loja = id_loja;
        this.mesAno = mesAno;
    }

    public float getValor() {
        return valor;
    }

    public int getIdLoja() {
        return id_loja;
    }

    public MesAno getMesAno() {
        return mesAno;
    }

    public String toString() {
        return "Id_Filial = " + id_loja + "MesAno = " + mesAno + "Valor = " + valor;
    }
}
