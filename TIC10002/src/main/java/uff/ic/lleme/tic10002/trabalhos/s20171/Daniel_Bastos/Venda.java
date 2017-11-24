package uff.ic.lleme.tic10002.trabalhos.s20171.Daniel_Bastos;

public class Venda {

    int key;
    int filial;
    int ano_mes;
    int cod_vendedor;
    double total_vendido;

    public Venda(int f, int year, int month, int cod, double total) {
        filial = f;
        ano_mes = year * 100 + month;
        key = ano_mes;
        cod_vendedor = cod;
        total_vendido = total;
    }

    @Override
    public String toString() {
        String ret = String.format(
                "Venda(key %d filial %d, mês %d, R$: %.2f vendedor %d)",
                key, filial, ano_mes, total_vendido, cod_vendedor);
        return ret;
    }

}
