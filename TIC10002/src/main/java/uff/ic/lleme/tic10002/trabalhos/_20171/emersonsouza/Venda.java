package uff.ic.lleme.tic10002.trabalhos._20171.emersonsouza;

public class Venda {

    public int filial;
    public int anoMes;
    public int codVendedor;
    public double totalVendido;

    public Venda(String filial, String ano_mes, String cod_vendedor, String total_vendido) {
        this.filial = Integer.parseInt(filial);
        this.anoMes = Integer.parseInt(ano_mes);
        this.codVendedor = Integer.parseInt(cod_vendedor);
        this.totalVendido = Double.parseDouble(total_vendido);
    }

    public void printVenda(Venda dado) {
        System.out.println("Filial: " + this.filial + "\n"
                + "Data: " + this.anoMes + "\n"
                + "Código do Vendedor: " + this.codVendedor + "\n"
                + "Total Vendido: " + this.totalVendido + "\n");
    }

    public int getValor(int value) {
        if (value == 1)
            return filial;
        else if (value == 2)
            return anoMes;
        else
            return 0;
    }
}
