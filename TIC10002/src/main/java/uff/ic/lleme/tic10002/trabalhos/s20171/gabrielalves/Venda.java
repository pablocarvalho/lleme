package uff.ic.lleme.tic10002.trabalhos.s20171.gabrielalves;

public class Venda {

    public int filial;
    public int ano_mes;
    public int cod_vendedor;
    public double total_vendido;

    public Venda(String filial, String ano_mes, String cod_vendedor, String total_vendido) {
        this.filial = Integer.parseInt(filial);
        this.ano_mes = Integer.parseInt(ano_mes);
        this.cod_vendedor = Integer.parseInt(cod_vendedor);
        this.total_vendido = Double.parseDouble(total_vendido);
    }

    public int getValor(int valor) {
        if (valor == 1)
            return filial;
        else if (valor == 2)
            return ano_mes;
        else
            return 0;
    }
}
