package uff.ic.lleme.tic10002.trabalhos.s20171.cleirissonsilva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author clerissonss
 */
public class Venda {

    //atributos
    private int cod_filial;
    private int ano_mes;
    private int cod_vendedor;
    private double Total_Vendido;

    /**
     * @return the cod_filial
     */
    public int getCod_filial() {
        return cod_filial;
    }

    /**
     * @param cod_filial the cod_filial to set
     */
    public void setCod_filial(int cod_filial) {
        this.cod_filial = cod_filial;
    }

    /**
     * @return the ano_mes
     */
    public int getAno_mes() {
        return ano_mes;
    }

    /**
     * @param ano_mes the ano_mes to set
     */
    public void setAno_mes(int ano_mes) {
        this.ano_mes = ano_mes;
    }

    /**
     * @return the cod_vendedor
     */
    public int getCod_vendedor() {
        return cod_vendedor;
    }

    /**
     * @param cod_vendedor the cod_vendedor to set
     */
    public void setCod_vendedor(int cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    /**
     * @return the vendas
     */
    public double getTotalVendido() {
        return Total_Vendido;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setTotalVendido(double vendas) {
        this.Total_Vendido = vendas;
    }

}
