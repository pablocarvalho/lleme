/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Wagner_Oliveira;

import java.util.Objects;

/**
 *
 * @author wagnerluizoliveiradossantos
 */
public class Venda implements TemChave<Integer> {

    private Integer id;
    private Integer filial;
    private String anoMes;
    private Integer codVend;
    private double totalVendido;

    public Venda(Integer id, Integer filial, String anoMes, Integer codVend, double totalVendido) {
        this.id = id;
        this.filial = filial;
        this.anoMes = anoMes;
        this.codVend = codVend;
        this.totalVendido = totalVendido;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public String getAnoMes() {
        return anoMes;
    }

    public void setAnoMes(String anoMes) {
        this.anoMes = anoMes;
    }

    public int getCodVend() {
        return codVend;
    }

    public void setCodVend(Integer codVend) {
        this.codVend = codVend;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido) {
        this.totalVendido = totalVendido;
    }

    public Integer getChave() {
        /*  String chave=filial.toString().concat(anoMes).concat(new Integer(codVend).toString());
        int hash = 7;
        for (int i = 0; i < chave.length(); i++) {
            char character = chave.charAt(i);
            int ascii = (int) character;
            hash = hash * 31 + ascii;
        }
        return hash;
         */
        return id;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", filial=" + filial + ", anoMes=" + anoMes + ", totalVendido=" + totalVendido + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Venda other = (Venda) obj;
        if (this.filial != other.filial)
            return false;
        if (!Objects.equals(this.anoMes, other.anoMes))
            return false;
        if (this.codVend != other.codVend)
            return false;
        if (Double.doubleToLongBits(this.totalVendido) != Double.doubleToLongBits(other.totalVendido))
            return false;
        return true;
    }

}
