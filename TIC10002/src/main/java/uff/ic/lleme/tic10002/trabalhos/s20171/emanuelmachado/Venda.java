package uff.ic.lleme.tic10002.trabalhos.s20171.emanuelmachado;

public final class Venda {

    private int filial;
    private String ano_mes;
    private int cod_vendedor;
    private double total;

    Venda(int filial, String ano_mes, int vendedor, double total) {
        setFilial(filial);
        setAno_mes(ano_mes);
        setCod_vendedor(vendedor);
        setTotal(total);
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int id_filial) {
        this.filial = id_filial;
    }

    public int getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(int vendedor) {
        this.cod_vendedor = vendedor;
    }

    public String getAno_mes() {
        return ano_mes;
    }

    public void setAno_mes(String ano_mes) {
        this.ano_mes = ano_mes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
