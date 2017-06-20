package uff.ic.lleme.tic10002.trabalhos._20171.paulolacerda;

public class Venda {

    private int filial;
    private int date;
    private int vendedor;
    private double total;

    Venda(int filial, int date, int vendedor, double total) {
        this.filial = filial;
        this.date = date;
        this.vendedor = vendedor;
        this.total = total;
    }

    public int getFilial() {
        return this.filial;
    }

    public int getDate() {
        return this.date;
    }

    public int getVendedor() {
        return this.vendedor;
    }

    public double getTotal() {
        return this.total;
    }

    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append(this.filial).append(" ")
                .append(this.date).append(" ")
                .append(this.vendedor).append(" ")
                .append(this.total)
                .toString();
        return retorno.toString();
    }

    // test
    public static void main(String args[]) {
        Venda venda = new Venda(01, 201701, 01, 100);
        System.out.println(venda);
    }
}
